package com.softtech.case2ismaildemircann.app.adr.controller;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrProvinceSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.service.AdrProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/provinces")
@RequiredArgsConstructor
public class AdrControllerProvince {

    private final AdrProvinceService adrProvinceService;

    @GetMapping()
    public ResponseEntity findAllProvinces() {

        List<AdrProvinceDto> adrProvinceDtoList = adrProvinceService.findAll();

        return new ResponseEntity(adrProvinceDtoList, HttpStatus.OK);
    }

    @GetMapping("/{countryId}/{licensePlate}")
    public ResponseEntity findByLicensePlate(@PathVariable Long countryId, @PathVariable String licensePlate) {

        AdrProvinceDto adrProvinceDto = adrProvinceService.findByLicensePlate(countryId,licensePlate);
        return new ResponseEntity(adrProvinceDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveProvince(@RequestBody AdrProvinceSaveRequestDto adrProvinceSaveRequestDto) {

        AdrProvinceDto adrProvinceDto = adrProvinceService.save(adrProvinceSaveRequestDto);
        return new ResponseEntity(adrProvinceDto, HttpStatus.OK);
    }
}
