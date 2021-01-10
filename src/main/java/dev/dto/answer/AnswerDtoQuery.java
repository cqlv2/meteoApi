package dev.dto.answer;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import dev.dto.SuperDto;

//exemple de json 
//	{
//		"id":null,							: null to create / number to update
//		"dataAdd":"2021-01-10 08:34:00"		:format iso null for now 
//		"contain":"bla bla bla",			:string
//		"liked":0,							:0 or null
//		"subjectId":1,						:forumSubject id
//		"commentsId":null					:array of forumComments id
//	}

public class AnswerDtoQuery extends SuperDto {

	@NotNull
	@NotEmpty
	private String contain;
	private Integer liked = 0;
	@NotNull
	private Long subjectId;
	@NotNull
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
