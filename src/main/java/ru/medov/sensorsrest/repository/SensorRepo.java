package ru.medov.sensorsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.medov.sensorsrest.model.Sensor;

import java.util.Optional;

@Repository
public interface SensorRepo extends JpaRepository<Sensor, Long> {

    Optional<Sensor> findByName(String name);

}
