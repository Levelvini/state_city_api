package com.levelvini.test_dev.config;

import com.levelvini.test_dev.model.City;
import com.levelvini.test_dev.model.State;
import com.levelvini.test_dev.repository.CityRepository;
import com.levelvini.test_dev.repository.StateRepository;
import org.springframework.stereotype.Component;

@Component

public abstract class InitialData implements Runnable{
    CityRepository cityRepository;
    StateRepository stateRepository;

    public InitialData(CityRepository cityRepository, StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    public void run(){

        State state1 = new State("Goias","GO",null);
        State state2 = new State("Bahia","BA",null);
        State state3 = new State("Minas Gerais","MG",null);
        State state4 = new State("São Paulo","SP",null);

        City city1 = new City("Cocos",state2);
        City city2 = new City("Goiânia",state1);
        City city3 = new City("Montalvãnia",state3);
        City city4 = new City("São Paulo",state4);

        stateRepository.save(state1);
        stateRepository.save(state2);
        stateRepository.save(state3);
        stateRepository.save(state4);

        cityRepository.save(city1);
        cityRepository.save(city2);
        cityRepository.save(city3);
        cityRepository.save(city4);
    }

}
