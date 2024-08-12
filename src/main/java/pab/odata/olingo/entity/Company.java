package pab.odata.olingo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "Company")
@DiscriminatorValue(value = "2")
public class Company extends BusinessPartner {

    @Column(name = "NameLine1")
    private String name1;

    @Column(name = "NameLine2")
    private String name2;
}
