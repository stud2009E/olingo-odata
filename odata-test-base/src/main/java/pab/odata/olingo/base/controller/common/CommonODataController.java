package pab.odata.olingo.base.controller.common;

import com.sap.olingo.jpa.processor.core.api.JPAODataRequestContext;
import com.sap.olingo.jpa.processor.core.api.JPAODataRequestHandler;
import com.sap.olingo.jpa.processor.core.api.JPAODataSessionContextAccess;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.olingo.commons.api.ex.ODataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pab.odata.olingo.api.controller.common.CommonOperationController;

@Component
public abstract class CommonODataController implements CommonOperationController {
    @Autowired
    private JPAODataSessionContextAccess serviceContext;
    @Autowired
    private JPAODataRequestContext requestContext;

    public void process(final HttpServletRequest req, final HttpServletResponse resp) {
        try {
            new JPAODataRequestHandler(serviceContext, requestContext).process(req, resp);
        } catch (ODataException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getOne(HttpServletRequest request, HttpServletResponse response) {
        process(request, response);
    }

    @Override
    public void getSet(HttpServletRequest request, HttpServletResponse response) {
        process(request, response);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        process(request, response);
    }

    @Override
    public void patch(HttpServletRequest request, HttpServletResponse response) {
        process(request, response);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) {
        process(request, response);
    }

    @Override
    public void getByAssoc(HttpServletRequest request, HttpServletResponse response) {
        process(request, response);
    }
}