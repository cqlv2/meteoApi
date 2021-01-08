package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.ForumAnswer;

public interface ForumAnswerRepository extends JpaRepository<ForumAnswer, Long>{

}
