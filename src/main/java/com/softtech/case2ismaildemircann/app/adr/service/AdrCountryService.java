package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountryDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountrySaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrCountry;
import com.softtech.case2ismaildemircann.app.adr.enums.AdrErrorMessage;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrCountryMapper;
import com.softtech.case2ismaildemircann.app.adr.service.entityservice.AdrCountryEntityService;
import com.softtech.case2ismaildemircann.app.gen.exceptions.GenBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrCountryService {

    private final AdrCountryEntityService adrCountryEntityService;

    /**
     * @return This method find all countries info and return country list.
     */
    public List<AdrCountryDto> findAll() {

        List<AdrCountry> adrCountryList = adrCountryEntityService.findAll();

        if(adrCountryList == null) {
            throw new GenBusinessException(AdrErrorMessage.CountryNotFound);
        }

        List<AdrCountryDto> adrCountryDtoList = AdrCountryMapper.INSTANCE.convertToAdrCountryDtoList(adrCountryList);

        return adrCountryDtoList;
    }

    /**
     * @return This method save country info and return saved object
     */
    public AdrCountryDto save(AdrCountrySaveRequestDto adrCountrySaveRequestDto) {

        AdrCountry adrCountry = AdrCountryMapper.INSTANCE.convertToAdrCountry(adrCountrySaveRequestDto);

        adrCountry = adrCountryEntityService.save(adrCountry);

        AdrCountryDto adrCountryDto = AdrCountryMapper.INSTANCE.convertToAdrCountryDto(adrCountry);

        return adrCountryDto;
    }

    /**
     * @return This method find country matched by country code and return country info
     */
    public AdrCountryDto findByCountryCode(String countryCode) {

        AdrCountry adrCountry = adrCountryEntityService.findByCountryCode(countryCode);

        if(adrCountry == null) {
            throw new GenBusinessException(AdrErrorMessage.CountryNotFound);
        }

        AdrCountryDto adrCountryDto = AdrCountryMapper.INSTANCE.convertToAdrCountryDto(adrCountry);

        return adrCountryDto;
    }
}
