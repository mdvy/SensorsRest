package ru.medov.sensorsrest.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medov.sensorsrest.model.dto.SensorDTO;
import ru.medov.sensorsrest.model.validation.ErrorResponse;
import ru.medov.sensorsrest.model.validation.SensorValidator;
import ru.medov.sensorsrest.model.validation.ViolationField;
import ru.medov.sensorsrest.services.SensorService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorRestControllerV1 {

    private final SensorService sensorService;
    private final SensorValidator validator;

    public SensorRestControllerV1(SensorService sensorService, SensorValidator validator) {
        this.sensorService = sensorService;
        this.validator = validator;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody @Valid SensorDTO sensorDTO,
                           BindingResult bindingResult){

        validator.validate(sensorDTO, bindingResult);

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(ErrorResponse.fromBindingResult(bindingResult), HttpStatus.BAD_REQUEST);
        }

        sensorService.save(sensorDTO);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
