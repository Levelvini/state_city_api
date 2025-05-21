package com.levelvini.test_dev.controller;

import com.levelvini.test_dev.DTO.CityDTO;
import com.levelvini.test_dev.service.CityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("city/")
public class CityController {

CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @RequestMapping("/{stateId}/{cityId}")
    public ResponseEntity<Optional<CityDTO>> getByState(@PathVariable String stateId, @PathVariable String cityId){
        return ResponseEntity.ok(service.getByState(stateId,cityId));
    }

    @RequestMapping
    public ResponseEntity<List<CityDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Optional<CityDTO>> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody CityDTO cityDTO){
        return ResponseEntity.ok(service.post(cityDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id,@Valid @RequestBody CityDTO cityDTO){
        return ResponseEntity.ok(service.Update(id,cityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
            return ResponseEntity.ok(service.delete(id));
    }
}
