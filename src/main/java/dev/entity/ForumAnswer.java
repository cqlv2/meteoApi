package dev.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("ANSWER")
public class ForumAnswer extends ForumAbstractMessage {

	// une reponse appartient à un sujet
	@ManyToOne
	@JoinColumn(name = "Subject_id")
	private ForumSubject subject;

	// une reponse peut avoir de o a n commentaires
	@OneToMany(targetEntity = ForumComment.class, mappedBy = "origin")
	private List<ForumComment> comments=new ArrayList<>();
	// getteurSetteur

	public ForumSubject getSubject() {
		return subject;
	}

	public void setSubject(ForumSubject subject) {
		this.subject = subject;
	}

	public List<ForumComment> getComments() {
		return comments;
	}

	public void setComments(List<ForumComment> comments) {
		this.comments = comments;
	}

}
