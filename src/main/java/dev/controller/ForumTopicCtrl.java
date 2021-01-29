package dev.controller;

import javax.validation.Valid;

import dev.exceptions.RepositoryException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.topic.TopicDtoQuery;
import dev.dto.topic.TopicDtoResponse;
import dev.entity.ForumTopic;
import dev.service.ForumTopicService;
@RestController
@RequestMapping("/forum/topic")
public class ForumTopicCtrl extends SuperController<ForumTopic,ForumTopicService,TopicDtoQuery, TopicDtoResponse>{

	@Override
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> add(@Valid @RequestBody TopicDtoQuery dtoQuery, BindingResult resValue) {
		return super.add(dtoQuery, resValue);
	}

	@Override
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody TopicDtoQuery dtoQuery, BindingResult resValue) {
		System.err.println(id + " " + dtoQuery.toString());
		return super.edit(id, dtoQuery, resValue);
	}

	@Override
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return super.remove(id);
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editLabel(@PathVariable Long id ,@RequestBody String label) {
		try {
			return ResponseEntity.ok().body(this.service.editLabel(id, label));
		} catch (RepositoryException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
