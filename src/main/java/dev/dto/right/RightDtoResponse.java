package dev.dto.right;

import dev.dto.SuperDto;
import dev.entity.Right;
import dev.enumeration.RightEnum;

public class RightDtoResponse extends SuperDto {

	private RightEnum label;

	public RightDtoResponse() {
	}

	public RightDtoResponse(Right entity) {
		super();
		this.label = entity.getLabel();
	}

	public RightEnum getLabel() {
		return label;
	}

	public void setLabel(RightEnum label) {
		this.label = label;
	}

}
