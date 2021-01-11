package dev.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.role.RoleDtoQuery;
import dev.dto.role.RoleDtoResponse;
import dev.entity.Role;
import dev.enumeration.RoleEnum;
import dev.exceptions.repositoryException;
import dev.repository.RoleRepository;

@Service
public class RoleService extends SuperService<Role, RoleRepository, RoleDtoResponse, RoleDtoQuery>{

	
	public Long getId(RoleEnum role) throws repositoryException {
		Optional<Role> optRole = repository.findByLabel(role);
		if(optRole.isPresent()) {
			return optRole.get().getId();
		}else throw new repositoryException("no id found for "+role.name());
	}
}
