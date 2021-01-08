package dev.utils.transformer;

import dev.dto.answer.AnswerDtoQuery;
import dev.dto.answer.AnswerDtoResponse;
import dev.entity.ForumAnswer;
import dev.entity.ForumComment;
import dev.entity.ForumSubject;
import dev.entity.Member;

public class ForumAnswerTransformer {

	public static AnswerDtoResponse entityToDtoResponse(ForumAnswer entity) {
		return new AnswerDtoResponse(entity);
	}

	public static ForumAnswer dtoToEntity(AnswerDtoQuery dtoQuery) {
		ForumAnswer fa = new ForumAnswer();

		fa.setId(dtoQuery.getId() != null ? dtoQuery.getId() : null);
		fa.setContain(dtoQuery.getContain());
		fa.setLiked(dtoQuery.getLiked());

		if (dtoQuery.getMemberId() != null) {
			Member m = new Member();
			m.setId(dtoQuery.getMemberId());
			fa.setMember(m);
		}

		if (dtoQuery.getSubjectId() != null) {
			ForumSubject fs = new ForumSubject();
			fs.setId(dtoQuery.getSubjectId());
			fa.setSubject(fs);

		}

		if (dtoQuery.getCommentsId() != null) {
			for (Long commentId : dtoQuery.getCommentsId()) {
				ForumComment fc = new ForumComment();
				fc.setId(commentId);
				fa.getComments().add(fc);
			}

		}
		return fa;

	}
}
