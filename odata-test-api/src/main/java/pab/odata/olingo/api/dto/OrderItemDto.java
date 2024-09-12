
package pab.odata.olingo.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDto {
    private Long Id;

    private Long orderId;

    private OrderDto order;

    private Long productId;

    private ProductDto product;

    private Double quantity;
}
