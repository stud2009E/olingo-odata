package pab.odata.olingo.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;

    private String name;

    private double unitPrice;

    private Long categoryId;

    private Long supplierId;
}
