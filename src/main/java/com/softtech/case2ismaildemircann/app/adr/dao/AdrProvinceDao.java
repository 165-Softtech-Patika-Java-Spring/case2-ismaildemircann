package com.softtech.case2ismaildemircann.app.adr.dao;

import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrProvince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdrProvinceDao extends JpaRepository<AdrProvince, Long> {

    AdrProvince findByLicensePlate (String licensePlate);

    AdrProvince findByName(String name);
}
