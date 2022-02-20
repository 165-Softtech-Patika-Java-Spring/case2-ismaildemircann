package com.softtech.case2ismaildemircann.app.adr.controller;

import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDetailDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressDto;
import com.softtech.case2ismaildemircann.app.adr.dto.AdrAddressSaveRequestDto;
import com.softtech.case2ismaildemircann.app.adr.service.AdrAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class AdrControllerAddress {

    private final AdrAddressService adrAddressService;
    @GetMapping("/address/{id}")
    public ResponseEntity findAddress(@PathVariable Long id) {

        AdrAddressDetailDto adrAddressDetailDto = adrAddressService.findAddressById(id);

        return ResponseEntity.ok(adrAddressDetailDto);
    }

    @PostMapping("/address")
    public ResponseEntity saveAddress(@RequestBody AdrAddressSaveRequestDto adrAddressSaveRequestDto) {

        AdrAddressDto adrAddressDto = adrAddressService.save(adrAddressSaveRequestDto);

        return ResponseEntity.ok(adrAddressDto);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity deleteAddress(@PathVariable Long id) {

        adrAddressService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }
}
