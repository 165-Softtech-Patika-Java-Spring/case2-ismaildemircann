package com.softtech.case2ismaildemircann.app.adr.mapper;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrStreetDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrStreetSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrStreet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrStreetMapper {

    AdrStreetMapper INSTANCE = Mappers.getMapper(AdrStreetMapper.class);

    AdrStreet convertToAdrStreet(AdrStreetSaveRequestDto adrStreetSaveRequestDto);

    List<AdrStreetDto> convertToAdrStreetDtoList(List<AdrStreet> adrStreetList);

    AdrStreetDto convertToAdrStreetDto(AdrStreet adrStreet);
}
