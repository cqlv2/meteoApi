package dev.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.dto.topic.TopicDtoQuery;
import dev.dto.topic.TopicDtoResponse;
import dev.entity.ForumTopic;
import dev.repository.ForumTopicRepository;
@Service
@Transactional

public class ForumTopicService extends SuperService<ForumTopic, ForumTopicRepository, TopicDtoResponse, TopicDtoQuery> {

}
