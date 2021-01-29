package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.answer.AnswerDtoQuery;
import dev.dto.answer.AnswerDtoResponse;
import dev.entity.ForumAnswer;
import dev.exceptions.RepositoryException;
import dev.service.ForumAnswerService;

@RestController
@RequestMapping("/forum/answer")
public class ForumAnswerCtrl extends SuperController<ForumAnswer,ForumAnswerService, AnswerDtoQuery, AnswerDtoResponse> {


	@Override
	@PreAuthorize("@securityMethodsService.isMyAnswer(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return super.remove(id);
	}
	
	@PreAuthorize("@securityMethodsService.isMyAnswer(#id) or hasAuthority('ROLE_ADMIN')")
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editContain(@PathVariable Long id ,@RequestBody String contain) {
		try {
			return ResponseEntity.ok().body(this.service.editContain(id, contain));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
