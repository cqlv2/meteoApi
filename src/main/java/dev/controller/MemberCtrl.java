package dev.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.config.security.SecurityMethodsService;
import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Member;
import dev.exceptions.RepositoryException;
import dev.service.MemberService;

@RestController
@RequestMapping("api/members")
public class MemberCtrl extends SuperController<Member, MemberService, MemberDtoQuery, MemberDtoResponse> {

	@GetMapping("/me")
	public ResponseEntity<?> showConnectedUser(Principal principal) {
		try {
			return ResponseEntity.ok().body(service.readByEmail(principal.getName()));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@Override
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> edit(Long id, @Valid MemberDtoQuery dtoQuery, BindingResult resValue) {
		// TODO Auto-generated method stub
		return super.edit(id, dtoQuery, resValue);
	}

	@Override
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> remove(Long id) {
		// TODO Auto-generated method stub
		return super.remove(id);
	}
	
	

}
