package com.softtech.case2ismaildemircann.app.adr.mapper;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountryDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountrySaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrCountry;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrCountryMapper {

    AdrCountryMapper INSTANCE = Mappers.getMapper(AdrCountryMapper.class);

    AdrCountry convertToAdrCountry(AdrCountrySaveRequestDto adrCountrySaveRequestDto);

    List<AdrCountryDto> convertToAdrCountryDtoList(List<AdrCountry> adrCountryList);

    AdrCountryDto convertToAdrCountryDto(AdrCountry adrCountry);
}
