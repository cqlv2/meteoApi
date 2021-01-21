package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("COMMENT")
public class ForumComment extends ForumAbstractMessage {
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	// une réponse appartient à un ForumAbstractMessage
	@ManyToOne
	@JoinColumn(name = "origin")
	private ForumAbstractMessage origin;

	// une réponse peut avoir 0 a n réponse
	@OneToMany(targetEntity = ForumComment.class, mappedBy = "origin")
	private List<ForumComment> comments = new ArrayList<>();
	
	// GetteurSetteur

	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public ForumAbstractMessage getOrigin() {
		return origin;
	}

	public void setOrigin(ForumAbstractMessage origin) {
		this.origin = origin;
	}

	public List<ForumComment> getComments() {
		return comments;
	}

	public void setComments(List<ForumComment> comments) {
		this.comments = comments;
	}

}
