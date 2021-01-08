package dev.dto.role;

import java.util.List;

import dev.dto.SuperDto;
import dev.enumeration.RoleEnum;

public class RoleDtoQuery extends SuperDto {

	private RoleEnum label;
	private List<Long> rightsId;

	public RoleEnum getLabel() {
		return label;
	}

	public void setLabel(RoleEnum label) {
		this.label = label;
	}

	public List<Long> getRightsId() {
		return rightsId;
	}

	public void setRightsId(List<Long> rightsId) {
		this.rightsId = rightsId;
	}

}
