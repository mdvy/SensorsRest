package ru.medov.sensorsrest.model.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.medov.sensorsrest.model.dto.MeasurementDTO;
import ru.medov.sensorsrest.services.SensorService;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(MeasurementDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MeasurementDTO measurementDTO = (MeasurementDTO) target;

        if(!sensorService.isSensorExists(measurementDTO.getSensorName()))
            errors.rejectValue("sensor", "",   measurementDTO.getSensorName() + " не зарегистрирован в системе");
    }
}
