package com.softtech.case2ismaildemircann.app.adr.mapper;

import com.softtech.case2ismaildemircann.app.adr.dto.*;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrNeighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdrNeighborhoodMapper {

    AdrNeighborhoodMapper INSTANCE = Mappers.getMapper(AdrNeighborhoodMapper.class);

    AdrNeighborhood convertToAdrNeighborhood(AdrNeighborhoodSaveRequestDto adrNeighborhoodSaveRequestDto);

    AdrNeighborhood convertToAdrNeighborhood(AdrNeighborhoodUpdateRequestDto adrNeighborhoodUpdateRequestDto);

    List<AdrNeighborhoodDto> convertToAdrNeighborhoodDtoList(List<AdrNeighborhood> adrNeighborhoodList);

    AdrNeighborhoodDto convertToAdrNeighborhoodDto(AdrNeighborhood adrNeighborhood);
}
