package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountryDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrProvince;
import com.softtech.case2ismaildemircann.app.adr.enums.AdrErrorMessage;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrProvinceMapper;
import com.softtech.case2ismaildemircann.app.adr.service.entityservice.AdrProvinceEntityService;
import com.softtech.case2ismaildemircann.app.gen.exceptions.GenBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdrProvinceService {

    private final AdrProvinceEntityService adrProvinceEntityService;
    private final AdrCountryService adrCountryService;

    /**
     * @return This method find all provinces info and return province list.
     */
    public List<AdrProvinceDto> findAll() {

        List<AdrProvince> adrProvinceList = adrProvinceEntityService.findAll();

        if(adrProvinceList == null) {
            throw new GenBusinessException(AdrErrorMessage.ProvinceNotFound);
        }

        List<AdrProvinceDto> adrProvinceDtoList = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDtoList(adrProvinceList);

        return adrProvinceDtoList;
    }

    /**
     * @return This method find province by id and return province info.
     */
    public AdrProvinceDto findById(Long id) {

        AdrProvince adrProvince = adrProvinceEntityService.getByIdWithControl(id);

        if(adrProvince == null) {
            throw new GenBusinessException(AdrErrorMessage.ProvinceNotFound);
        }

        AdrProvinceDto adrProvinceDto = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDto(adrProvince);

        return adrProvinceDto;
    }

    /**
     * @return This method save province and return saved object.
     */
    public AdrProvinceDto save(AdrProvinceSaveRequestDto adrProvinceSaveRequestDto) {

        AdrCountryDto adrCountryDto = adrCountryService.findByCountryCode(adrProvinceSaveRequestDto.getCountryCode());

        if(adrCountryDto == null) {
            throw new GenBusinessException(AdrErrorMessage.CountryNotFound);
        }

        AdrProvince adrProvince = AdrProvinceMapper.INSTANCE.convertToAdrProvince(adrProvinceSaveRequestDto);
        adrProvince.setCountryId(adrCountryDto.getId());
        adrProvince = adrProvinceEntityService.save(adrProvince);

        AdrProvinceDto adrProvinceDto = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDto(adrProvince);

        return adrProvinceDto;
    }

    /**
     * @return This method find province matched by license plate and return province info
     */
    public AdrProvinceDto findByLicensePlate(Long countryId, String licensePlate) {

        AdrProvince adrProvince = adrProvinceEntityService.findByCountryIdAndLicensePlate(countryId, licensePlate);

        AdrProvinceDto adrProvinceDto = AdrProvinceMapper.INSTANCE.convertToAdrProvinceDto(adrProvince);

        return adrProvinceDto;
    }

    public boolean existsById(Long provinceId) {

        return adrProvinceEntityService.existsById(provinceId);
    }
}
