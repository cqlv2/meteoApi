package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dev.entity.ForumAnswer;

public interface ForumAnswerRepository extends JpaRepository<ForumAnswer, Long>{

	@Modifying
    @Query("UPDATE ForumAnswer a SET a.contain = :contain WHERE a.id = :id")
    int updateContain(Long id, String contain);
}
