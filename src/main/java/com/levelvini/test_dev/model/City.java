package com.levelvini.test_dev.model;

import com.levelvini.test_dev.utils.IdGenerate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "cities")
public class City {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "city_id")
    private final String id = IdGenerate.idGenerate();
    private String name;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
