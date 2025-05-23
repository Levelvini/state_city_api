package com.levelvini.test_dev.service;

import com.levelvini.test_dev.DTO.StateRequest;
import com.levelvini.test_dev.DTO.StateResponse;
import com.levelvini.test_dev.exceptions.EmptyDataException;
import com.levelvini.test_dev.exceptions.ResourceNotFoundException;
import com.levelvini.test_dev.model.State;
import com.levelvini.test_dev.repository.CityRepository;
import com.levelvini.test_dev.repository.StateRepository;
import com.levelvini.test_dev.utils.ToStateResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StateService {

    ModelMapper mapper;
    StateRepository stateRepository;
    CityRepository cityRepository;

    @Transactional
    public Long getStateQuantity(){
       long total = stateRepository.count();
       return total;
    }

    @Transactional
    public List<StateResponse> getAll(){
       List<State> allStates = stateRepository.findAll();
       if (allStates.isEmpty()){
           throw new EmptyDataException("There is no data registered yet");
       }
       return allStates.stream().map(ToStateResponse::toStateResponse).toList();
    }
    @Transactional
    public StateResponse getById(String id){
        return ToStateResponse.toStateResponse(stateRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not found")));
    }

    @Transactional
    public String post(StateRequest state){
        State save = stateRepository.save(mapper.map(state,State.class));
        return String.format("the state %s has been saved", save.getName());
    }

    @Transactional
    public String update(String id, StateRequest state){
        stateRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("state not founded"));
        stateRepository.save(mapper.map(state,State.class));
        return "the state are up to date";
    }

    public String delete(String id){
        stateRepository.delete(stateRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("state not founded")));
        return "the state has been deleted";
    }
}