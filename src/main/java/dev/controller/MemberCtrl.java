package dev.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.config.security.SecurityMethodsService;
import dev.dto.member.MemberDtoQuery;
import dev.entity.Member;
import dev.exceptions.repositoryException;
import dev.service.MemberService;

@RestController
@RequestMapping("api/members")
public class MemberCtrl extends SuperController<Member, MemberService> {


	@GetMapping("/me")
	public ResponseEntity<?> showConnectedUser(Principal principal) {
		try {
			return ResponseEntity.ok().body(service.readByEmail(principal.getName()));
		} catch (repositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	/**
	 * public
	 * 
	 * add a new entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PostMapping
	public ResponseEntity<?> add(@RequestBody MemberDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	/**
	 * edit an entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PutMapping
	public ResponseEntity<?> edit(@RequestBody MemberDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

}
