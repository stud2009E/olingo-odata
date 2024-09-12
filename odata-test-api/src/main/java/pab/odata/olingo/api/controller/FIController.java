package pab.odata.olingo.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "${odata.jpa.mapping-path}")
@Tag(name = "FI", description = "function import")
public interface FIController {

    @GetMapping(path = "/Sum(Num1={a},Num2={b})")
    @Operation(summary = "sum numbers",
            parameters = {
                    @Parameter(name = "a", required = true, in = ParameterIn.PATH),
                    @Parameter(name = "b", required = true, in = ParameterIn.PATH)
            }
    )
    void sum(HttpServletRequest request, HttpServletResponse response);


    @GetMapping(path = "/Pow(Num1={a},Num2={b})")
    @Operation(summary = "sum numbers",
            parameters = {
                    @Parameter(name = "a", required = true, in = ParameterIn.PATH),
                    @Parameter(name = "b", required = true, in = ParameterIn.PATH)
            }
    )
    void pow(HttpServletRequest request, HttpServletResponse response);
}