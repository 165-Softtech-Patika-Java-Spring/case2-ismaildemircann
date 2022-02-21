package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dto.*;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrNeighborhood;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrNeighborhoodMapper;
import com.softtech.case2ismaildemircann.app.adr.service.entityservice.AdrNeighborhoodEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrNeighborhoodService {

    private final AdrNeighborhoodEntityService adrNeighborhoodEntityService;
    private final AdrDistrictService adrDistrictService;

    public List<AdrNeighborhoodDto> findAll() {

        List<AdrNeighborhood> adrNeighborhoodList = adrNeighborhoodEntityService.findAll();

        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDtoList(adrNeighborhoodList);

        return adrNeighborhoodDtoList;
    }

    public AdrNeighborhoodDto findById(Long neighborhoodId) {

        AdrNeighborhood adrNeighborhood = adrNeighborhoodEntityService.getByIdWithControl(neighborhoodId);

        AdrNeighborhoodDto adrNeighborhoodDto = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDto(adrNeighborhood);

        return adrNeighborhoodDto;
    }

    public AdrNeighborhoodDto save(AdrNeighborhoodSaveRequestDto adrNeighborhoodSaveRequestDto) throws Exception {

        boolean isExist = adrDistrictService.existsById(adrNeighborhoodSaveRequestDto.getDistrictId());
        if(!isExist) {
            throw new Exception("District not found!");
        }

        AdrNeighborhood adrNeighborhood = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhood(adrNeighborhoodSaveRequestDto);
        adrNeighborhood.setDistrictId(adrNeighborhoodSaveRequestDto.getDistrictId());
        adrNeighborhood = adrNeighborhoodEntityService.save(adrNeighborhood);

        AdrNeighborhoodDto adrNeighborhoodDto = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDto(adrNeighborhood);

        return adrNeighborhoodDto;
    }

    /**
     * @return This method returns the neighborhood of the relevant district.
     */
    public List<AdrNeighborhoodDto> findAllByDistrictId(Long districtId) {

        AdrDistrictDto adrDistrictDto = adrDistrictService.findById(districtId);

        List<AdrNeighborhood> adrNeighborhoodList = adrNeighborhoodEntityService.findAllByDistrictId(adrDistrictDto.getId());

        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDtoList(adrNeighborhoodList);

        return adrNeighborhoodDtoList;
    }

    public AdrNeighborhoodDto updateNeighborhoodName(AdrNeighborhoodUpdateRequestDto adrNeighborhoodUpdateRequestDto) {

        AdrNeighborhood adrNeighborhood = adrNeighborhoodEntityService.getByIdWithControl(adrNeighborhoodUpdateRequestDto.getId());
        adrNeighborhood.setName(adrNeighborhoodUpdateRequestDto.getNewName());

        adrNeighborhood = adrNeighborhoodEntityService.save(adrNeighborhood);

        AdrNeighborhoodDto adrNeighborhoodDto = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDto(adrNeighborhood);

        return adrNeighborhoodDto;
    }

    public boolean existsById(Long id) {

        return adrNeighborhoodEntityService.existsById(id);
    }
}
