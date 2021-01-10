package dev.dto.right;

import dev.dto.SuperDto;
import dev.entity.Right;
import dev.enumeration.RightEnum;

public class RightDtoResponse extends SuperDto {

	private RightEnum label;

	// constructor
	public RightDtoResponse(Right entity) {
		this.id = entity.getId();
		this.dateAdd = entity.getDateAdd();
		this.label = entity.getLabel();
	}

	// getteurSetteur
	public RightEnum getLabel() {
		return label;
	}

	public void setLabel(RightEnum label) {
		this.label = label;
	}

}
