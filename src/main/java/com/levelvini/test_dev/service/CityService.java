package com.levelvini.test_dev.service;

import com.levelvini.test_dev.DTO.CityDTO;
import com.levelvini.test_dev.exceptions.EmptyDataException;
import com.levelvini.test_dev.exceptions.ResourceNotFoundException;
import com.levelvini.test_dev.model.City;
import com.levelvini.test_dev.repository.CityRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService {

    ModelMapper mapper;
    CityRepository repository;

    @Transactional
    private Long getCityQuantity(){
        return repository.count();
    }

    @Transactional
    private List<CityDTO> getAll(){
        List<City> cities = repository.findAll();
        if (cities.isEmpty()){
            throw new EmptyDataException("There is no data registered yet");
        }
        return cities.stream().map(city -> mapper.map(city,CityDTO.class)).collect(Collectors.toList());
    }

    @Transactional
    private Optional<CityDTO> getById(String id){
        return Optional.ofNullable(mapper.map(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found")), CityDTO.class));
    }

    @Transactional
    private Optional<CityDTO> post(CityDTO city){
        City toDTO = mapper.map(city,City.class);
        return Optional.of(mapper.map(repository.save(toDTO),CityDTO.class));
    }

    @Transactional
    private String Update(String id, CityDTO cityDTO){
        City city = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("City not founded"));
        repository.save(mapper.map(cityDTO, City.class));
        return "the city as up to date";
    }

    @Transactional
    private String delete(String id){
        repository.delete(repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("City not founded")));
        return "the city has bee deleted";
    }
}
