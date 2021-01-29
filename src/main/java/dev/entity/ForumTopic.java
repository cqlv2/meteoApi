package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class ForumTopic extends SuperEntity {

	private String label;

	@OneToMany(cascade = CascadeType.REMOVE, targetEntity = ForumSubject.class, mappedBy = "topic")
	private List<ForumSubject> subjects = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Member member;
	// getteur/setteur

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<ForumSubject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<ForumSubject> subjects) {
		this.subjects = subjects;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
