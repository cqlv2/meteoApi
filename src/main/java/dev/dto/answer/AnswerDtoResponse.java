package dev.dto.answer;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;
import dev.dto.comment.CommentDtoResponse;
import dev.entity.ForumAnswer;
import dev.entity.ForumComment;
import dev.utils.transformer.ForumCommentTransformer;

public class AnswerDtoResponse extends SuperDto {

	private String contain;
	private Integer liked;
	private List<CommentDtoResponse> comments = new ArrayList<>();
	private String memberLastName;
	private String memberFirstName;
	private Long memberId;

	// constructeur
	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public AnswerDtoResponse(ForumAnswer entity) {
		this.id = entity.getId();
		this.contain = entity.getContain();
		this.liked = entity.getLiked();
		for (ForumComment comment : entity.getComments()) {
			this.comments.add(ForumCommentTransformer.entityToDtoResponse(comment));
		}
		this.memberLastName = entity.getMember().getLastName();
		this.memberFirstName = entity.getMember().getFirstName();
		this.memberId = entity.getMember().getId();

	}
	// getteur/Setteur

	public String getContain() {
		return contain;
	}

	public void setContain(String contain) {
		this.contain = contain;
	}

	public Integer getLiked() {
		return liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
	}

	public List<CommentDtoResponse> getComments() {
		return comments;
	}

	public void setComments(List<CommentDtoResponse> comments) {
		this.comments = comments;
	}

}
