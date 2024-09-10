package pab.odata.olingo.base.entity;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmTransient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pab.odata.olingo.base.entity.calculation.CategoryProductCount;

import java.util.Set;

@Entity(name = "Category")
@Table(name = "Category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @SequenceGenerator(name = "category_gen_from_100", initialValue = 100, sequenceName = "category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen_from_100")
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @EdmTransient(requiredAttributes = "id", calculator = CategoryProductCount.class)
    private Long productCount;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private Set<Product> products;
}
