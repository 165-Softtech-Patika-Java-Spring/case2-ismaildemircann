package com.softtech.case2ismaildemircann.app.adr.controller;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrDistrictDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrDistrictSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.service.AdrDistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/districts")
@RequiredArgsConstructor
public class AdrControllerDistrict {

    private final AdrDistrictService adrDistrictService;

    @GetMapping()
    public ResponseEntity findAllDistricts() {

        List<AdrDistrictDto> adrDistrictDtoList = adrDistrictService.findAll();

        return new ResponseEntity(adrDistrictDtoList, HttpStatus.OK);
    }

    @GetMapping("/{provinceName}")
    public ResponseEntity findAllDistrictByProvinceName(@PathVariable String provinceName) {

        List<AdrDistrictDto> adrDistrictDtoList = adrDistrictService.findAllByProvinceName(provinceName);

        return new ResponseEntity(adrDistrictDtoList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveDistrict(@RequestBody AdrDistrictSaveRequestDto adrDistrictSaveRequestDto) throws Exception {

        AdrDistrictDto adrDistrictDto = adrDistrictService.save(adrDistrictSaveRequestDto);
        return new ResponseEntity(adrDistrictDto, HttpStatus.OK);
    }
}
