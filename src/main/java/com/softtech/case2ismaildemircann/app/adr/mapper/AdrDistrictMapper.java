package com.softtech.case2ismaildemircann.app.adr.mapper;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrDistrictDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrDistrictSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrDistrict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrDistrictMapper {

    AdrDistrictMapper INSTANCE = Mappers.getMapper(AdrDistrictMapper.class);

    AdrDistrict convertToAdrDistrict(AdrDistrictSaveRequestDto adrDistrictSaveRequestDto);

    List<AdrDistrictDto> convertToAdrDistrictDtoList(List<AdrDistrict> adrDistrictList);

    AdrDistrictDto convertToAdrDistrictDto(AdrDistrict adrDistrict);
}
