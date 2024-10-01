package ru.medov.sensorsrest.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.medov.sensorsrest.model.Measurement;
import ru.medov.sensorsrest.model.dto.MeasurementDTO;
import ru.medov.sensorsrest.repository.MeasurementRepo;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepo measurementRepo;
    private final ModelMapper modelMapper;

    public MeasurementService(MeasurementRepo measurementRepo, ModelMapper modelMapper) {
        this.measurementRepo = measurementRepo;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void save(MeasurementDTO measurementDTO) {
        measurementRepo.save(modelMapper.map(measurementDTO, Measurement.class));
    }
}
