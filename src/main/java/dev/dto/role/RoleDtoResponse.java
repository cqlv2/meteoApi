package dev.dto.role;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;
import dev.dto.right.RightDtoResponse;
import dev.entity.Right;
import dev.entity.Role;
import dev.enumeration.RoleEnum;
import dev.utils.transformer.RightTransformer;
import dev.utils.transformer.SuperTransformer;

public class RoleDtoResponse extends SuperDto {

	private RoleEnum label;
	private List<RightDtoResponse> rights = new ArrayList<>();

	// constructors
	public RoleDtoResponse(Role entity) {
		this.id = entity.getId();
		this.dateAdd = entity.getDateAdd();
		this.label = entity.getLabel();
		for (Right r : entity.getRights()) {
			rights.add(RightTransformer.entityToDtoResponse(r));
		}
	}
	// getteurSetteur

	public RoleEnum getLabel() {
		return label;
	}

	public void setLabel(RoleEnum label) {
		this.label = label;
	}

	public List<RightDtoResponse> getRights() {
		return rights;
	}

	public void setRights(List<RightDtoResponse> rights) {
		this.rights = rights;
	}

}
