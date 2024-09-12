package pab.odata.olingo.base.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "OrderItem")
@Table(name = "order_item")
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_gen")
    @SequenceGenerator(name = "order_item_gen", sequenceName = "order_item_seq", initialValue = 1)
    private Long id;

    @NotNull
    @Column(name = "order_id", nullable = false, updatable = false)
    private Long orderId;

    @NotNull
    @Column(name = "product_id", nullable = false, updatable = false)
    private Long productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Product product;

    @Positive
    @Column(name = "quan", nullable = false)
    private Double quantity;
}
