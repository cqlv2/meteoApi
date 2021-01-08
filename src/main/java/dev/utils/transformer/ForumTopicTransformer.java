package dev.utils.transformer;

import dev.dto.topic.TopicDtoQuery;
import dev.dto.topic.TopicDtoResponse;
import dev.entity.ForumSubject;
import dev.entity.ForumTopic;
import dev.entity.Member;

public class ForumTopicTransformer {

	public static TopicDtoResponse entityToDtoResponse(ForumTopic entity) {
		return new TopicDtoResponse(entity);
	}

	public static ForumTopic dtoToEntity(TopicDtoQuery dtoQuery) {
		ForumTopic ft = new ForumTopic();
		ft.setId(dtoQuery.getId()!=null?dtoQuery.getId():null);
		ft.setLabel(dtoQuery.getLabel());
		
		if(dtoQuery.getMemberId()!=null) {
			Member m = new Member();
			m.setId(dtoQuery.getMemberId());
			ft.setMember(m);	
		}
		
		if(dtoQuery.getSubjectsId()!=null) {
			for (long subjectId : dtoQuery.getSubjectsId()) {
				ForumSubject fs=new ForumSubject();
				fs.setId(subjectId);
				ft.getSubjects().add(fs);
			}
		}
		
		return ft;
	}

}
