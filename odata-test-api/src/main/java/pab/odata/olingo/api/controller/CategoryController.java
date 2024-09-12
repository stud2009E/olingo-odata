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
import pab.odata.olingo.api.dto.CategoryDto;

@RequestMapping(path = "${odata.jpa.mapping-path}")
@Tag(name = "Category", description = "Category entity")
public interface CategoryController extends CommonOperationController {

    @GetMapping(path = "/Categories({id})")
    @Operation(summary = "get category by id",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH),
                    @Parameter(name = "$select"),
                    @Parameter(name = "$expand"),
            }
    )
    void getOne(HttpServletRequest request, HttpServletResponse response);


    @GetMapping("/Categories")
    @Operation(summary = "get categories",
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


    @GetMapping(path = "/Categories({id})/Products")
    @Operation(summary = "get products by category",
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


    @DeleteMapping(path = "/Categories({id})")
    @Operation(summary = "delete category",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH)
            }
    )
    void delete(HttpServletRequest request, HttpServletResponse response);


    @PatchMapping(path = "/Categories({id})")
    @Operation(summary = "update category",
            parameters = {
                    @Parameter(name = "id", required = true, in = ParameterIn.PATH)
            },
            requestBody = @RequestBody(required = true,
                    content = {
                            @Content(
                                    contentSchema = @Schema(
                                            implementation = CategoryDto.class
                                    )
                            )
                    }
            )
    )
    void patch(HttpServletRequest request, HttpServletResponse response);


    @PostMapping(path = "/Categories")
    @Operation(summary = "create category",
            requestBody = @RequestBody(required = true,
                    content = @Content(schema = @Schema(implementation = CategoryDto.class))
            )
    )
    void create(HttpServletRequest request, HttpServletResponse response);
}