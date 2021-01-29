package dev.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.subject.SubjectDtoQuery;
import dev.dto.subject.SubjectDtoResponse;
import dev.entity.ForumSubject;
import dev.exceptions.RepositoryException;
import dev.service.ForumSubjectService;

@RestController
@RequestMapping("/forum/subject")
public class ForumSubjetCtrl extends SuperController<ForumSubject, ForumSubjectService,SubjectDtoQuery,SubjectDtoResponse> {


	@Override
	@PreAuthorize("@securityMethodsService.isMySubject(#id)")
	public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody SubjectDtoQuery dtoQuery, BindingResult resValue) {
		return super.edit(id, dtoQuery, resValue);
	}

	@Override
	@PreAuthorize("@securityMethodsService.isMySubject(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return super.remove(id);
	}

	@PreAuthorize("@securityMethodsService.isMySubject(#id) or hasAuthority('ROLE_ADMIN')")
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editLabel(@PathVariable Long id, @RequestBody String label) {
		try {
			return ResponseEntity.ok().body(this.service.editLabel(id,label));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
