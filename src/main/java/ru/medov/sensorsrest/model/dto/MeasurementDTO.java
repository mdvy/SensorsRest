package ru.medov.sensorsrest.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MeasurementDTO {

    private final String ERROR_MESSAGE_VALUE="значение температуры должно находиться в пределах [-100; 100]";

    @NotEmpty
    @Min(value = -100, message = ERROR_MESSAGE_VALUE)
    @Max(value = 100, message = ERROR_MESSAGE_VALUE)
    private Double value;

    @NotEmpty
    @Pattern(regexp = "^(true|false)$", message = "поле isRaining может принимать значение true или false")
    private Boolean isRaining;

    @NotEmpty
    private String sensorName;
}
