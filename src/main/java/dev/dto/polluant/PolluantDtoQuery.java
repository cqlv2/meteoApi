package dev.dto.polluant;

import dev.dto.SuperDto;

public class PolluantDtoQuery extends SuperDto {

    private String label;
    private Double value;
    private Long cityId;


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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
