package com.softtech.case2ismaildemircann.app.adr.mapper;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDetailDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrAddress;
import com.softtech.case2ismaildemircann.app.adr.entitiy.results.AdrAddressResult;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrAddressMapper {

    AdrAddressMapper INSTANCE = Mappers.getMapper(AdrAddressMapper.class);

    AdrAddress convertAdrAddress(AdrAddressSaveRequestDto adrAddressSaveRequestDto);

    List<AdrAddressDto> convertToAdrAddressDtoList(List<AdrAddress> adrCountryList);

    AdrAddressDto convertAdrAddressDto(AdrAddress adrAddress);

    AdrAddressDetailDto convertAdrAddressResultToAdrAddressDto(AdrAddressResult adrAddressResult);
}
