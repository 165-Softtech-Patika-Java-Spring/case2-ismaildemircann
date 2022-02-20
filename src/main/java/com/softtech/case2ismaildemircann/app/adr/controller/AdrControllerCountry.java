package com.softtech.case2ismaildemircann.app.adr.controller;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountryDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrCountrySaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.service.AdrCountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/countries")
@RequiredArgsConstructor
public class AdrControllerCountry {

    private final AdrCountryService adrCountryService;

    @GetMapping()
    public ResponseEntity findAllCountry() {

        List<AdrCountryDto> adrCountryDtoList = adrCountryService.findAll();

        return new ResponseEntity(adrCountryDtoList, HttpStatus.OK);
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity findByCountryCode(@PathVariable String countryCode) {

        AdrCountryDto adrCountryDto = adrCountryService.findByCountryCode(countryCode);
        return new ResponseEntity(adrCountryDto, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveCountry(@RequestBody AdrCountrySaveRequestDto adrCountrySaveRequestDto) {

        AdrCountryDto adrCountryDto = adrCountryService.save(adrCountrySaveRequestDto);
        return new ResponseEntity(adrCountryDto, HttpStatus.OK);
    }
}
