package dev.utils.transformer;

import dev.dto.comment.CommentDtoQuery;
import dev.dto.comment.CommentDtoResponse;
import dev.entity.ForumAbstractMessage;
import dev.entity.ForumComment;
import dev.entity.Member;

public class ForumCommentTransformer {

	
	
	public static CommentDtoResponse entityToDtoResponse(ForumComment entity) {
		return new CommentDtoResponse(entity);
	}
	
	public static ForumComment dtoToEntity(CommentDtoQuery dtoQuery) {
		ForumComment fc = new ForumComment();
		fc.setId(dtoQuery.getId()!=null?dtoQuery.getId():null);
		fc.setDateAdd(dtoQuery.getDateAdd());
		fc.setContain(dtoQuery.getContain());
		fc.setLiked(dtoQuery.getLiked());
		//ajout du membre
		if(dtoQuery.getMemberId()!=null) {
			Member m = new Member();
			m.setId(dtoQuery.getMemberId());
			fc.setMember(m);	
		}
		//ajout du message d'origine
		if(dtoQuery.getOriginId()!=null) {
			ForumAbstractMessage fam=new ForumAbstractMessage();
			fam.setId(dtoQuery.getOriginId());
			fc.setOrigin(fam);
		}
		//ajout des commentaires
		if(dtoQuery.getCommentsId()!=null) {
			for (Long commentId : dtoQuery.getCommentsId()) {
				ForumComment fcc=new ForumComment();
				fcc.setId(commentId);
				fc.getComments().add(fcc);
			}
		}
		
		return fc;
	}
	
	

	
	
	
}
