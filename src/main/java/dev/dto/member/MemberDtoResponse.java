package dev.dto.member;

import dev.dto.SuperDto;
import dev.dto.role.RoleDtoResponse;
import dev.entity.Member;
import dev.entity.Role;
import dev.utils.transformer.SuperTransformer;

/**
 * data transfer object between the persistence layer and the service layer.
 * Ignore the product list to avoid redundancies
 * 
 * @author cql-v2
 * @version 1.0
 */
public class MemberDtoResponse extends SuperDto {

	private String username;
	private String email;

	private RoleDtoResponse role;

	// constructeurs

	public MemberDtoResponse() {

	}

	public MemberDtoResponse(Member entity) {
		this.id = entity.getId();
		this.username = entity.getUsername();
		this.email = entity.getEmail();
		this.role = (RoleDtoResponse) SuperTransformer.entityToDtoResponse(entity.getRole());

	}

	// getteur setteur

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleDtoResponse getRoleId() {
		return role;
	}

	public void setRoleId(RoleDtoResponse role) {
		this.role = role;
	}

}
