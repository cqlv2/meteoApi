package dev.service;

import javax.transaction.Transactional;

import dev.exceptions.RepositoryException;
import org.springframework.stereotype.Service;

import dev.dto.topic.TopicDtoQuery;
import dev.dto.topic.TopicDtoResponse;
import dev.entity.ForumTopic;
import dev.repository.ForumTopicRepository;
@Service
@Transactional

public class ForumTopicService extends SuperService<ForumTopic, ForumTopicRepository, TopicDtoResponse, TopicDtoQuery> {
    public  Object editLabel(Long id, String label) throws RepositoryException {
        if (repository.updateLabel(id, label) == 1)
            return this.getById(id);
        else
            throw new RepositoryException("erreur pendant la mise a jour");
    };
}
