package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrDistrictDao;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrDistrictDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrDistrictSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrDistrict;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrDistrictMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrDistrictService {

    private final AdrDistrictDao adrDistrictDao;
    private final AdrProvinceService adrProvinceService;

    public List<AdrDistrictDto> findAll() {

        List<AdrDistrict> adrDistrictList = adrDistrictDao.findAll();

        List<AdrDistrictDto> adrDistrictDtoList = AdrDistrictMapper.INSTANCE.convertToAdrDistrictDtoList(adrDistrictList);

        return adrDistrictDtoList;
    }

    public AdrDistrictDto save(AdrDistrictSaveRequestDto adrDistrictSaveRequestDto) throws Exception {

        boolean isExist = adrProvinceService.existsById(adrDistrictSaveRequestDto.getProvinceId());
        if(!isExist) {
            throw new Exception("Province not found!");
        }

        AdrDistrict adrDistrict = AdrDistrictMapper.INSTANCE.convertToAdrDistrict(adrDistrictSaveRequestDto);
        adrDistrict.setProvinceId(adrDistrictSaveRequestDto.getProvinceId());
        adrDistrict = adrDistrictDao.save(adrDistrict);

        AdrDistrictDto adrDistrictDto = AdrDistrictMapper.INSTANCE.convertToAdrDistrictDto(adrDistrict);

        return adrDistrictDto;
    }

    public List<AdrDistrictDto> findAllByProvinceName(String provinceName) {

        AdrProvinceDto adrProvinceDto = adrProvinceService.findByName(provinceName);

        List<AdrDistrict> adrDistrictList = adrDistrictDao.findAllByProvinceId(adrProvinceDto.getId());

        List<AdrDistrictDto> adrDistrictDtoList = AdrDistrictMapper.INSTANCE.convertToAdrDistrictDtoList(adrDistrictList);

        return adrDistrictDtoList;
    }

    public AdrDistrictDto findByName(String name) {

        AdrDistrict adrDistrict = adrDistrictDao.findByName(name);

        AdrDistrictDto adrDistrictDto = AdrDistrictMapper.INSTANCE.convertToAdrDistrictDto(adrDistrict);

        return adrDistrictDto;
    }

    public boolean existsById(Long id) {

        return adrDistrictDao.existsById(id);
    }
}
