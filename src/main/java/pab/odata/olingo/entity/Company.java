package pab.odata.olingo.entity;

import jakarta.persistence.*;
import pab.odata.olingo.entity.vocabulary.ABCClassification;

@Entity(name = "Company")
@DiscriminatorValue(value = "2")
public class Company extends BusinessPartner {

    @Column(name = "NameLine1")
    private String name1;

    @Column(name = "NameLine2")
    private String name2;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ABCClass")
    private ABCClassification abcClassification;
}
