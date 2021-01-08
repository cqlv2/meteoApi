package dev.service;

import org.springframework.stereotype.Service;

import dev.dto.comment.CommentDtoQuery;
import dev.dto.comment.CommentDtoResponse;
import dev.entity.ForumComment;
import dev.repository.ForumCommentRepository;

@Service
public class ForumCommentService extends SuperService<ForumComment, ForumCommentRepository, CommentDtoResponse, CommentDtoQuery>{

}
