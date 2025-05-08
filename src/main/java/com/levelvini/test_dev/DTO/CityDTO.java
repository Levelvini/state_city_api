package com.levelvini.test_dev.DTO;

import com.levelvini.test_dev.model.State;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
    @Min(value = 3)
    @NotBlank(message = "name invalid")
    String name;
    State state;
}
