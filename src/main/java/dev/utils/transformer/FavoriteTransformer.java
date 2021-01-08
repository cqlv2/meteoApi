package dev.utils.transformer;

import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.favorite.FavoriteDtoReponse;
import dev.entity.Favorite;
import dev.entity.Member;
import dev.entity.Ville;

public class FavoriteTransformer {

	public static FavoriteDtoReponse entityToDtoResponse(Favorite entity) {
		return new FavoriteDtoReponse(entity);
	}

	public static Favorite dtoToEntity(FavoriteDtoQuery dtoQuery) {
		Favorite f = new Favorite();
		f.setId(dtoQuery.getId() != null ? dtoQuery.getId() : null);
		f.setInfoWeather(dtoQuery.getInfoWeather());
		f.setPolluant(dtoQuery.getPolluant());
		f.setShowPolluants(dtoQuery.getShowPolluants());
		f.setShowWeather(dtoQuery.getShowWeather());

		if (dtoQuery.getVilleId() != null) {
			Ville v = new Ville();
			v.setId(dtoQuery.getVilleId());
			f.setVille(v);
		}
		if (dtoQuery.getMemberId() != null) {
			Member m = new Member();
			m.setId(dtoQuery.getMemberId());
			f.setMember(m);
		}
		return f;
	}
}
