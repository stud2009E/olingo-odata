package pab.odata.olingo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Entity implementation class for Entity: BusinessPartner
 */
@Entity(name = "BusinessPartner")
@Table(name = "BusinessPartner")
public class BusinessPartner {

    @Id
    @Column(length = 32)
    private String iD;

    @Version
    @Column(name = "ETag")
    private long eTag;

    @Column(name = "CustomString1", length = 250)
    private String customString1;

    @Column(name = "CustomString2", length = 250)
    private String customString2;

    @Column(name = "CustomNum1", precision = 30, scale = 5)
    private BigDecimal customNum1;

    @Column(name = "CustomNum2", precision = 30, scale = 5)
    private BigDecimal customNum2;

    public BusinessPartner() {
        super();
    }
}
