package pab.odata.olingo.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;

    private String status;

    private LocalDateTime changedAt;

    private LocalDateTime createdAt;

    private Set<OrderItemDto> items;
}
