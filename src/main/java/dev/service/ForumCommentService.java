package dev.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.dto.answer.AnswerDtoResponse;
import dev.dto.comment.CommentDtoQuery;
import dev.dto.comment.CommentDtoResponse;
import dev.entity.ForumComment;
import dev.exceptions.RepositoryException;
import dev.repository.ForumCommentRepository;

@Service
@Transactional

public class ForumCommentService extends SuperService<ForumComment, ForumCommentRepository, CommentDtoResponse, CommentDtoQuery>{

	public CommentDtoResponse editContain(Long id, String contain) throws RepositoryException {		
		if (repository.updateContain(id, contain) == 1)
			return this.getById(id);
		else
			throw new RepositoryException("erreur pendant la mise a jour");
	}
}
