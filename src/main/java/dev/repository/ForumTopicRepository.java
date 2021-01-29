package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.ForumTopic;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ForumTopicRepository extends JpaRepository<ForumTopic, Long> {

    @Modifying
    @Query("UPDATE ForumTopic t SET t.label = :label WHERE t.id = :id")
    int updateLabel(Long id, String label);
}
