package pab.odata.olingo.api.controller.common;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "${odata.jpa.mapping-path}")
@Tag(name = "OData specific", description = "Handle odata service specific requests: $batch, $metadata, atom api")
public interface ODataServiceController {

    @GetMapping(value = "/$metadata", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @Operation(summary = "service metadata")
    void metadata(HttpServletRequest request, HttpServletResponse response);

    @GetMapping(value = "/", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @Operation(summary = "service atom")
    void atom(HttpServletRequest request, HttpServletResponse response);

    @PostMapping(value = "/$batch", consumes = MediaType.MULTIPART_MIXED_VALUE)
    @Operation(summary = "handle complex batch request")
    void batch(HttpServletRequest request, HttpServletResponse response);
}
