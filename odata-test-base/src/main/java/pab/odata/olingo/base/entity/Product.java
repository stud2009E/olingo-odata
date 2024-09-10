package pab.odata.olingo.base.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Product")
@Table(name = "Product")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_gen_from_100")
    @SequenceGenerator(name = "product_gen_from_100", initialValue = 100, sequenceName = "product_seq")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "category_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Category category;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "supplier_id", referencedColumnName = "id", updatable = false, insertable = false)
    private Supplier supplier;
}