package com.softtech.case2ismaildemircann.app.adr.dto;

import lombok.Data;

@Data
public class AdrAddressDto {

    private Long id;
    private Long countryId;
    private Long provinceId;
    private Long districtId;
    private Long neighborhoodId;
    private Long streetId;
    private Long apartmentNo;
    private Long flatNo;
}
