package com.softtech.case2ismaildemircann.app.adr.entitiy;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADR_DISTRICT")
@Data
public class AdrDistrict {
    @Id
    @SequenceGenerator(name = "AdrDistrict", sequenceName = "ADR_DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "AdrDistrict")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "ID_ADR_PROVINCE")
    private Long provinceId;
}
