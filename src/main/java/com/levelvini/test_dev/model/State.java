package com.levelvini.test_dev.model;

import com.levelvini.test_dev.utils.IdGenerate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Target;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "states")
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode()
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private final String id = IdGenerate.idGenerate();
    private final String name;
    private final String abbreviation;
    @OneToMany(mappedBy = "state",cascade = CascadeType.ALL)
    private List<City> cities;
}
