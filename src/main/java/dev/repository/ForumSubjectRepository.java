package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dev.entity.ForumSubject;

public interface ForumSubjectRepository extends JpaRepository<ForumSubject, Long>{

	@Modifying
    @Query("UPDATE ForumSubject s SET s.label = :label WHERE s.id = :id")
	int updateLabel(Long id, String label);

}
