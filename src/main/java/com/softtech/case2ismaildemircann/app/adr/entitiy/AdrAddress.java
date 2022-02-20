package com.softtech.case2ismaildemircann.app.adr.entitiy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADR_ADDRESS")
@Data
public class AdrAddress {

    @Id
    @SequenceGenerator(name = "AdrAddress", sequenceName = "ADR_ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "AdrAddress")
    private Long id;

    @Column(name = "ID_ADR_COUNTRY", nullable = false)
    private Long countryId;

    @Column(name = "ID_ADR_PROVINCE")
    private Long provinceId;

    @Column(name = "ID_ADR_DISTRICT")
    private Long districtId;

    @Column(name = "ID_ADR_NEIGHBORHOOD")
    private Long neighborhoodId;

    @Column(name = "ID_ADR_STREET")
    private Long streetId;

    @Column(name = "APARTMENT_NO")
    private Long apartmentNo;

    @Column(name = "FLAT_NO")
    private Long flatNo;
}
