package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.comment.CommentDtoQuery;
import dev.dto.comment.CommentDtoResponse;
import dev.entity.ForumComment;
import dev.service.ForumCommentService;

@RestController
@RequestMapping("/api/forum/comment")
public class ForumCommentCtrl extends SuperController<ForumComment, ForumCommentService,CommentDtoQuery, CommentDtoResponse>{

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * add a new entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PostMapping
	public ResponseEntity<?> add(@RequestBody CommentDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	/**
	 * edit an entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PutMapping
	public ResponseEntity<?> edit(@RequestBody CommentDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}
}
