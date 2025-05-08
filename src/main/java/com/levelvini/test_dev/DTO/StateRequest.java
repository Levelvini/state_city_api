package com.levelvini.test_dev.DTO;

import com.levelvini.test_dev.model.City;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateRequest {
    String id;
    @Min(value = 3,message = "invalid name")
    @NotBlank(message = "invalid name")
    String name;
    @Max(value = 4, message = "invalid abbreviation")
    @NotBlank(message = "invalid abbreviation")
    String abbreviation;
    List<City> cities;
}
