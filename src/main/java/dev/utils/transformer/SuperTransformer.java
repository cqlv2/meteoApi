package dev.utils.transformer;

import dev.dto.answer.AnswerDtoQuery;
import dev.dto.comment.CommentDtoQuery;
import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.member.MemberDtoQuery;
import dev.dto.subject.SubjectDtoQuery;
import dev.dto.topic.TopicDtoQuery;
import dev.entity.Favorite;
import dev.entity.ForumAnswer;
import dev.entity.ForumComment;
import dev.entity.ForumSubject;
import dev.entity.ForumTopic;
import dev.entity.Member;
import dev.entity.Right;
import dev.entity.Role;
import dev.entity.SuperEntity;

/**
 * referral tool for the use of the transformer corresponding to the entity's
 * class
 * 
 * @author cql-v2
 * @version 1.0
 */
public class SuperTransformer {

	/**
	 * 
	 * @param entity entity to be referred
	 * @return an entity transform into DTO response
	 */
	public static Object entityToDtoResponse(SuperEntity entity) {
		switch (entity.getClass().getSimpleName()) {
		
		case "Member":
			return MemberTransformer.entityToDtoResponse((Member) entity);
			
		case "Role":
			return RoleTransformer.entityToDtoResponse((Role) entity);

		case "Right":
			return RightTransformer.entityToDtoResponse((Right) entity);
		
		case "Favorite":
			return FavoriteTransformer.entityToDtoResponse((Favorite) entity);
		
		case "ForumAnswer":
			return ForumAnswerTransformer.entityToDtoResponse((ForumAnswer) entity);
			
		case "ForumComment":
			return ForumCommentTransformer.entityToDtoResponse((ForumComment) entity);
			
		case "ForumSubject":
			return ForumSubjectTransformer.entityToDtoResponse((ForumSubject) entity);
			
		case "ForumTopic":
			return ForumTopicTransformer.entityToDtoResponse((ForumTopic) entity);
			
			

		default:
			// TODO gérer une exception
			return null;
		}

	}

	public static Object dtoToEntity(Object dtoQuery) {
		switch (dtoQuery.getClass().getSimpleName()) {
		
		case "MemberDtoQuery":
			return MemberTransformer.dtoToEntity((MemberDtoQuery) dtoQuery);

		case "FavoriteDtoQuery":
			return FavoriteTransformer.dtoToEntity((FavoriteDtoQuery) dtoQuery);
			
		case "AnswerDtoQuery":
			return ForumAnswerTransformer.dtoToEntity((AnswerDtoQuery) dtoQuery);
			
		case "CommentDtoQuery":
			return ForumCommentTransformer.dtoToEntity((CommentDtoQuery) dtoQuery);
			
		case "SubjectDtoQuery":
			return ForumSubjectTransformer.dtoToEntity((SubjectDtoQuery) dtoQuery);
			
		case "TopicDtoQuery":
			return ForumTopicTransformer.dtoToEntity((TopicDtoQuery) dtoQuery);
			
			
			
			
			
			
			
			
			
			
		default:
			//TODO gérer une exception
			return null;
		}
	}

}
