package dev.dto.member;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import dev.dto.SuperDto;

//	*JSON*
//	{
//    "lastName": "userLastName",
//    "firstName": "userFirstName",
//    "userName": "userUserName",
//    "password": "userPassword",
//    "email": "userEmail",
//    "roleId" : 1
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
	@NotNull
	@NotEmpty
	private String lastName;
	@NotNull
	@NotEmpty
	private String firstName;
	@NotNull
	@NotEmpty
	private String userName;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String password;
	@NotNull
	private Long roleId;

	private List<Long> favoritesId = new ArrayList<>();
	private List<Long> topics = new ArrayList<>();
	private List<Long> subjects = new ArrayList<>();
	private List<Long> answers = new ArrayList<>();
	private List<Long> comments = new ArrayList<>();

	// getteurSetteur
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public List<Long> getFavoritesId() {
		return favoritesId;
	}

	public void setFavoritesId(List<Long> favotiresId) {
		this.favoritesId = favotiresId;
	}

	public List<Long> getTopics() {
		return topics;
	}

	public void setTopics(List<Long> topics) {
		this.topics = topics;
	}

	public List<Long> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Long> subjects) {
		this.subjects = subjects;
	}

	public List<Long> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Long> answers) {
		this.answers = answers;
	}

	public List<Long> getComments() {
		return comments;
	}

	public void setComments(List<Long> comments) {
		this.comments = comments;
	}

}
