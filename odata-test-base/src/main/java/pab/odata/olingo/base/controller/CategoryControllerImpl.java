package pab.odata.olingo.base.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;
import pab.odata.olingo.api.controller.CategoryController;

@RestController
public class CategoryControllerImpl extends BaseODataController implements CategoryController {

    @Override
    public void getOne(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

    @Override
    public void getSet(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

    @Override
    public void getByAssoc(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

    @Override
    public void patch(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) {
        super.process(request, response);
    }
}
