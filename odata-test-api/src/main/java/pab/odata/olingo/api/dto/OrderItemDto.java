
package pab.odata.olingo.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDto {
    private Long id;

    private Long orderId;

    private Long productId;

    private Double quantity;
}
