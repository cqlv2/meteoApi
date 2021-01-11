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
		polluant.setLabel(dtoQuery.getLabel());
		polluant.setValue(dtoQuery.getValue());
		if (dtoQuery.getCityId() != null) {
			City city = new City();
			city.setId(dtoQuery.getCityId());
			polluant.setCity(city);
		}
		return polluant;
	}

}
