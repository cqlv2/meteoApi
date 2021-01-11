package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{

}
