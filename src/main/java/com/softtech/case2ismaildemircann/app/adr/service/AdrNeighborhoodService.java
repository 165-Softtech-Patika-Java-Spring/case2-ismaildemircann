package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrNeighborhoodDao;
import com.softtech.case2ismaildemircann.app.adr.dto.*;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrNeighborhood;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrNeighborhoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdrNeighborhoodService {

    private final AdrNeighborhoodDao adrNeighborhoodDao;
    private final AdrDistrictService adrDistrictService;

    public List<AdrNeighborhoodDto> findAll() {

        List<AdrNeighborhood> adrNeighborhoodList = adrNeighborhoodDao.findAll();

        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDtoList(adrNeighborhoodList);

        return adrNeighborhoodDtoList;
    }

    public AdrNeighborhoodDto findByName(String name) {

        AdrNeighborhood adrNeighborhood = adrNeighborhoodDao.findByName(name);

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
        adrNeighborhood = adrNeighborhoodDao.save(adrNeighborhood);

        AdrNeighborhoodDto adrNeighborhoodDto = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDto(adrNeighborhood);

        return adrNeighborhoodDto;
    }

    public List<AdrNeighborhoodDto> findAllByDistrictName(String districtName) {

        AdrDistrictDto adrDistrictDto = adrDistrictService.findByName(districtName);

        List<AdrNeighborhood> adrNeighborhoodList = adrNeighborhoodDao.findAllByDistrictId(adrDistrictDto.getId());

        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDtoList(adrNeighborhoodList);

        return adrNeighborhoodDtoList;
    }

    public AdrNeighborhoodDto updateNeighborhoodName(AdrNeighborhoodUpdateRequestDto adrNeighborhoodUpdateRequestDto) {

        AdrNeighborhood adrNeighborhood = getByIdWithControl(adrNeighborhoodUpdateRequestDto.getId());
        adrNeighborhood.setName(adrNeighborhoodUpdateRequestDto.getNewName());

        adrNeighborhood = adrNeighborhoodDao.save(adrNeighborhood);

        AdrNeighborhoodDto adrNeighborhoodDto = AdrNeighborhoodMapper.INSTANCE.convertToAdrNeighborhoodDto(adrNeighborhood);

        return adrNeighborhoodDto;
    }

    public AdrNeighborhood getByIdWithControl(Long id) {

        Optional<AdrNeighborhood> adrNeighborhoodOptional = adrNeighborhoodDao.findById(id);

        AdrNeighborhood adrNeighborhood;
        if (adrNeighborhoodOptional.isPresent()){
            adrNeighborhood = adrNeighborhoodOptional.get();
        } else {
            throw new RuntimeException("Item not found!");
        }

        return adrNeighborhood;
    }

    public boolean existsById(Long id) {

        return adrNeighborhoodDao.existsById(id);
    }
}
