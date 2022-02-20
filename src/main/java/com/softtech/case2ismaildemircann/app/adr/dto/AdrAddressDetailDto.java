package com.softtech.case2ismaildemircann.app.adr.dto;

import lombok.Data;

@Data
public class AdrAddressDetailDto {

    private Long id;
    private String countryName;
    private String provinceName;
    private String districtName;
    private String neighborhoodName;
    private String streetName;
    private Long apartmentNo;
    private Long flatNo;
}
