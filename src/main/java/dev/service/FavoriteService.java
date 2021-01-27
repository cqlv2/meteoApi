package dev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.favorite.FavoriteDtoResponse;
import dev.entity.Favorite;
import dev.exceptions.RepositoryException;
import dev.repository.FavoriteRepository;

@Service
@Transactional

public class FavoriteService extends SuperService<Favorite, FavoriteRepository, FavoriteDtoResponse, FavoriteDtoQuery>{
	@Autowired
	MemberService memberServ;
	
	public List<FavoriteDtoResponse> getByMemberId(Long memberId) throws RepositoryException {
		return this.repository.findByMember(memberServ.getEntityById(memberId));
	}
}

