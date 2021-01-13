package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.answer.AnswerDtoQuery;
import dev.dto.answer.AnswerDtoResponse;
import dev.dto.favorite.FavoriteDtoQuery;
import dev.entity.ForumAnswer;
import dev.service.ForumAnswerService;

@RestController
@RequestMapping("/forum/answer")
public class ForumAnswerCtrl extends SuperController<ForumAnswer,ForumAnswerService, AnswerDtoQuery, AnswerDtoResponse> {


	@Override
	@PreAuthorize("@securityMethodsService.isMySubject(#id)")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return super.remove(id);
	}

}
