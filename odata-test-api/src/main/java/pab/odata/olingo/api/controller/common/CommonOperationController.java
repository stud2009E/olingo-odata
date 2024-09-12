package pab.odata.olingo.api.controller.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CommonOperationController {

    void getOne(HttpServletRequest request, HttpServletResponse response);

    void getSet(HttpServletRequest request, HttpServletResponse response);

    void delete(HttpServletRequest request, HttpServletResponse response);

    void patch(HttpServletRequest request, HttpServletResponse response);

    void create(HttpServletRequest request, HttpServletResponse response);

    void getByAssoc(HttpServletRequest request, HttpServletResponse response);
}
