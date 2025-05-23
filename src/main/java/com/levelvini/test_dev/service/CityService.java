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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService {

    ModelMapper mapper;
    CityRepository repository;

    @Transactional
    public Long getCityQuantity(){
        return repository.count();
    }

    @Transactional
    public List<CityDTO> getAll(){
        List<City> cities = repository.findAll();
        if (cities.isEmpty()){
            throw new EmptyDataException("There is no data registered yet");
        }
        return cities.stream().map(city -> mapper.map(city,CityDTO.class)).collect(Collectors.toList());
    }

    public Optional<CityDTO> getByState(String state_id, String city_id){
        return Optional.ofNullable(mapper.map(repository.findByIdAndStateId(city_id, state_id).orElseThrow(() -> new ResourceNotFoundException("city not found")), CityDTO.class));
    }


    @Transactional
    public Optional<CityDTO> getById(String id){
        return Optional.ofNullable(mapper.map(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found")), CityDTO.class));
    }

    @Transactional
    public String post(CityDTO city){
        City saved = repository.save(mapper.map(city,City.class));
        return String.format("The city %s has been saved",saved.getName());
    }

    @Transactional
    public String Update(String id, CityDTO cityDTO){
        City city = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("City not founded"));
        repository.save(mapper.map(cityDTO, City.class));
        return "the city as up to date";
    }

    @Transactional
    public String delete(String id){
        repository.delete(repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("City not founded")));
        return "the city has bee deleted";
    }

}
