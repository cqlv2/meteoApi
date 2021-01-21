package dev.dto.member;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;
import dev.dto.answer.AnswerDtoResponse;
import dev.dto.comment.CommentDtoResponse;
import dev.dto.favorite.FavoriteDtoResponse;
import dev.dto.role.RoleDtoResponse;
import dev.dto.subject.SubjectDtoResponse;
import dev.dto.topic.TopicDtoResponse;
import dev.entity.Favorite;
import dev.entity.ForumAnswer;
import dev.entity.ForumComment;
import dev.entity.ForumSubject;
import dev.entity.ForumTopic;
import dev.entity.Member;
import dev.utils.transformer.FavoriteTransformer;
import dev.utils.transformer.ForumAnswerTransformer;
import dev.utils.transformer.ForumCommentTransformer;
import dev.utils.transformer.ForumSubjectTransformer;
import dev.utils.transformer.ForumTopicTransformer;
import dev.utils.transformer.RoleTransformer;

/**
 * data transfer object between the persistence layer and the service layer.
 * Ignore the product list to avoid redundancies
 * 
 * @author cql-v2
 * @version 1.0
 */
public class MemberDtoResponse extends SuperDto {

	private String lastName;
	private String firstName;
	private String userName;
	private String email;
	private RoleDtoResponse role;
	private List<FavoriteDtoResponse> favorites = new ArrayList<>();
	private List<TopicDtoResponse> topics = new ArrayList<>();
	private List<SubjectDtoResponse> subjects = new ArrayList<>();

	// Constructor
	public MemberDtoResponse(Member entity) {

		this.id = entity.getId();
		this.dateAdd = entity.getDateAdd();
		this.lastName = entity.getLastName();
		this.firstName = entity.getFirstName();
		this.userName = entity.getUserName();
		this.email = entity.getEmail();
		this.role = RoleTransformer.entityToDtoResponse(entity.getRole());

		for (Favorite f : entity.getFavorites()) {
			this.favorites.add(FavoriteTransformer.entityToDtoResponse(f));
		}
		for (ForumTopic t : entity.getTopics()) {
			this.topics.add(ForumTopicTransformer.entityToDtoResponse(t));
		}
		for (ForumSubject s : entity.getSubjects()) {
			this.subjects.add(ForumSubjectTransformer.entityToDtoResponse(s));
		}

	}
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

	public RoleDtoResponse getRole() {
		return role;
	}

	public void setRole(RoleDtoResponse role) {
		this.role = role;
	}

	public List<FavoriteDtoResponse> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<FavoriteDtoResponse> favorites) {
		this.favorites = favorites;
	}

	public List<TopicDtoResponse> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicDtoResponse> topics) {
		this.topics = topics;
	}

	public List<SubjectDtoResponse> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectDtoResponse> subjects) {
		this.subjects = subjects;
	}

}
