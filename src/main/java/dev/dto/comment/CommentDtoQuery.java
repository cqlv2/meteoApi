package dev.dto.comment;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.dto.SuperDto;

public class CommentDtoQuery extends SuperDto {

	@NotNull
	@NotBlank
	private String contain;
	private Integer liked = 0;
	@NotNull
	private Long originId;
	private List<Long> commentsId = new ArrayList<>();
	@NotNull
	private Long memberId;

	// getteurSetteur
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

	public Long getOriginId() {
		return originId;
	}

	public void setOriginId(Long originId) {
		this.originId = originId;
	}

	public List<Long> getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(List<Long> commentsId) {
		this.commentsId = commentsId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		memberId = memberId;
	}
	
}
