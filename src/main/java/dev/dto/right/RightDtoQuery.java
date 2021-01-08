package dev.dto.right;

import java.util.List;

import dev.dto.SuperDto;
import dev.enumeration.RightEnum;

public class RightDtoQuery extends SuperDto {
	
	
	private RightEnum label;
	private List<Long> RolesId;
	
	
	
	
	public RightEnum getLabel() {
		return label;
	}
	public void setLabel(RightEnum label) {
		this.label = label;
	}
	public List<Long> getRolesId() {
		return RolesId;
	}
	public void setRoleId(List<Long> rolesId) {
		RolesId = rolesId;
	}
	
	
}
