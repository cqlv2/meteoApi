package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Member extends SuperEntity {

	private String lastName;
	private String firstName;
	private String userName;
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn(name = "idRole")
	private Role role;
	@OneToMany(targetEntity = Favorite.class, mappedBy = "member")
	private List<Favorite> favorites = new ArrayList<>();
	@OneToMany(targetEntity = ForumTopic.class, mappedBy = "member")
	private List<ForumTopic> topics = new ArrayList<>();
//	@OneToMany(targetEntity = ForumSubject.class, mappedBy = "member")
//	private List<ForumSubject> subjects = new ArrayList<>();
//	@OneToMany(targetEntity = ForumAnswer.class, mappedBy = "member")
//	private List<ForumAnswer> answers = new ArrayList<>();
//	@OneToMany(targetEntity = ForumComment.class, mappedBy = "member")
//	private List<ForumComment> comments = new ArrayList<>();

//	getteurSetteur
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<ForumTopic> getTopics() {
		return topics;
	}

	public void setTopics(List<ForumTopic> topics) {
		this.topics = topics;
	}

//	public List<ForumSubject> getSubjects() {
//		return subjects;
//	}
//
//	public void setSubjects(List<ForumSubject> subjects) {
//		this.subjects = subjects;
//	}
//
//	public List<ForumAnswer> getAnswers() {
//		return answers;
//	}
//
//	public void setAnswers(List<ForumAnswer> answers) {
//		this.answers = answers;
//	}
//
//	public List<ForumComment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<ForumComment> comments) {
//		this.comments = comments;
//	}

}
