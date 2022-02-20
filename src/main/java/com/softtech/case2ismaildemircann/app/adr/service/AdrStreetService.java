package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrStreetDao;
import com.softtech.case2ismaildemircann.app.adr.dto.*;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrStreet;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrStreetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdrStreetService {

    private final AdrStreetDao adrStreetDao;
    private final AdrNeighborhoodService adrNeighborhoodService;

    public List<AdrStreetDto> findAll() {

        List<AdrStreet> adrStreetList = adrStreetDao.findAll();

        List<AdrStreetDto> adrStreetDtoList = AdrStreetMapper.INSTANCE.convertToAdrStreetDtoList(adrStreetList);

        return adrStreetDtoList;
    }

    public List<AdrStreetDto> findAllByNeighborhoodName(String neighborhoodName) {

        AdrNeighborhoodDto adrNeighborhoodDto = adrNeighborhoodService.findByName(neighborhoodName);

        List<AdrStreet> adrStreetList = adrStreetDao.findAllByNeighborhoodId(adrNeighborhoodDto.getId());

        List<AdrStreetDto> adrStreetDtoList = AdrStreetMapper.INSTANCE.convertToAdrStreetDtoList(adrStreetList);

        return adrStreetDtoList;
    }

    public AdrStreetDto updateStreetName(AdrStreetUpdateRequestDto adrStreetUpdateRequestDto) {

        AdrStreet adrStreet = getByIdWithControl(adrStreetUpdateRequestDto.getId());
        adrStreet.setName(adrStreetUpdateRequestDto.getNewName());

        adrStreet = adrStreetDao.save(adrStreet);

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
        adrStreet = adrStreetDao.save(adrStreet);

        AdrStreetDto adrStreetDto = AdrStreetMapper.INSTANCE.convertToAdrStreetDto(adrStreet);

        return adrStreetDto;
    }

    public AdrStreet getByIdWithControl(Long id) {

        Optional<AdrStreet> adrStreetOptional = adrStreetDao.findById(id);

        AdrStreet adrStreet;
        if (adrStreetOptional.isPresent()){
            adrStreet = adrStreetOptional.get();
        } else {
            throw new RuntimeException("Item not found!");
        }

        return adrStreet;
    }
}
