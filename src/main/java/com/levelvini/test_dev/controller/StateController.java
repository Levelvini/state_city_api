package com.levelvini.test_dev.controller;


import com.levelvini.test_dev.DTO.StateRequest;
import com.levelvini.test_dev.DTO.StateResponse;
import com.levelvini.test_dev.service.StateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("state/")
public class StateController {

    public StateService service;

    public StateController(StateService service) {
        this.service = service;
    }

    @GetMapping("/quantity")
    public ResponseEntity<Long> getQuantity(){
        return ResponseEntity.ok(service.getStateQuantity());
    }

    @GetMapping
    public ResponseEntity<List<StateResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateResponse> getById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody StateRequest stateRequest){
        return ResponseEntity.ok(service.post(stateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @Valid @RequestBody StateRequest stateRequest){
        return ResponseEntity.ok(service.update(id,stateRequest));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable  String id){
        return ResponseEntity.ok(service.delete(id));
    }
}
