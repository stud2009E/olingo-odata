package pab.odata.olingo.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import pab.odata.olingo.api.controller.common.CommonOperationController;
import pab.odata.olingo.api.dto.OrderDto;

@RequestMapping(path = "${odata.jpa.mapping-path}")
@Tag(name = "Order", description = "order entity")
public interface OrderController extends CommonOperationController {

    @GetMapping(path = "/Orders({id})")
    @Operation(summary = "get order by id",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH),
                    @Parameter(name = "$select"),
                    @Parameter(name = "$expand"),
            }
    )
    void getOne(HttpServletRequest request, HttpServletResponse response);


    @GetMapping("/Orders")
    @Operation(summary = "get Orders",
            parameters = {
                    @Parameter(name = "$top"),
                    @Parameter(name = "$skip"),
                    @Parameter(name = "$count"),
                    @Parameter(name = "$select"),
                    @Parameter(name = "$expand"),
                    @Parameter(name = "$orderby"),
                    @Parameter(name = "$filter")
            }
    )
    void getSet(HttpServletRequest request, HttpServletResponse response);

    @GetMapping(path = "/Orders({id})/Items")
    @Operation(summary = "get order items",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH),
                    @Parameter(name = "$top"),
                    @Parameter(name = "$skip"),
                    @Parameter(name = "$count"),
                    @Parameter(name = "$select"),
                    @Parameter(name = "$expand"),
                    @Parameter(name = "$orderby"),
                    @Parameter(name = "$filter")
            }
    )
    void getByAssoc(HttpServletRequest request, HttpServletResponse response);


    @DeleteMapping(path = "/Orders({id})")
    @Operation(summary = "delete order",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH)
            }
    )
    void delete(HttpServletRequest request, HttpServletResponse response);


    @PatchMapping(path = "/Orders({id})")
    @Operation(summary = "update order",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH)
            },
            requestBody = @RequestBody(required = true,
                    content = @Content(contentSchema = @Schema(implementation = OrderDto.class))
            )
    )
    void patch(HttpServletRequest request, HttpServletResponse response);


    @PostMapping(path = "/Orders")
    @Operation(summary = "create order",
            requestBody = @RequestBody(required = true,
                    content = @Content(schema = @Schema(implementation = OrderDto.class))
            )
    )
    void create(HttpServletRequest request, HttpServletResponse response);
}