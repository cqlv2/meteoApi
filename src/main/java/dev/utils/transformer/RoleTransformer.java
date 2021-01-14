package dev.utils.transformer;

import dev.dto.role.RoleDtoQuery;
import dev.dto.role.RoleDtoResponse;
import dev.entity.Right;
import dev.entity.Role;

public class RoleTransformer {

	public static RoleDtoResponse entityToDtoResponse(Role entity) {
		RoleDtoResponse memberDto = new RoleDtoResponse(entity);
		return memberDto;
	}

	public static Role dtoToEntity(RoleDtoQuery dtoRequete) {
		Role r = new Role();
		r.setId(dtoRequete.getId() != null ? dtoRequete.getId() : null);
		r.setLabel(dtoRequete.getLabel());
		
		// ajout des droits
		if(dtoRequete.getRightsId()!=null) {
			for (Long roleId : dtoRequete.getRightsId()) {
				Right right = new Right();
				right.setId(roleId);
				r.getRights().add(right);
			}
		}
		return r;
	}
}
