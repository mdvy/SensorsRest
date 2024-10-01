package ru.medov.sensorsrest.model.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class ViolationField {

    private final String fieldName;
    private final String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViolationField violationField = (ViolationField) o;
        return Objects.equals(fieldName, violationField.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName);
    }
}