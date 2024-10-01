package ru.medov.sensorsrest.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDTO {

    private final String ERROR_MESSAGE = "имя сенсора должно быть длиной от 5 до 100 символов";

    @NotEmpty(message = ERROR_MESSAGE)
    @Size(min = 5, max = 100, message = ERROR_MESSAGE)
    private String name;
}
