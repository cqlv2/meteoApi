package dev.dto.member;

import dev.dto.SuperDto;

//*JSON*
//	{
//		"id":1,
//		"username":"userName",
//		"email":"emaill@mail.com",
//		"password":"aze123qsd456",
//		"role": 1
//	}

/**
 * data transfer object between the service layer and the persistence layer.
 * adds a layer of security by validating values with
 * "javax.validation.constraints"
 * 
 * @author cql-v2
 * @version 0.1
 *
 */
public class MemberDtoQuery extends SuperDto {

	private String username;
	private String email;
	private String password;

	private Long roleId;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
