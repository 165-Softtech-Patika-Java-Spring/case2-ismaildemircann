package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dto.*;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrStreet;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrStreetMapper;
import com.softtech.case2ismaildemircann.app.adr.service.entityservice.AdrStreetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrStreetService {

    private final AdrStreetEntityService adrStreetEntityService;
    private final AdrNeighborhoodService adrNeighborhoodService;

    public List<AdrStreetDto> findAll() {

        List<AdrStreet> adrStreetList = adrStreetEntityService.findAll();

        List<AdrStreetDto> adrStreetDtoList = AdrStreetMapper.INSTANCE.convertToAdrStreetDtoList(adrStreetList);

        return adrStreetDtoList;
    }

    public List<AdrStreetDto> findAllByNeighborhoodName(Long neighborhoodId) {

        AdrNeighborhoodDto adrNeighborhoodDto = adrNeighborhoodService.findById(neighborhoodId);

        List<AdrStreet> adrStreetList = adrStreetEntityService.findAllByNeighborhoodId(adrNeighborhoodDto.getId());

        List<AdrStreetDto> adrStreetDtoList = AdrStreetMapper.INSTANCE.convertToAdrStreetDtoList(adrStreetList);

        return adrStreetDtoList;
    }

    public AdrStreetDto updateStreetName(AdrStreetUpdateRequestDto adrStreetUpdateRequestDto) {

        AdrStreet adrStreet = adrStreetEntityService.getByIdWithControl(adrStreetUpdateRequestDto.getId());
        adrStreet.setName(adrStreetUpdateRequestDto.getNewName());

        adrStreet = adrStreetEntityService.save(adrStreet);

        AdrStreetDto adrStreetDto = AdrStreetMapper.INSTANCE.convertToAdrStreetDto(adrStreet);

        return adrStreetDto;
    }

    public AdrStreetDto save(AdrStreetSaveRequestDto adrStreetSaveRequestDto) throws Exception {

        boolean isExist = adrNeighborhoodService.existsById(adrStreetSaveRequestDto.getNeighborhoodId());
        if(!isExist) {
            throw new Exception("Neighborhood not found!");
        }

        AdrStreet adrStreet = AdrStreetMapper.INSTANCE.convertToAdrStreet(adrStreetSaveRequestDto);
        adrStreet.setNeighborhoodId(adrStreetSaveRequestDto.getNeighborhoodId());
        adrStreet = adrStreetEntityService.save(adrStreet);

        AdrStreetDto adrStreetDto = AdrStreetMapper.INSTANCE.convertToAdrStreetDto(adrStreet);

        return adrStreetDto;
    }
}
