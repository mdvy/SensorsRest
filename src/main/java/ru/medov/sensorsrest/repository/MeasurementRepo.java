package ru.medov.sensorsrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.medov.sensorsrest.model.Measurement;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurement, Long> {
}
