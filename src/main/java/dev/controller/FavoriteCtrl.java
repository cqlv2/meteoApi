package dev.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.favorite.FavoriteDtoResponse;
import dev.entity.Favorite;
import dev.service.FavoriteService;

@RestController
@RequestMapping("api/favorite")
public class FavoriteCtrl extends SuperController<Favorite, FavoriteService, FavoriteDtoQuery, FavoriteDtoResponse> {

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
	public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody FavoriteDtoQuery dtoQuery, BindingResult resValue) {
		return super.edit(id, dtoQuery, resValue);
	}

	@Override
	@PreAuthorize("@securityMethodsService.isMyFavorite(#id)")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return super.remove(id);
	}



}
