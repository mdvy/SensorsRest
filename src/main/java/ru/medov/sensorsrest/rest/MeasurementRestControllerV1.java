package ru.medov.sensorsrest.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.medov.sensorsrest.model.dto.MeasurementDTO;
import ru.medov.sensorsrest.model.validation.ErrorResponse;
import ru.medov.sensorsrest.model.validation.MeasurementValidator;
import ru.medov.sensorsrest.model.validation.ViolationField;
import ru.medov.sensorsrest.services.MeasurementService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/measurements")
public class MeasurementRestControllerV1 {

    private final MeasurementValidator validator;
    private final MeasurementService measurementService;

    public MeasurementRestControllerV1(MeasurementValidator validator, MeasurementService measurementService) {
        this.validator = validator;
        this.measurementService = measurementService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMeasurement(@RequestBody @Valid MeasurementDTO measurementDTO,
                                            BindingResult bindingResult) {

        validator.validate(measurementDTO, bindingResult);

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(ErrorResponse.fromBindingResult(bindingResult), HttpStatus.BAD_REQUEST);
        }

        measurementService.save(measurementDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
