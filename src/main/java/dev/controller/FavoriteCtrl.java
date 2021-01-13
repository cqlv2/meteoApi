package dev.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.favorite.FavoriteDtoResponse;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Favorite;
import dev.exceptions.RepositoryException;
import dev.service.FavoriteService;
import dev.service.MemberService;

@RestController
@RequestMapping("api/favorite")
public class FavoriteCtrl extends SuperController<Favorite, FavoriteService,FavoriteDtoQuery,FavoriteDtoResponse> {



//	@Autowired
//	private MemberService memberServ;

	@Override
	public ResponseEntity<?> findAll() {
		return ResponseEntity.badRequest().body("prohibited");
	}



	@Override
	@PreAuthorize("@securityMethodsService.isMyFavorite(#id)")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return super.findById(id);
	}


	
	
	@Override
	@PreAuthorize("@securityMethodsService.isMyFavorite(#id)")
	public ResponseEntity<?> edit(@PathVariable Long id, FavoriteDtoQuery dtoQuery) {
		return super.edit(id, dtoQuery);
	}



	@Override
	@PreAuthorize("@securityMethodsService.isMyFavorite(#id)")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return ResponseEntity.badRequest().body("prohibited");
	}

	
}
