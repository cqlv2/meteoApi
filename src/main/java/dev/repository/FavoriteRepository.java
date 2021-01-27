package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.dto.favorite.FavoriteDtoResponse;
import dev.entity.Favorite;
import dev.entity.Member;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{

	@Query("select f from Favorite f where f.member=?1")
	List<FavoriteDtoResponse> findByMember(Member member);

}
