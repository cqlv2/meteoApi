package dev.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.favorite.FavoriteDtoResponse;
import dev.entity.Favorite;
import dev.repository.FavoriteRepository;

@Service
@Transactional

public class FavoriteService extends SuperService<Favorite, FavoriteRepository, FavoriteDtoResponse, FavoriteDtoQuery>{

}
