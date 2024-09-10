package pab.odata.olingo.base.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Entity(name = "Address")
@Table(name = "address")
@Data
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "address_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "address_gen", sequenceName = "address_seq", initialValue = 1)
    private Long id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "house_num", nullable = false)
    private String houseNum;
}
