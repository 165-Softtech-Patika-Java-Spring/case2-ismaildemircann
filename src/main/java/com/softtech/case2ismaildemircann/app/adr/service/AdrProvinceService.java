package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrProvinceDao;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountryDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrProvince;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrProvinceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrProvinceService {

    private final AdrProvinceDao adrProvinceDao;
    private final AdrCountryService adrCountryService;

    public List<AdrProvinceDto> findAll() {

        List<AdrProvince> adrProvinceList = adrProvinceDao.findAll();

        List<AdrProvinceDto> adrProvinceDtoList = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDtoList(adrProvinceList);

        return adrProvinceDtoList;
    }

    public AdrProvinceDto findByName(String name) {

        AdrProvince adrProvince = adrProvinceDao.findByName(name);

        AdrProvinceDto adrProvinceDto = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDto(adrProvince);

        return adrProvinceDto;
    }

    public AdrProvinceDto save(AdrProvinceSaveRequestDto adrProvinceSaveRequestDto) throws Exception {

        AdrCountryDto adrCountryDto = adrCountryService.findByCountryCode(adrProvinceSaveRequestDto.getCountryCode());

        if(adrCountryDto == null) {
            throw new Exception("Country not found!");
        }

        AdrProvince adrProvince = AdrProvinceMapper.INSTANCE.convertToAdrProvince(adrProvinceSaveRequestDto);
        adrProvince.setCountryId(adrCountryDto.getId());
        adrProvince = adrProvinceDao.save(adrProvince);

        AdrProvinceDto adrProvinceDto = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDto(adrProvince);

        return adrProvinceDto;
    }

    public AdrProvinceDto findByLicensePlate(String licensePlate) {

        AdrProvince adrProvince = adrProvinceDao.findByLicensePlate(licensePlate);

        AdrProvinceDto adrProvinceDto = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDto(adrProvince);

        return adrProvinceDto;
    }

    public boolean existsById(Long id) {

        return adrProvinceDao.existsById(id);
    }
}
