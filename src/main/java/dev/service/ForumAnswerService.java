package dev.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import dev.dto.answer.AnswerDtoQuery;
import dev.dto.answer.AnswerDtoResponse;
import dev.dto.topic.TopicDtoResponse;
import dev.entity.ForumAnswer;
import dev.exceptions.RepositoryException;
import dev.repository.ForumAnswerRepository;

@Service
@Transactional

public class ForumAnswerService extends SuperService<ForumAnswer, ForumAnswerRepository, AnswerDtoResponse, AnswerDtoQuery>{

	public AnswerDtoResponse editContain(Long id, String contain) throws RepositoryException {
		if (repository.updateContain(id, contain) == 1)
			return this.getById(id);
		else
			throw new RepositoryException("erreur pendant la mise a jour");
	}
}
