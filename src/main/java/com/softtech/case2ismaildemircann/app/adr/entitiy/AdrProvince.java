package com.softtech.case2ismaildemircann.app.adr.entitiy;

import com.softtech.case2ismaildemircann.app.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADR_PROVINCE")
@Data
public class AdrProvince extends BaseEntity {

    @Id
    @SequenceGenerator(name = "AdrProvince", sequenceName = "ADR_PROVINCE_ID_SEQ")
    @GeneratedValue(generator = "AdrProvince")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "LICENSE_PLATE", length = 20, nullable = false)
    private String licensePlate;

    @Column(name = "ID_ADR_COUNTRY", nullable = false)
    private Long countryId;
}
