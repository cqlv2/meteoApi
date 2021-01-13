package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("hasAutority('ROLE_ADMIN')")
	public ResponseEntity<?> add(TopicDtoQuery dtoQuery) {
		// TODO Auto-generated method stub
		return super.add(dtoQuery);
	}

	@Override
	@PreAuthorize("hasAutority('ROLE_ADMIN')")
	public ResponseEntity<?> edit(@PathVariable Long id, TopicDtoQuery dtoQuery) {
		return super.edit(id, dtoQuery);
	}

	@Override
	@PreAuthorize("hasAutority('ROLE_ADMIN')")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return super.remove(id);
	}

	
}
