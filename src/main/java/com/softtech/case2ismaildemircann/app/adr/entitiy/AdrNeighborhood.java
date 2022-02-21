package com.softtech.case2ismaildemircann.app.adr.entitiy;

import com.softtech.case2ismaildemircann.app.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ADR_NEIGHBORHOOD")
@Data
public class AdrNeighborhood extends BaseEntity {

    @Id
    @SequenceGenerator(name = "AdrNeighborhood", sequenceName = "ADR_NEIGHBORHOOD_ID_SEQ")
    @GeneratedValue(generator = "AdrNeighborhood")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "ID_ADR_DISTRICT")
    private Long districtId;
}
