package dev.dto.topic;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.dto.SuperDto;

public class TopicDtoQuery extends SuperDto{
	
//	{
//        "label": "test",
//        "memberId": 1
//	}

	@NotNull
	@NotBlank
	private String label;
	private List<Long> subjectsId = new ArrayList<>();
	@NotNull
	private Long memberId;
	//getteurSetteur
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<Long> getSubjectsId() {
		return subjectsId;
	}
	public void setSubjectsId(List<Long> subjectsId) {
		this.subjectsId = subjectsId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "TopicDtoQuery [label=" + label + ", subjectsId=" + subjectsId + ", memberId=" + memberId + "]";
	}
	
	
	
	
	
}
