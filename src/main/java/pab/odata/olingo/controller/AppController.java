package pab.odata.olingo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.server.api.OData;
import org.apache.olingo.server.api.ODataHttpHandler;
import org.apache.olingo.server.api.ServiceMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pab.odata.olingo.data.Storage;
import pab.odata.olingo.service.DemoEdmProvider;
import pab.odata.olingo.service.DemoEntityCollectionProcessor;
import pab.odata.olingo.service.DemoEntityProcessor;
import pab.odata.olingo.service.DemoPrimitiveProcessor;

import java.util.ArrayList;

@Controller
@RequestMapping("/DemoService/DemoService.svc")
public class AppController {

    @RequestMapping("**")
    void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException {
        req.setAttribute("requestMapping", "/DemoService/DemoService.svc");

        try {
            HttpSession session = req.getSession(true);

            Storage storage = (Storage) session.getAttribute(Storage.class.getName());
            if (storage == null) {
                storage = new Storage();
                session.setAttribute(Storage.class.getName(), storage);
            }

            // create odata handler and configure it with EdmProvider and Processor
            OData odata = OData.newInstance();
            ServiceMetadata edm = odata.createServiceMetadata(new DemoEdmProvider(), new ArrayList<EdmxReference>());
            ODataHttpHandler handler = odata.createHandler(edm);
            handler.register(new DemoEntityCollectionProcessor(storage));
            handler.register(new DemoEntityProcessor(storage));
            handler.register(new DemoPrimitiveProcessor(storage));
            // let the handler do the work
            handler.process(req, resp);
        } catch (RuntimeException e) {
            throw new ServletException(e);
        }
    }

}
