package pab.odata.olingo.base.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Order")
@Table(name = "orders")
@Data
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    @SequenceGenerator(name="order_gen", sequenceName = "order_seq", initialValue = 1)
    private Long Id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="changed_at")
    private LocalDateTime changedAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
}
