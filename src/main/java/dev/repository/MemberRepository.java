package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.entity.Member;
import dev.entity.Role;
import dev.enumeration.RoleEnum;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member> {

	Optional<Member> findByEmail(String email);
	Optional<Member> findByUserName(String username);
	Optional<Member> findById(Long id);
	
	@Query("select m from Member m where m.role.label = ?1")
	List<Member> isThereRole(RoleEnum role);
	
	@Modifying
	@Query("UPDATE Member m SET m.lastName = :lastName WHERE m.id = :idMember")
	int updateLastName(String lastName, Long idMember);
	
	@Modifying
	@Query("UPDATE Member m SET m.firstName = :firstName WHERE m.id = :idMember")
	int updateFirstName(String firstName, Long idMember);
	
	@Modifying
	@Query("UPDATE Member m SET m.userName = :userName WHERE m.id = :idMember")
	int updateUserName(String userName, Long idMember);
	
	@Modifying
	@Query("UPDATE Member m SET m.email = :email WHERE m.id = :idMember")
	int updateEmail(String email, Long idMember);
	
	@Modifying
	@Query("UPDATE Member m SET m.password = :encodedPass WHERE m.id = :idMember")
	int updatePassword(String encodedPass, Long idMember);

	@Modifying
	@Query("UPDATE Member m SET m.role = :role WHERE m.id = :idMember")
	int updateRole(Role role, Long idMember);
	
	
	
}
