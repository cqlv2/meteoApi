package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.ForumSubject;

public interface ForumSubjectRepository extends JpaRepository<ForumSubject, Long>{

}
