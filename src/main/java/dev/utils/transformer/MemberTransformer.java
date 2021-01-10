package dev.utils.transformer;

import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Favorite;
import dev.entity.ForumAnswer;
import dev.entity.ForumComment;
import dev.entity.ForumSubject;
import dev.entity.ForumTopic;
import dev.entity.Member;
import dev.entity.Role;
import dev.utils.encoder.BcryptEncoder;

public class MemberTransformer {

	public static MemberDtoResponse entityToDtoResponse(Member entity) {
		MemberDtoResponse memberDto = new MemberDtoResponse(entity);
		return memberDto;
	}

	public static Member dtoToEntity(MemberDtoQuery dtoRequest) {
		Member m = new Member();

		m.setId(dtoRequest.getId() != null ? dtoRequest.getId() : null);
		m.setDateAdd(dtoRequest.getDateAdd());
		m.setFirstName(dtoRequest.getFirstName());
		m.setLastName(dtoRequest.getLastName());
		m.setUserName(dtoRequest.getUserName());
		m.setEmail(dtoRequest.getEmail());
		// encodage du password
		m.setPassword(BcryptEncoder.encode(dtoRequest.getPassword()));
		// ajour d'une instense de role
		Role r = new Role();
		r.setId(dtoRequest.getRoleId());
		m.setRole(r);
		// ajout des favories
		for (Long favId : dtoRequest.getFavotiresId()) {
			Favorite f = new Favorite();
			f.setId(favId);
			m.getFavotires().add(f);
		}
		// ajout des topics
		for (Long topId : dtoRequest.getTopics()) {
			ForumTopic ft = new ForumTopic();
			ft.setId(topId);
			m.getTopics().add(ft);
		}
		// ajout des Subject
		for (Long subId : dtoRequest.getSubjects()) {
			ForumSubject fs = new ForumSubject();
			fs.setId(subId);
			m.getSubjects().add(fs);
		}
		// ajout des Answers
		for (Long ansId : dtoRequest.getAnswers()) {
			ForumAnswer fa = new ForumAnswer();
			fa.setId(ansId);
			m.getAnswers().add(fa);
		}
		// ajout des Comments
		for (Long comId : dtoRequest.getComments()) {
			ForumComment fc = new ForumComment();
			fc.setId(comId);
			m.getComments().add(fc);
		}
		return m;
	}

}
