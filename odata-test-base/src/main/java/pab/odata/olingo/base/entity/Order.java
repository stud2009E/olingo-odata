package pab.odata.olingo.base.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Order")
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    @SequenceGenerator(name = "order_gen", sequenceName = "order_seq", initialValue = 1)
    private Long Id;

    @Nonnull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Nonnull
    @Column(name = "created_at")
    @PastOrPresent
    private OffsetDateTime createdAt;

    @Nonnull
    @Column(name = "changed_at")
    @PastOrPresent
    private OffsetDateTime changedAt;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Set<OrderItem> items = new HashSet<>();
}
