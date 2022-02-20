package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrCountryDao;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountryDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountrySaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrCountry;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrCountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrCountryService {

    private final AdrCountryDao adrCountryDao;

    public List<AdrCountryDto> findAll() {

        List<AdrCountry> adrCountryList = adrCountryDao.findAll();

        List<AdrCountryDto> adrCountryDtoList = AdrCountryMapper.INSTANCE.convertToAdrCountryDtoList(adrCountryList);

        return adrCountryDtoList;
    }

    public AdrCountryDto save(AdrCountrySaveRequestDto adrCountrySaveRequestDto) {

        AdrCountry adrCountry = AdrCountryMapper.INSTANCE.convertToAdrCountry(adrCountrySaveRequestDto);

        adrCountry = adrCountryDao.save(adrCountry);

        AdrCountryDto adrCountryDto = AdrCountryMapper.INSTANCE.convertToAdrCountryDto(adrCountry);

        return adrCountryDto;
    }

    public AdrCountryDto findByCountryCode(String countryCode) {

        AdrCountry adrCountry = adrCountryDao.findByCountryCode(countryCode);

        AdrCountryDto adrCountryDto = AdrCountryMapper.INSTANCE.convertToAdrCountryDto(adrCountry);

        return adrCountryDto;
    }
}
