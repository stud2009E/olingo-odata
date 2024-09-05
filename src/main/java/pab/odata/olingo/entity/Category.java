package pab.odata.olingo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Category")
@Table(name = "Category")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @SequenceGenerator(name = "category_gen_from_100", initialValue = 100, sequenceName = "category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen_from_100")
    @Column(insertable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private Set<Product> products = new HashSet<>();
}
