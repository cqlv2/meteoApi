package dev.dto.topic;

import java.util.ArrayList;
import java.util.List;

import dev.dto.SuperDto;
import dev.dto.subject.SubjectDtoResponse;
import dev.entity.ForumSubject;
import dev.entity.ForumTopic;
import dev.utils.transformer.ForumSubjectTransformer;

public class TopicDtoResponse extends SuperDto{

	private String label;
	private List<SubjectDtoResponse> subjects=new ArrayList<>();
	private String memberLastName;
	private String memberFirstName;
	private Long memberId;
	
	
	
	
	//constructeur
	public TopicDtoResponse(ForumTopic entity) {
		this.id = entity.getId();
		this.dateAdd = entity.getDateAdd();
		this.label = entity.getLabel();
		for (ForumSubject fs : entity.getSubjects()) {
		this.subjects.add(ForumSubjectTransformer.entityToDtoResponse(fs));	
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
	public List<SubjectDtoResponse> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectDtoResponse> subjects) {
		this.subjects = subjects;
	}
	
	
}
