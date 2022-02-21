package com.softtech.case2ismaildemircann.app.adr.controller;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrStreetDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrStreetSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrStreetUpdateRequestDto;
import com.softtech.case2ismaildemircann.app.adr.service.AdrStreetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/streets")
@RequiredArgsConstructor
public class AdrControllerStreet {

    private final AdrStreetService adrStreetService;

    @GetMapping()
    public ResponseEntity findAllStreets() {

        List<AdrStreetDto> adrStreetDtoList = adrStreetService.findAll();

        return ResponseEntity.ok(adrStreetDtoList);
    }

    @GetMapping("/{neighborhoodId}")
    public ResponseEntity findAllStreetByNeighborhoodName(@PathVariable Long neighborhoodId) {

        List<AdrStreetDto> adrStreetDtoList = adrStreetService.findAllByNeighborhoodId(neighborhoodId);

        return ResponseEntity.ok(adrStreetDtoList);
    }

    @PostMapping()
    public ResponseEntity saveStreet(@RequestBody AdrStreetSaveRequestDto adrStreetSaveRequestDto) throws Exception {

        AdrStreetDto adrStreetDto = adrStreetService.save(adrStreetSaveRequestDto);
        return new ResponseEntity(adrStreetDto, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity updateStreetName(@RequestBody AdrStreetUpdateRequestDto adrStreetUpdateRequestDto) {

        AdrStreetDto adrStreetDto = adrStreetService.updateStreetName(adrStreetUpdateRequestDto);

        return ResponseEntity.ok(adrStreetDto);
    }
}
