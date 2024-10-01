package ru.medov.sensorsrest.model.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.medov.sensorsrest.exception.SensorNotFoundException;
import ru.medov.sensorsrest.model.Sensor;
import ru.medov.sensorsrest.model.dto.SensorDTO;
import ru.medov.sensorsrest.repository.SensorRepo;
import ru.medov.sensorsrest.services.SensorService;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorDTO = (SensorDTO) target;

        if(sensorService.isSensorExists(sensorDTO.getName()))
            errors.rejectValue("name","", "такой датчик уже существует");

    }
}
