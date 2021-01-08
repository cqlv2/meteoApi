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
	//constructeur
	public TopicDtoResponse(ForumTopic entity) {
		this.id = entity.getId();
		this.label = entity.getLabel();
		for (ForumSubject fs : entity.getSubjects()) {
		this.subjects.add(ForumSubjectTransformer.entityToDtoResponse(fs));	
		}
	}
	//getteurSetteur
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
