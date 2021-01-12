package dev.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Favorite;
import dev.exceptions.RepositoryException;
import dev.service.FavoriteService;
import dev.service.MemberService;

@RestController
@RequestMapping("api/favorite")
public class FavoriteCtrl extends SuperController<Favorite, FavoriteService>{
	
	
	@PreAuthorize("@SecurityMethodsService.test(principal)")
	@GetMapping("/toto")
	public void toto() {
		
	}
	
	@Autowired
	private MemberService memberServ;
	
	@Override
	public ResponseEntity<?> findAll() {
		return ResponseEntity.badRequest().body("prohibited");
	}

	@Override
	public ResponseEntity<?> findById(Long id) {
		return ResponseEntity.badRequest().body("prohibited");
	}

	@Override
	@PreAuthorize("@SecurityMethodsService.canRemoveFavorite(#id, principal)")
	public ResponseEntity<?> remove(Long id) {
		return super.remove(id);
	}

	/**
	 * add a new entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	@PostMapping
	public ResponseEntity<?> add(@RequestBody FavoriteDtoQuery dtoQuery) {
		return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
	}

	/**
	 * edit an entry to the database
	 * 
	 * @param dtoQuery an instance of a dto Object parsed with jackson
	 * @return a response entity(ok) with 1 value formatted in DTO
	 */
	
	
	@PutMapping
	public ResponseEntity<?> edit(@RequestBody FavoriteDtoQuery dtoQuery, Principal principal) {
		MemberDtoResponse connectedMember = null;
		try {
			connectedMember = memberServ.readByEmail(principal.getName());
		} catch (RepositoryException e) {
			ResponseEntity.badRequest().body(e.getMessage());
		}
		if(dtoQuery.getMemberId().equals(connectedMember.getId())) {
			return ResponseEntity.ok().body(service.addUpdate(dtoQuery));
		}else {
			return ResponseEntity.badRequest().body("not owner");
		}	
	}
	
}
