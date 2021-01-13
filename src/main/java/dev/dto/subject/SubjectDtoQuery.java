package dev.dto.subject;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.dto.SuperDto;

public class SubjectDtoQuery extends SuperDto {
	
//	{
//        "label": "testSubject",
//        "topicId": 1,
//        "memberId": 1
//	}

	@NotNull
	@NotBlank
	private String label;
	private List<Long> answersId = new ArrayList<>();
	@NotNull
	private Long topicId;
	@NotNull
	private Long memberId;

	// getteurSetteur
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Long> getAnswersId() {
		return answersId;
	}

	public void setAnswersId(List<Long> answersId) {
		this.answersId = answersId;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	

}
