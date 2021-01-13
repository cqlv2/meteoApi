package dev.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.dto.role.RoleDtoQuery;
import dev.dto.role.RoleDtoResponse;
import dev.entity.Role;
import dev.enumeration.RoleEnum;
import dev.exceptions.RepositoryException;
import dev.repository.RoleRepository;

@Service
@Transactional
public class RoleService extends SuperService<Role, RoleRepository, RoleDtoResponse, RoleDtoQuery>{

	
	public Long getId(RoleEnum role) throws RepositoryException {
		Optional<Role> optRole = repository.findByLabel(role);
		if(optRole.isPresent()) {
			return optRole.get().getId();
		}else throw new RepositoryException("no id found for "+role.name());
	}
}
