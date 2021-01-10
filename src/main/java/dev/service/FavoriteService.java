package dev.service;

import org.springframework.stereotype.Service;

import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.favorite.FavoriteDtoResponse;
import dev.entity.Favorite;

@Service
public class FavoriteService extends SuperService<Favorite, FavoriteRepository, FavoriteDtoResponse, FavoriteDtoQuery>{

}
