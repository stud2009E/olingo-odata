package pab.odata.olingo.base.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;
import pab.odata.olingo.api.controller.FIController;
import pab.odata.olingo.base.controller.common.CommonODataController;

@RestController
public class FIControllerImpl extends CommonODataController implements FIController {
    @Override
    public void sum(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

    @Override
    public void pow(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

}
