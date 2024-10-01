package ru.medov.sensorsrest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "measurements")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", unique = true, nullable = false)
    private Double value;

    @Column(name = "is_raining", unique = true, nullable = false)
    private Boolean isRaining;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Sensor sensor;
}
