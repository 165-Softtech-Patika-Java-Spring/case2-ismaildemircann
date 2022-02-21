package com.softtech.case2ismaildemircann.app.adr.service;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDetailDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrAddress;
import com.softtech.case2ismaildemircann.app.adr.entitiy.results.AdrAddressResult;
import com.softtech.case2ismaildemircann.app.adr.enums.AdrErrorMessage;
import com.softtech.case2ismaildemircann.app.adr.mapper.AdrAddressMapper;
import com.softtech.case2ismaildemircann.app.adr.service.entityservice.AdrAddressEntityService;
import com.softtech.case2ismaildemircann.app.gen.exceptions.GenBusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdrAddressService {

    private final AdrAddressEntityService adrAddressEntityService;

    /**
     * @return This method save address info and return saved object
     */
    public AdrAddressDto save(AdrAddressSaveRequestDto adrAddressSaveRequestDto) {

        AdrAddress adrAddress = AdrAddressMapper.INSTANCE.convertAdrAddress(adrAddressSaveRequestDto);

        adrAddress = adrAddressEntityService.save(adrAddress);

        AdrAddressDto adrAddressDto = AdrAddressMapper.INSTANCE.convertAdrAddressDto(adrAddress);

        return adrAddressDto;
    }

    /**
     * @return This method delete address info and return void
     */
    public void delete(Long id) {

        adrAddressEntityService.deleteById(id);
    }

    /**
     * @return This method find address info and return result
     */
    public AdrAddressDetailDto findAddressById(Long id) {

        AdrAddressResult adrAddressResult = adrAddressEntityService.findAddressByIdWithDetail(id);

        if(adrAddressResult == null) {
            throw new GenBusinessException(AdrErrorMessage.AddressNotFound);
        }

        AdrAddressDetailDto adrAddressDetailDto = AdrAddressMapper.INSTANCE.convertAdrAddressResultToAdrAddressDto(adrAddressResult);

        return adrAddressDetailDto;
    }
}
