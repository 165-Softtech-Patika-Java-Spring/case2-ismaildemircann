package com.softtech.case2ismaildemircann.app.adr.dao;

import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrDistrict;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdrDistrictDao extends JpaRepository<AdrDistrict, Long> {

    List<AdrDistrict> findAllByProvinceId(Long id);

    AdrDistrict findByName(String name);
}
