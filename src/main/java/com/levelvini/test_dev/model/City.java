package com.levelvini.test_dev.model;

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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private final UUID id;
    private final String name;
    @OneToOne
    @JoinColumn(name = "state_id")
    private State state;
}
