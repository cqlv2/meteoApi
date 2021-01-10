package dev.utils.transformer;

import dev.dto.subject.SubjectDtoQuery;
import dev.dto.subject.SubjectDtoResponse;
import dev.entity.ForumAnswer;
import dev.entity.ForumSubject;
import dev.entity.ForumTopic;
import dev.entity.Member;

public class ForumSubjectTransformer {

	public static SubjectDtoResponse entityToDtoResponse(ForumSubject entity) {
		return new SubjectDtoResponse(entity);
	}

	public static ForumSubject dtoToEntity(SubjectDtoQuery dtoQuery) {
		ForumSubject fs = new ForumSubject();
		fs.setId(dtoQuery.getId() != null ? dtoQuery.getId() : null);
		fs.setDateAdd(dtoQuery.getDateAdd());
		fs.setLabel(dtoQuery.getLabel());

		if (dtoQuery.getMemberId() != null) {
			Member m = new Member();
			m.setId(dtoQuery.getMemberId());
			fs.setMember(m);
		}

		if (dtoQuery.getTopicId() != null) {
			ForumTopic ft = new ForumTopic();
			ft.setId(dtoQuery.getTopicId());
			fs.setTopic(ft);
		}

		if (dtoQuery.getAnswersId() != null) {
			for (Long answerId : dtoQuery.getAnswersId()) {
				ForumAnswer fa = new ForumAnswer();
				fa.setId(answerId);
				fs.getAnswer().add(fa);
			}
		}
		return fs;
	}

}
