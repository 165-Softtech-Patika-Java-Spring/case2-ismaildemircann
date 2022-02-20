package com.softtech.case2ismaildemircann.app.adr.dao;

import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrNeighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdrNeighborhoodDao extends JpaRepository<AdrNeighborhood, Long> {

    List<AdrNeighborhood> findAllByDistrictId(Long id);

    AdrNeighborhood findByName(String name);
}
