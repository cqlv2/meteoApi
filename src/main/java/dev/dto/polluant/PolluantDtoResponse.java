package dev.dto.polluant;

import dev.dto.SuperDto;
import dev.entity.Polluant;

public class PolluantDtoResponse extends SuperDto {
    private String label;
    private Double value;

    public PolluantDtoResponse(Polluant entity) {
        this.id = entity.getId();
        this.dateAdd = entity.getDateAdd();
        this.label = entity.getLabel();
        this.value = entity.getValue();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
