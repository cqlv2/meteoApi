package dev.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.dto.subject.SubjectDtoQuery;
import dev.dto.subject.SubjectDtoResponse;
import dev.entity.ForumSubject;
import dev.exceptions.RepositoryException;
import dev.repository.ForumSubjectRepository;
@Service
@Transactional

public class ForumSubjectService extends SuperService<ForumSubject, ForumSubjectRepository, SubjectDtoResponse, SubjectDtoQuery>{

	public SubjectDtoResponse editLabel(Long id, String label) throws RepositoryException {
		if (repository.updateLabel(id, label) == 1)
			return this.getById(id);
		else
			throw new RepositoryException("erreur pendant la mise a jour");
	}

}
