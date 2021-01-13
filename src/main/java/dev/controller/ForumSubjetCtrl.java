package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.subject.SubjectDtoQuery;
import dev.dto.subject.SubjectDtoResponse;
import dev.entity.ForumSubject;
import dev.service.ForumSubjectService;

@RestController
@RequestMapping("/forum/subject")
public class ForumSubjetCtrl extends SuperController<ForumSubject, ForumSubjectService,SubjectDtoQuery,SubjectDtoResponse> {

	/**
	 * add a new entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PreAuthorize("hasAuthority('CREATE_SUBJECT')")
	@PostMapping
	public ResponseEntity<?> add(@RequestBody SubjectDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	/**
	 * edit an entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
//	"hasAuthority('UPDATE_SUBJECT')"
//	@PreAuthorize("@securityMethodsService.isMySubject(#id)")

	@PreAuthorize(value = "hasAuthority('ROLE_ADMIN') or @securityMethodsService.isMySubject(#id)")

	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody SubjectDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	@Override
	@PreAuthorize("@securityMethodsService.isMySubject(#id)")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return super.remove(id);
	}

}
