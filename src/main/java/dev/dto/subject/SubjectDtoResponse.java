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
	//constructeur
	public SubjectDtoResponse(ForumSubject entity) {
		this.id= entity.getId();
		this.label = entity.getLabel();
		for (ForumAnswer  fa : entity.getAnswer()) {
			this.answers .add(ForumAnswerTransformer.entityToDtoResponse(fa));
		}
	}
	//getteurSetteur
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
