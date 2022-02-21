package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrDistrictDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrDistrictSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrDistrict;
import com.softtech.case2ismaildemircann.app.adr.enums.AdrErrorMessage;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrDistrictMapper;
import com.softtech.case2ismaildemircann.app.adr.service.entityservice.AdrDistrictEntityService;
import com.softtech.case2ismaildemircann.app.gen.exceptions.GenBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrDistrictService {

    private final AdrDistrictEntityService adrDistrictEntityService;
    private final AdrProvinceService adrProvinceService;

    public List<AdrDistrictDto> findAll() {

        List<AdrDistrict> adrDistrictList = adrDistrictEntityService.findAll();

        if(adrDistrictList == null) {
            throw new GenBusinessException(AdrErrorMessage.DistrictNotFound);
        }

        List<AdrDistrictDto> adrDistrictDtoList = AdrDistrictMapper.INSTANCE.convertToAdrDistrictDtoList(adrDistrictList);

        return adrDistrictDtoList;
    }

    public AdrDistrictDto save(AdrDistrictSaveRequestDto adrDistrictSaveRequestDto) {

        boolean isExist = adrProvinceService.existsById(adrDistrictSaveRequestDto.getProvinceId());
        if(!isExist) {
            throw new GenBusinessException(AdrErrorMessage.DistrictNotFound);
        }

        AdrDistrict adrDistrict = AdrDistrictMapper.INSTANCE.convertToAdrDistrict(adrDistrictSaveRequestDto);
        adrDistrict.setProvinceId(adrDistrictSaveRequestDto.getProvinceId());
        adrDistrict = adrDistrictEntityService.save(adrDistrict);

        AdrDistrictDto adrDistrictDto = AdrDistrictMapper.INSTANCE.convertToAdrDistrictDto(adrDistrict);

        return adrDistrictDto;
    }

    /**
     * @return This method returns the districts of the relevant province.
     */
    public List<AdrDistrictDto> findAllByProvinceId(Long provinceId) {

        AdrProvinceDto adrProvinceDto = adrProvinceService.findById(provinceId);

        if(adrProvinceDto == null) {
            throw new GenBusinessException(AdrErrorMessage.ProvinceNotFound);
        }

        List<AdrDistrict> adrDistrictList = adrDistrictEntityService.findAllByProvinceId(adrProvinceDto.getId());

        List<AdrDistrictDto> adrDistrictDtoList = AdrDistrictMapper.INSTANCE.convertToAdrDistrictDtoList(adrDistrictList);

        return adrDistrictDtoList;
    }

    public AdrDistrictDto findById(Long districtId) {

        AdrDistrict adrDistrict = adrDistrictEntityService.getByIdWithControl(districtId);

        if(adrDistrict == null) {
            throw new GenBusinessException(AdrErrorMessage.ProvinceNotFound);
        }

        AdrDistrictDto adrDistrictDto = AdrDistrictMapper.INSTANCE.convertToAdrDistrictDto(adrDistrict);

        return adrDistrictDto;
    }

    public boolean existsById(Long id) {

        return adrDistrictEntityService.existsById(id);
    }
}
