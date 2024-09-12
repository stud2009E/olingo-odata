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
import pab.odata.olingo.api.dto.OrderItemDto;
import pab.odata.olingo.api.dto.ProductDto;

@RequestMapping(path = "${odata.jpa.mapping-path}")
@Tag(name = "Product", description = "product entity")
public interface ProductController {

    @GetMapping(path = "/Products({id})")
    @Operation(summary = "get product by id",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH),
                    @Parameter(name = "$select"),
                    @Parameter(name = "$expand"),
            }
    )
    void getOne(HttpServletRequest request, HttpServletResponse response);


    @GetMapping("/Products")
    @Operation(summary = "get products",
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
                            description = "Success",
                            content = @Content(
                                    array = @ArraySchema(
                                            arraySchema = @Schema(implementation = ProductDto.class)
                                    )
                            ))
            }
    )
    void getSet(HttpServletRequest request, HttpServletResponse response);

    @DeleteMapping(path = "/Products({id})")
    @Operation(summary = "delete product",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH)
            }
    )
    void delete(HttpServletRequest request, HttpServletResponse response);


    @PatchMapping(path = "/Products({id})")
    @Operation(summary = "update product",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH)
            },
            requestBody = @RequestBody(required = true,
                    content = @Content(contentSchema = @Schema(implementation = ProductDto.class))
            )
    )
    void patch(HttpServletRequest request, HttpServletResponse response);


    @PostMapping(path = "/Products")
    @Operation(summary = "create product",
            requestBody = @RequestBody(required = true,
                    content = @Content(schema = @Schema(implementation = ProductDto.class))
            )
    )
    void create(HttpServletRequest request, HttpServletResponse response);
}