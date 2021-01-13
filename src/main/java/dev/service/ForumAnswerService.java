package dev.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import dev.dto.answer.AnswerDtoQuery;
import dev.dto.answer.AnswerDtoResponse;
import dev.entity.ForumAnswer;
import dev.repository.ForumAnswerRepository;

@Service
@Transactional

public class ForumAnswerService extends SuperService<ForumAnswer, ForumAnswerRepository, AnswerDtoResponse, AnswerDtoQuery>{

}
