package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrAddressDao;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDetailDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrAddress;
import com.softtech.case2ismaildemircann.app.adr.entitiy.results.AdrAddressResult;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdrAddressService {

    private final AdrAddressDao adrAddressDao;

    public AdrAddressDto save(AdrAddressSaveRequestDto adrAddressSaveRequestDto) {

        AdrAddress adrAddress = AdrAddressMapper.INSTANCE.convertAdrAddress(adrAddressSaveRequestDto);

        adrAddress = adrAddressDao.save(adrAddress);

        AdrAddressDto adrAddressDto = AdrAddressMapper.INSTANCE.convertAdrAddressDto(adrAddress);

        return adrAddressDto;
    }

    public void delete(Long id) {

        adrAddressDao.deleteById(id);
    }

    public AdrAddressDetailDto findAddressById(Long id) {

        AdrAddressResult adrAddressResult = adrAddressDao.findAddressByIdWithDetail(id);

        AdrAddressDetailDto adrAddressDetailDto = AdrAddressMapper.INSTANCE.convertAdrAddressResultToAdrAddressDto(adrAddressResult);

        return adrAddressDetailDto;
    }
}
