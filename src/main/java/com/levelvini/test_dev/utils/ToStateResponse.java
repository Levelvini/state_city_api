package com.levelvini.test_dev.utils;

import com.levelvini.test_dev.DTO.StateResponse;
import com.levelvini.test_dev.model.City;
import com.levelvini.test_dev.model.State;

import java.util.stream.Collectors;

public class ToStateResponse {public static StateResponse toStateResponse(State state){
    return new StateResponse(state.getId(),
            state.getAbbreviation(),
            state.getAbbreviation(),
            state.getCities().stream().map(City::getId).collect(Collectors.toList()));
}
}
