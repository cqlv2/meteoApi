package dev.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.dto.subject.SubjectDtoQuery;
import dev.dto.subject.SubjectDtoResponse;
import dev.entity.ForumSubject;
import dev.repository.ForumSubjectRepository;
@Service
@Transactional

public class ForumSubjectService extends SuperService<ForumSubject, ForumSubjectRepository, SubjectDtoResponse, SubjectDtoQuery>{

}
