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
	private List<CommentDtoResponse> comments=new ArrayList<>();

	// constructeur
	public AnswerDtoResponse(ForumAnswer entity) {
		this.id = entity.getId();
		this.contain = entity.getContain();
		this.liked = entity.getLiked();
			for (ForumComment comment : entity.getComments()) {
				this.comments.add(ForumCommentTransformer.entityToDtoResponse(comment));
			}
		

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
