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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.config.security.SecurityMethodsService;
import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Member;
import dev.exceptions.EmailException;
import dev.exceptions.RepositoryException;
import dev.exceptions.enumException;
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
	public ResponseEntity<?> findById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> edit(@PathVariable Long id, @Valid MemberDtoQuery dtoQuery, BindingResult resValue) {
		// TODO Auto-generated method stub
		return super.edit(id, dtoQuery, resValue);
	}

	
	/**
	 * only update the lastName of a member
	 * @param id
	 * @param value
	 * @return
	 */
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	@PutMapping("/{id}/lastname")
	public ResponseEntity<?> updateLastName(@PathVariable Long id, @RequestParam String value) {

		try {
			return ResponseEntity.ok().body(service.updateLastName(value, id));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	@PutMapping("/{id}/firstname")
	public ResponseEntity<?> updateFirstName(@PathVariable Long id, @RequestParam String value) {

		try {
			return ResponseEntity.ok().body(service.updateFirstName(value, id));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	@PutMapping("/{id}/username")
	public ResponseEntity<?> updateUserName(@PathVariable Long id, @RequestParam String value) {
		try {
			return ResponseEntity.ok().body(service.updateUserName(value, id));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	@PutMapping("/{id}/email")
	public ResponseEntity<?> updateUserEmail(@PathVariable Long id, @RequestParam String value) {
		
			try {
				return ResponseEntity.ok().body(service.updateUserEmail(value, id));
			} catch (RepositoryException | EmailException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}	
	}
	
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	@PutMapping("/{id}/password")
	public ResponseEntity<?> updateUserpassword(@PathVariable Long id, @RequestParam String value) {
		try {
			return ResponseEntity.ok().body(service.updateUserPasssword(value, id));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/{id}/role")
	public ResponseEntity<?> updateUserRole(@PathVariable Long id, @RequestParam String value) {
		try {
			return ResponseEntity.ok().body(service.updateUserRole(value, id));
		} catch (RepositoryException | enumException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
	
	@Override
	@PreAuthorize("@securityMethodsService.isItMe(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> remove(Long id) {
		// TODO Auto-generated method stub
		return super.remove(id);
		
	}

}
