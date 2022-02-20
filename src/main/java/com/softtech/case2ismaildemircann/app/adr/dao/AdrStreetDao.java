package com.softtech.case2ismaildemircann.app.adr.dao;

import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrStreet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdrStreetDao extends JpaRepository<AdrStreet, Long> {

    List<AdrStreet> findAllByNeighborhoodId(Long id);
}
