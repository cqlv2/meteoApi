package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.entity.Member;
import dev.enumeration.RoleEnum;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

	Optional<Member> findByEmail(String email);
	Optional<Member> findByUserName(String username);
	Optional<Member> findById(Long id);
	
	@Query("select m from Member m where m.role.label = ?1")
	List<Member> isThereRole(RoleEnum role);
	
	
	
}
