package com.softtech.case2ismaildemircann.app.adr.enums;

import com.softtech.case2ismaildemircann.app.gen.enums.BaseErrorMessage;

public enum AdrErrorMessage implements BaseErrorMessage{

    CountryNotFound("Country not found!"),
    ProvinceNotFound("Province not found!"),
    DistrictNotFound("District not found!"),
    NeighborhoodNotFound("Neighborhood not found!"),
    StreetNotFound("Street not found!"),
    AddressNotFound("Address not found!"),
    ;

    private String message;
    AdrErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}