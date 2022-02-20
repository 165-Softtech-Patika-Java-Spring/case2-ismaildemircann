package com.softtech.case2ismaildemircann.app.adr.entitiy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADR_COUNTRY")
@Data
public class AdrCountry {

    @Id
    @SequenceGenerator(name = "AdrCountry", sequenceName = "ADR_COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "AdrCountry")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "COUNTRY_CODE", length = 20, nullable = false)
    private String countryCode;
}
