package dev.utils.transformer;


import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Member;
import dev.entity.Role;

public class MemberTransformer {

	public static MemberDtoResponse entityToDtoResponse(Member entity) {
		MemberDtoResponse memberDto = new MemberDtoResponse(entity);
		return memberDto;
	}

	public static Member dtoToEntity(MemberDtoQuery dtoRequete) {
		Member m=new Member();
		m.setId(dtoRequete.getId()!=null?dtoRequete.getId():null);
		m.setDateAdd(dtoRequete.getDateAdd());
		m.setEmail(dtoRequete.getEmail());
		m.setPassword(dtoRequete.getPassword());
		m.setUsername(dtoRequete.getUsername());
		
		//ajout du role
		Role r=new Role();
		r.setId(dtoRequete.getRoleId()!=null?dtoRequete.getRoleId():1);
		m.setRole(r);
		return m;
	}

}

