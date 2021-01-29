package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dev.entity.ForumComment;

public interface ForumCommentRepository extends JpaRepository<ForumComment, Long> {

	@Modifying
    @Query("UPDATE ForumComment c SET c.contain = :contain WHERE c.id = :id")
    int updateContain(Long id, String contain);
}

