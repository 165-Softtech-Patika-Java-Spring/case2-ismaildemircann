package com.softtech.case2ismaildemircann.app.adr.dao;

import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrAddress;
import com.softtech.case2ismaildemircann.app.adr.entitiy.results.AdrAddressResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdrAddressDao extends JpaRepository<AdrAddress, Long> {

    @Query(nativeQuery = true, value = "" +
    "SELECT " +
            "ADR_ADDRESS.ID, " +
            "country.name as countryName, " +
            "province.name as provinceName, " +
            "district.name as districtName, " +
            "neighborhood.name as neighborhoodName, " +
            "street.name as streetName, " +
            "APARTMENT_NO as apartmentNo, " +
            "FLAT_NO as flatNo, " +
            "FROM ADR_ADDRESS " +

            "LEFT OUTER JOIN " +
            "ADR_COUNTRY country on " +
            "(ADR_ADDRESS.ID_ADR_COUNTRY = country.id) " +

            "LEFT OUTER JOIN " +
            "ADR_PROVINCE province on " +
            "(ADR_ADDRESS.ID_ADR_PROVINCE = province.id) " +

            "LEFT OUTER JOIN " +
            "ADR_DISTRICT district on " +
            "(ADR_ADDRESS.ID_ADR_DISTRICT  = district.id) " +

            "LEFT OUTER JOIN " +
            "ADR_NEIGHBORHOOD neighborhood on " +
            "(ADR_ADDRESS.ID_ADR_NEIGHBORHOOD = neighborhood.id) " +

            "LEFT OUTER JOIN " +
            "ADR_STREET street on " +
            "(ADR_ADDRESS.ID_ADR_STREET= street.id) " +

            "WHERE ADR_ADDRESS.ID = :id "
    )
    AdrAddressResult findAddressByIdWithDetail(@Param("id") Long id);
}
