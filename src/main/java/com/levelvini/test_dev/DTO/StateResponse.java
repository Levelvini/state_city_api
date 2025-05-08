package com.levelvini.test_dev.DTO;

import com.levelvini.test_dev.model.City;
import com.levelvini.test_dev.model.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateResponse {
    String id;
    String name;
    String abbreviation;
    List<String> citiesId;


}
