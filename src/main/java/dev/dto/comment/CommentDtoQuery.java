package dev.dto.comment;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;

public class CommentDtoQuery extends SuperDto {

	private String contain;
	private Integer liked;
	private Long originId;
	private List<Long> commentsId = new ArrayList<>();
	private Long MemberId;

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
		return MemberId;
	}

	public void setMemberId(Long memberId) {
		MemberId = memberId;
	}
	
}
