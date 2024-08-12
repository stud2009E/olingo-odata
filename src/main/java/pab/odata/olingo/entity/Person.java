package pab.odata.olingo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity(name = "Person")
@DiscriminatorValue(value = "1")
public class Person extends BusinessPartner {

    @Column(name = "NameLine1")
    private String firstName;

    @Column(name = "NameLine2")
    private String lastName;

    @Column(name = "BirthDay")
    private Date birthDay;
}
