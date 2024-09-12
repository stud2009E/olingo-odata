package pab.odata.olingo.base.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;
import pab.odata.olingo.api.controller.OrderController;
import pab.odata.olingo.base.controller.common.CommonODataController;

@RestController
public class OrderControllerImpl extends CommonODataController implements OrderController {
}
