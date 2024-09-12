package pab.odata.olingo.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import pab.odata.olingo.api.controller.common.CommonOperationController;
import pab.odata.olingo.api.dto.OrderItemDto;

@RequestMapping(path = "${odata.jpa.mapping-path}")
@Tag(name = "Order item", description = "order item entity")
public interface OrderItemController extends CommonOperationController {

    @GetMapping(path = "/OrderItems({id})")
    @Operation(summary = "get order item by id",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH),
                    @Parameter(name = "$select"),
                    @Parameter(name = "$expand"),
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    array = @ArraySchema(
                                            arraySchema = @Schema(implementation = OrderItemDto.class)
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404"
                    )
            }
    )
    void getOne(HttpServletRequest request, HttpServletResponse response);


    @GetMapping("/OrderItems")
    @Operation(summary = "get OrderItems",
            parameters = {
                    @Parameter(name = "$top"),
                    @Parameter(name = "$skip"),
                    @Parameter(name = "$count"),
                    @Parameter(name = "$select"),
                    @Parameter(name = "$expand"),
                    @Parameter(name = "$orderby"),
                    @Parameter(name = "$filter")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    array = @ArraySchema(
                                            arraySchema = @Schema(implementation = OrderItemDto.class)
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404"
                    )
            }
    )
    void getSet(HttpServletRequest request, HttpServletResponse response);

    @DeleteMapping(path = "/OrderItems({id})")
    @Operation(summary = "delete order item",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH)
            }
    )
    void delete(HttpServletRequest request, HttpServletResponse response);


    @PatchMapping(path = "/OrderItems({id})")
    @Operation(summary = "update order item",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH)
            },
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            contentSchema = @Schema(implementation = OrderItemDto.class)
                    )
            )
    )
    void patch(HttpServletRequest request, HttpServletResponse response);


    @PostMapping(path = "/OrderItems")
    @Operation(summary = "create order item",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = OrderItemDto.class)
                    )
            )
    )
    void create(HttpServletRequest request, HttpServletResponse response);
}