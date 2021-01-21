package dev.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Member;
import dev.entity.Role;
import dev.enumeration.RoleEnum;
import dev.exceptions.EmailException;
import dev.exceptions.RepositoryException;
import dev.exceptions.enumException;
import dev.repository.MemberRepository;
import dev.utils.encoder.BcryptEncoder;
import dev.utils.transformer.MemberTransformer;

@Service
@Transactional
public class MemberService extends SuperService<Member, MemberRepository, MemberDtoResponse, MemberDtoQuery> {

	@Autowired
	private RoleService roleServ;

	/**
	 * checked if an admin is present in the database and created it if necessary
	 * 
	 * @throws RepositoryException
	 */
	public void checkAdmin() throws RepositoryException {
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

	/**
	 * find a member from email
	 * 
	 * @param email
	 * @return
	 * @throws RepositoryException
	 */
	public MemberDtoResponse readByEmail(String email) throws RepositoryException {
		Optional<Member> opt = repository.findByEmail(email);
		if (opt.isPresent()) {
			return MemberTransformer.entityToDtoResponse(opt.get());
		} else {
			throw new RepositoryException("email non trouvé");
		}
	}

	/**
	 * update the lastName of a member
	 * 
	 * @param lastName
	 * @param idMember
	 * @return
	 * @throws RepositoryException
	 */
	public MemberDtoResponse updateLastName(String lastName, Long idMember) throws RepositoryException {

		if (repository.updateLastName(lastName, idMember) == 1)
			return this.getById(idMember);
		else
			throw new RepositoryException("erreur pendent la mise a jour");
	}

	/**
	 * update the firstName of a member
	 * 
	 * @param firstName
	 * @param idMember
	 * @return
	 * @throws RepositoryException
	 */
	public MemberDtoResponse updateFirstName(String firstName, Long idMember) throws RepositoryException {
		if (repository.updateFirstName(firstName, idMember) == 1)
			return this.getById(idMember);
		else
			throw new RepositoryException("erreur pendent la mise a jour");
	}

	/**
	 * check if username allready exist and update the username of a member
	 * 
	 * @param firstName
	 * @param idMember
	 * @return
	 * @throws RepositoryException
	 */
	public MemberDtoResponse updateUserName(String userName, Long idMember) throws RepositoryException {
		if (!repository.findByUserName(userName).isPresent()) {
			if (repository.updateUserName(userName, idMember) == 1)
				return this.getById(idMember);
			else
				throw new RepositoryException("erreur pendent la mise a jour");
		} else
			throw new RepositoryException("username : " + userName + " already exist");
	}

	/**
	 * check if email allready exist, corresponding to reggex and update the email
	 * of a member
	 * 
	 * @param firstName
	 * @param idMember
	 * @return
	 * @throws RepositoryException
	 * @throws EmailException
	 */
	public MemberDtoResponse updateUserEmail(String email, Long idMember) throws RepositoryException, EmailException {
		EmailValidator emailvalidator = EmailValidator.getInstance();
		if (emailvalidator.isValid(email)) {
			if (!repository.findByEmail(email).isPresent()) {
				if (repository.updateEmail(email, idMember) == 1)
					return this.getById(idMember);
				else
					throw new RepositoryException("erreur pendent la mise a jour");
			} else
				throw new RepositoryException("email : " + email + " already exist");
		} else
			throw new EmailException("invalid email format");

	}

	/**
	 * update the password of a member
	 * 
	 * @param firstName
	 * @param idMember
	 * @return
	 * @throws RepositoryException
	 */
	public MemberDtoResponse updateUserPasssword(String password, Long idMember) throws RepositoryException {
		String cryptPass = BcryptEncoder.encode(password);
		if (repository.updatePassword(cryptPass, idMember) == 1)
			return this.getById(idMember);
		else
			throw new RepositoryException("erreur pendent la mise a jour");
	}

	/**
	 * update the role of a member
	 * 
	 * @param firstName
	 * @param idMember
	 * @return
	 * @throws RepositoryException
	 * @throws enumException 
	 */
	public MemberDtoResponse updateUserRole(String role, Long idMember) throws RepositoryException, enumException {
		try {
			RoleEnum newRole = RoleEnum.valueOf(role.toUpperCase());
			Role r=new Role();
			r.setId(roleServ.getId(newRole));
			if (repository.updateRole(r, idMember) == 1)
				return this.getById(idMember);
			else
				throw new RepositoryException("erreur pendent la mise a jour");
		} catch (Exception e) {
			throw new enumException("not an ennum");
		}
		
		
		
		
		
		
		
		

		
	}

}
