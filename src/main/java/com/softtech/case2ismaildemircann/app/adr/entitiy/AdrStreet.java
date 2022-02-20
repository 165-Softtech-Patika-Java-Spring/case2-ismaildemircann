package com.softtech.case2ismaildemircann.app.adr.entitiy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class AdrStreet {

    @Id
    @SequenceGenerator(name = "AdrStreet", sequenceName = "ADR_STREET_ID_SEQ")
    @GeneratedValue(generator = "AdrStreet")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name="ID_ADR_NEIGHBORHOOD")
    private Long neighborhoodId;
}
