package com.softtech.case2ismaildemircann.app.adr.controller;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrNeighborhoodDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrNeighborhoodSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrNeighborhoodUpdateRequestDto;
import com.softtech.case2ismaildemircann.app.adr.service.AdrNeighborhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/neighborhoods")
@RequiredArgsConstructor
public class AdrControllerNeighborhood {

    private final AdrNeighborhoodService adrNeighborhoodService;

    @GetMapping()
    public ResponseEntity findAllNeighborhoods() {

        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = adrNeighborhoodService.findAll();

        return new ResponseEntity(adrNeighborhoodDtoList, HttpStatus.OK);
    }

    @GetMapping("/{districtId}")
    public ResponseEntity findAllNeighborhoodsByDistrictName(@PathVariable Long districtId) {

        List<AdrNeighborhoodDto> adrNeighborhoodDtoList = adrNeighborhoodService.findAllByDistrictId(districtId);

        return ResponseEntity.ok(adrNeighborhoodDtoList);
    }

    @PostMapping()
    public ResponseEntity saveNeighborhood(@RequestBody AdrNeighborhoodSaveRequestDto adrNeighborhoodSaveRequestDto) throws Exception {

        AdrNeighborhoodDto adrNeighborhoodDto = adrNeighborhoodService.save(adrNeighborhoodSaveRequestDto);
        return new ResponseEntity(adrNeighborhoodDto, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity updateNeighborhoodName(@RequestBody AdrNeighborhoodUpdateRequestDto adrNeighborhoodUpdateRequestDto) {

        AdrNeighborhoodDto adrNeighborhoodDto = adrNeighborhoodService.updateNeighborhoodName(adrNeighborhoodUpdateRequestDto);

        return ResponseEntity.ok(adrNeighborhoodDto);
    }

}
