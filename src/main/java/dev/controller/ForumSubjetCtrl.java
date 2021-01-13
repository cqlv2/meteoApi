package dev.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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


	@Override
	@PreAuthorize("@securityMethodsService.isMySubject(#id)")
	public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody SubjectDtoQuery dtoQuery, BindingResult resValue) {
		return super.edit(id, dtoQuery, resValue);
	}

	@Override
	@PreAuthorize("@securityMethodsService.isMySubject(#id)")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return super.remove(id);
	}

}
