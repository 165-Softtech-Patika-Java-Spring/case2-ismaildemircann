package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDetailDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrAddress;
import com.softtech.case2ismaildemircann.app.adr.entitiy.results.AdrAddressResult;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrAddressMapper;
import com.softtech.case2ismaildemircann.app.adr.service.entityservice.AdrAddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdrAddressService {

    private final AdrAddressEntityService adrAddressEntityService;

    public AdrAddressDto save(AdrAddressSaveRequestDto adrAddressSaveRequestDto) {

        AdrAddress adrAddress = AdrAddressMapper.INSTANCE.convertAdrAddress(adrAddressSaveRequestDto);

        adrAddress = adrAddressEntityService.save(adrAddress);

        AdrAddressDto adrAddressDto = AdrAddressMapper.INSTANCE.convertAdrAddressDto(adrAddress);

        return adrAddressDto;
    }

    public void delete(Long id) {

        adrAddressEntityService.deleteById(id);
    }

    public AdrAddressDetailDto findAddressById(Long id) {

        AdrAddressResult adrAddressResult = adrAddressEntityService.findAddressByIdWithDetail(id);

        AdrAddressDetailDto adrAddressDetailDto = AdrAddressMapper.INSTANCE.convertAdrAddressResultToAdrAddressDto(adrAddressResult);

        return adrAddressDetailDto;
    }
}
