package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.ForumTopic;

public interface ForumTopicRepository extends JpaRepository<ForumTopic, Long> {

}
