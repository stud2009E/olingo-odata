package pab.odata.olingo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Table(name = "Supplier")
@Entity(name = "Supplier")
@Data
@NoArgsConstructor
public class Supplier {

    @Id
    @Column(insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_gen_from_100")
    @SequenceGenerator(name = "supplier_gen_from_100", sequenceName = "supplier_seq", initialValue = 100)
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact", nullable = false)
    private String contact;

    @OneToMany(mappedBy = "supplier", orphanRemoval = true)
    Set<Product> products = new HashSet<>();
}
