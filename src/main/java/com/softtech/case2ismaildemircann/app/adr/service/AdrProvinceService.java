package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountryDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrProvince;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrProvinceMapper;
import com.softtech.case2ismaildemircann.app.adr.service.entityservice.AdrProvinceEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrProvinceService {

    private final AdrProvinceEntityService adrProvinceEntityService;
    private final AdrCountryService adrCountryService;

    public List<AdrProvinceDto> findAll() {

        List<AdrProvince> adrProvinceList = adrProvinceEntityService.findAll();

        List<AdrProvinceDto> adrProvinceDtoList = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDtoList(adrProvinceList);

        return adrProvinceDtoList;
    }

    public AdrProvinceDto findById(Long id) {

        AdrProvince adrProvince = adrProvinceEntityService.getByIdWithControl(id);

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
        adrProvince = adrProvinceEntityService.save(adrProvince);

        AdrProvinceDto adrProvinceDto = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDto(adrProvince);

        return adrProvinceDto;
    }

    public AdrProvinceDto findByLicensePlate(Long countryId, String licensePlate) {

        AdrProvince adrProvince = adrProvinceEntityService.findByCountryIdAndLicensePlate(countryId, licensePlate);

        AdrProvinceDto adrProvinceDto = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDto(adrProvince);

        return adrProvinceDto;
    }

    public boolean existsById(Long provinceId) {
        return adrProvinceEntityService.existsById(provinceId);
    }
}
