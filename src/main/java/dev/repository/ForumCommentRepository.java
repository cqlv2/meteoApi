package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.ForumComment;

public interface ForumCommentRepository extends JpaRepository<ForumComment, Long> {

}
