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

import dev.dto.comment.CommentDtoQuery;
import dev.dto.comment.CommentDtoResponse;
import dev.entity.ForumComment;
import dev.exceptions.RepositoryException;
import dev.service.ForumCommentService;

@RestController
@RequestMapping("/forum/comment")
public class ForumCommentCtrl extends SuperController<ForumComment, ForumCommentService,CommentDtoQuery, CommentDtoResponse>{


	@Override
	@PreAuthorize("@securityMethodsService.isMyComment(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody CommentDtoQuery dtoQuery, BindingResult resValue) {
		return super.edit(id, dtoQuery, resValue);
	}

	@Override
	@PreAuthorize("@securityMethodsService.isMyComment(#id) or hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return super.remove(id);
	}
	
	@PreAuthorize("@securityMethodsService.isMyComment(#id) or hasAuthority('ROLE_ADMIN')")
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editContain(@PathVariable Long id ,@RequestBody String contain) {
		try {
			return ResponseEntity.ok().body(this.service.editContain(id, contain));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	
}
