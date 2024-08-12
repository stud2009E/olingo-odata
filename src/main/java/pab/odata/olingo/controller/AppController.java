package pab.odata.olingo.controller;

import com.sap.olingo.jpa.metadata.api.JPAEdmProvider;
import com.sap.olingo.jpa.metadata.api.JPAEntityManagerFactory;
import com.sap.olingo.jpa.processor.core.api.JPAODataRequestHandler;
import com.sap.olingo.jpa.processor.core.api.JPAODataServiceContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataSessionContextAccess;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.commons.api.ex.ODataException;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/demo/service.svc")
public class AppController {
    private static final String P_UNIT_NAME = "Tutorial";

    @Autowired
    private DataSource ds;

    private ODataHttpHandler metaHandler;
    private JPAODataRequestHandler dataHandler;


    @PostConstruct
    void init() throws ServletException {
        try {
            EntityManagerFactory emf = JPAEntityManagerFactory.getEntityManagerFactory(P_UNIT_NAME, new HashMap<String, Object>());
            JPAEdmProvider metadataProvider = new JPAEdmProvider(P_UNIT_NAME, emf, null,
                    new String[]{"pab.odata.olingo.entity", "pab.odata.olingo.entity.vocabulary"});
            OData odata = OData.newInstance();
            ServiceMetadata edm = odata.createServiceMetadata(metadataProvider, new ArrayList<EdmxReference>());
            metaHandler = odata.createHandler(edm);

            JPAODataSessionContextAccess serviceContext = JPAODataServiceContext.with()
                    .setPUnit(P_UNIT_NAME)
                    .setDataSource(ds)
                    .setTypePackage("pab.odata.olingo.entity", "pab.odata.olingo.entity.vocabulary")
                    .build();

            dataHandler = new JPAODataRequestHandler(serviceContext);

        } catch (ODataException e) {
            throw new ServletException(e);
        }
    }

    @GetMapping(path = {"/", "", "/$metadata"})
    void metadataHandler(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException {
        req.setAttribute("requestMapping", "/demo/service.svc");

        metaHandler.process(req, resp);
    }

    @RequestMapping("/*")
    void crudHandler(final HttpServletRequest req, final HttpServletResponse resp) throws ODataException {
        req.setAttribute("requestMapping", "/demo/service.svc");

        dataHandler.process(req, resp);
    }

    @PreDestroy
    void destroy() {
        ds = null;
    }
}
