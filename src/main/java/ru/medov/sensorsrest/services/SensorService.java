package ru.medov.sensorsrest.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.medov.sensorsrest.exception.SensorNotFoundException;
import ru.medov.sensorsrest.model.Sensor;
import ru.medov.sensorsrest.model.dto.SensorDTO;
import ru.medov.sensorsrest.repository.SensorRepo;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepo sensorRepo;

    private final ModelMapper modelMapper;
    public SensorService(SensorRepo sensorRepo, ModelMapper modelMapper) {
        this.sensorRepo = sensorRepo;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void save(SensorDTO sensorDTO) {
        sensorRepo.save(modelMapper.map(sensorDTO, Sensor.class));
    }

    public SensorDTO findByName(String name) {
        Sensor sensor = sensorRepo.findByName(name).orElseThrow(SensorNotFoundException::new);

        return modelMapper.map(sensor, SensorDTO.class);
    }

    public boolean isSensorExists(String name) {
        return sensorRepo.findByName(name).isPresent();
    }
}
