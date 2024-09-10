package pab.odata.olingo.base.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;
import pab.odata.olingo.api.controller.ODataServiceController;

@RestController
public class ODataServiceControllerImpl extends BaseODataController implements ODataServiceController {

    @Override
    public void metadata(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

    @Override
    public void atom(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

    @Override
    public void batch(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

}
