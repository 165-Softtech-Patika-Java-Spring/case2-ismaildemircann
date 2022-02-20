package com.softtech.case2ismaildemircann.app.adr.mapper;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrProvince;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrProvinceMapper {

    AdrProvinceMapper INSTANCE = Mappers.getMapper(AdrProvinceMapper.class);

    AdrProvince convertToAdrProvince(AdrProvinceSaveRequestDto adrProvinceSaveRequestDto);

    List<AdrProvinceDto> convertToAdrProvinceDtoList(List<AdrProvince> adrProvinceList);

    AdrProvinceDto convertToAdrProvinceDto(AdrProvince adrProvince);
}
