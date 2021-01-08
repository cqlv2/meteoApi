package dev.utils.transformer;

import dev.dto.right.RightDtoQuery;
import dev.dto.right.RightDtoResponse;
import dev.entity.Right;
import dev.entity.Role;

public class RightTransformer {

	public static RightDtoResponse entityToDtoResponse(Right entity) {
		RightDtoResponse rightDto = new RightDtoResponse(entity);
		return rightDto;
	}

	public static Right dtoToEntity(RightDtoQuery dtoRequete) {
		
		Right r =new Right();
		r.setId(dtoRequete.getId());
		r.setLabel(dtoRequete.getLabel());
		for (Long id : dtoRequete.getRolesId()) {
			Role role=new Role();
			role.setId(id);
			r.getRoles().add(role);	
		}
		return r;
	}
}
