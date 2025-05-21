package com.levelvini.test_dev.model;

import com.levelvini.test_dev.utils.IdGenerate;
import jakarta.persistence.*;
import lombok.*;

import java.lang.annotation.Target;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "states")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode()
public class State {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "state_id")
    private final String id = IdGenerate.idGenerate();
    private  String name;
    private  String abbreviation;
    @OneToMany(mappedBy = "state",cascade = CascadeType.ALL)
    private List<City> cities;


}
