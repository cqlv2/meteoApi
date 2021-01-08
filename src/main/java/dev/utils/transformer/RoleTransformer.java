package dev.utils.transformer;

import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.dto.role.RoleDtoQuery;
import dev.dto.role.RoleDtoResponse;
import dev.entity.Member;
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
		for (Long id : dtoRequete.getRightsId()) {
			Right ri = new Right();
			ri.setId(id);
			r.getRights().add(ri);
		}

		return r;
	}
}
