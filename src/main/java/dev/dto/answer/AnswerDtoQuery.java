package dev.dto.answer;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;

//exemple de json 
//	{
//		"id":null,
//		"contain":"bla bla bla",
//		"liked":0,
//		"subjectId":1,
//		"commentsId":null
//	}

public class AnswerDtoQuery extends SuperDto {

	private String contain;
	private Integer liked;
	private Long subjectId;
	private Long memberId;
	private List<Long> commentsId=new ArrayList<Long>();

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

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
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
		this.memberId = memberId;
	}

}
