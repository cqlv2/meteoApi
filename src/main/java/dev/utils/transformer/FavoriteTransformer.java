package dev.utils.transformer;

import dev.dto.favorite.FavoriteDtoQuery;
import dev.dto.favorite.FavoriteDtoResponse;
import dev.entity.City;
import dev.entity.Favorite;
import dev.entity.Member;

public class FavoriteTransformer {

	public static FavoriteDtoResponse entityToDtoResponse(Favorite entity) {
		return new FavoriteDtoResponse(entity);
	}

	public static Favorite dtoToEntity(FavoriteDtoQuery dtoQuery) {
		Favorite f = new Favorite();
		f.setId(dtoQuery.getId() != null ? dtoQuery.getId() : null);
		f.setDateAdd(dtoQuery.getDateAdd());
		f.setInfoWeather(dtoQuery.getInfoWeather());
		f.setPolluants(dtoQuery.getPolluants());
		f.setShowPolluants(dtoQuery.getShowPolluants());
		f.setShowWeather(dtoQuery.getShowWeather());

		if (dtoQuery.getVilleId() != null) {
			City v = new City();
			v.setId(dtoQuery.getVilleId());
			f.setCity(v);
		}
		if (dtoQuery.getMemberId() != null) {
			Member m = new Member();
			m.setId(dtoQuery.getMemberId());
			f.setMember(m);
		}
		return f;
	}
}
