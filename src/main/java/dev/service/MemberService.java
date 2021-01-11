package dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Member;
import dev.enumeration.RoleEnum;
import dev.exceptions.repositoryException;
import dev.repository.MemberRepository;
import dev.utils.transformer.MemberTransformer;

@Service
public class MemberService extends SuperService<Member, MemberRepository, MemberDtoResponse, MemberDtoQuery> {

	@Autowired
	private RoleService roleServ;

	/**
	 * checked if an admin is present in the database and created it if necessary
	 * 
	 * @throws repositoryException
	 */
	public void checkAdmin() throws repositoryException {
		List<Member> admins = repository.isThereRole(RoleEnum.ADMIN);
		if (admins.size() == 0) {
			System.out.println("no admin find... creating admin...");
			MemberDtoQuery m = new MemberDtoQuery();
			m.setLastName("automatic");
			m.setFirstName("create");
			m.setUserName("Admin");
			m.setEmail("admin");
			m.setPassword("admin");
			m.setRoleId(roleServ.getId(RoleEnum.ADMIN));
			this.addUpdate(m);
			System.out.println("...done !  new admin create");
			System.out.println("username : admin - password : admin");
		}

		
	}

	public MemberDtoResponse readByEmail(String email) throws repositoryException {
		Optional<Member> opt = repository.findByEmail(email);
		if(opt.isPresent()) {
			return MemberTransformer.entityToDtoResponse(opt.get());
		}else {
			throw new repositoryException("email non trouvé");
		}
	}

}
