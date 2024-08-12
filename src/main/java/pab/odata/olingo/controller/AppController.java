package pab.odata.olingo.controller;

import com.sap.olingo.jpa.metadata.api.JPAEdmProvider;
import com.sap.olingo.jpa.metadata.api.JPAEntityManagerFactory;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.commons.api.ex.ODataException;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/demo/service.svc")
public class AppController {

    private static final String P_UNIT_NAME = "Tutorial";

    @RequestMapping("**")
    void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException {
        req.setAttribute("requestMapping", "/demo/service.svc");

        try {
            EntityManagerFactory emf = JPAEntityManagerFactory.getEntityManagerFactory(P_UNIT_NAME, new HashMap<String, Object>());
            JPAEdmProvider metadataProvider = new JPAEdmProvider(P_UNIT_NAME, emf, null,
                    new String[]{"pab.odata.olingo.entity.vocabulary"});
            OData odata = OData.newInstance();

            ServiceMetadata edm = odata.createServiceMetadata(metadataProvider, new ArrayList<EdmxReference>());
            ODataHttpHandler handler = odata.createHandler(edm);


            handler.process(req, resp);
        } catch (RuntimeException | ODataException e) {
            throw new ServletException(e);
        }
    }

}
