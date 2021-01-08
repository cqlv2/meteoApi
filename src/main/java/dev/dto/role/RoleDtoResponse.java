package dev.dto.role;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;
import dev.dto.right.RightDtoResponse;
import dev.entity.Right;
import dev.entity.Role;
import dev.enumeration.RoleEnum;
import dev.utils.transformer.SuperTransformer;

public class RoleDtoResponse extends SuperDto {

	private RoleEnum label;
	private List<RightDtoResponse> rights = new ArrayList<RightDtoResponse>();

	// constructors
	public RoleDtoResponse() {
	}

	public RoleDtoResponse(Role role) {
		super();
		this.label = role.getLabel();
		for (Right r : role.getRights()) {
			rights.add((RightDtoResponse)SuperTransformer.entityToDtoResponse(r));
		}

	}

	
}
