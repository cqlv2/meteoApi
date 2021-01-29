package dev.dto.subject;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;
import dev.dto.answer.AnswerDtoResponse;
import dev.entity.ForumAnswer;
import dev.entity.ForumSubject;
import dev.utils.transformer.ForumAnswerTransformer;

public class SubjectDtoResponse extends SuperDto {
	
	private String label;
	private List<AnswerDtoResponse> answers=new ArrayList<AnswerDtoResponse>();
	private String memberLastName;
	private String memberFirstName;
	private Long memberId;
	//constructeur
	public SubjectDtoResponse(ForumSubject entity) {
		this.id= entity.getId();
		this.dateAdd = entity.getDateAdd();
		this.label = entity.getLabel();
		for (ForumAnswer  fa : entity.getAnswer()) {
			this.answers .add(ForumAnswerTransformer.entityToDtoResponse(fa));
		}
		this.memberLastName = entity.getMember().getLastName();
		this.memberFirstName= entity.getMember().getFirstName();
		this.memberId= entity.getMember().getId();
		
	}
	//getteurSetteur
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

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<AnswerDtoResponse> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerDtoResponse> answers) {
		this.answers = answers;
	}
	
	
	
	
	
}
