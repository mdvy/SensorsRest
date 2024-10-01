package ru.medov.sensorsrest.model.validation;

import lombok.Data;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class ErrorResponse {

    private LocalDateTime timestamp = LocalDateTime.now();

    private Set<ViolationField> violations;

    private ErrorResponse(Set<ViolationField> violations) {
        this.violations = violations;
    }

    public static ErrorResponse fromBindingResult(BindingResult bindingResult){
        Set<ViolationField> violationFields = bindingResult.getFieldErrors().stream()
                .map(error ->
                        new ViolationField(error.getObjectName(), error.getDefaultMessage()))
                .collect(Collectors.toSet());
        return new ErrorResponse(violationFields);
    }
}
