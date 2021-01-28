package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class ForumSubject extends SuperEntity {

	private String label;

	@OneToMany(cascade = CascadeType.REMOVE,targetEntity = ForumAnswer.class, mappedBy = "subject")
	private List<ForumAnswer> answer = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "topic_id")
	private ForumTopic topic;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	// getteur/setteur

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<ForumAnswer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<ForumAnswer> answer) {
		this.answer = answer;
	}

	public ForumTopic getTopic() {
		return topic;
	}

	public void setTopic(ForumTopic topic) {
		this.topic = topic;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
