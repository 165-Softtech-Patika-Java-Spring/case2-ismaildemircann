package com.softtech.case2ismaildemircann.app.adr.dao;

import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdrCountryDao extends JpaRepository<AdrCountry, Long> {

    AdrCountry findByCountryCode(String countryCode);
}