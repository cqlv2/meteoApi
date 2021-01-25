package dev.utils.transformer;

import dev.dto.polluant.PolluantDtoQuery;
import dev.dto.polluant.PolluantDtoResponse;
import dev.entity.City;
import dev.entity.Polluant;

public class PolluantTransformer {
	
	public static PolluantDtoResponse entityToDtoResponse(Polluant entity) {
		return new PolluantDtoResponse(entity);
	}

	public static Polluant dtoToEntity(PolluantDtoQuery dtoQuery) {
		Polluant polluant = new Polluant();
		polluant.setId(dtoQuery.getId() != null ? dtoQuery.getId() : null);
		polluant.setDateAdd(dtoQuery.getDateAdd());
		polluant.setRate(dtoQuery.getRate());
		polluant.setDominentpol(dtoQuery.getDominentpol());
		polluant.setNo2(dtoQuery.getNo2());
		polluant.setO3(dtoQuery.getO3());
		polluant.setPm10(dtoQuery.getPm10());
		polluant.setPm25(dtoQuery.getPm25());
		if (dtoQuery.getCityId() != null) {
			City city = new City();
			city.setId(dtoQuery.getCityId());
			polluant.setCity(city);
		}
		return polluant;
	}

}
