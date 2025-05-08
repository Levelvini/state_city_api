package com.levelvini.test_dev.model;

import com.levelvini.test_dev.utils.IdGenerate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "cities")
public class City {
    @Id
    @EqualsAndHashCode.Include
    private final String id = IdGenerate.idGenerate();
    private final String name;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
