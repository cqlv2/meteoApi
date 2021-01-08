package dev.utils.transformer;

import org.apache.tomcat.jni.Poll;

import dev.dto.city.CityDtoQuery;
import dev.dto.city.CityDtoResponse;
import dev.entity.City;
import dev.entity.Polluant;
import dev.entity.Weather;

public class CityTransformer {
	
	public static CityDtoResponse entityToDtoResponse(City entity) {
		return new CityDtoResponse(entity);
	}

	public static City dtoToEntity(CityDtoQuery dtoQuery) {
		City c = new City();
		c.setId(dtoQuery.getId() != null ? dtoQuery.getId() : null);
		c.setCodeInsee(dtoQuery.getCodeInsee());
		c.setCodePostal(dtoQuery.getCodePostal());
		c.setNbHab(dtoQuery.getNbHab());
		c.setNomVille(dtoQuery.getNomVille());	
		c.setRegion(dtoQuery.getRegion());
		
		for (Long weatherId : dtoQuery.getMeteosId()) {
			Weather w = new Weather();
			w.setId(weatherId);
			c.getMeteos().add(w);
		}
		
		for (Long polluantId : dtoQuery.getPolluantsId()) {
			Polluant p = new Polluant();
			p.setId(polluantId);
			c.getPolluants().add(p);
		}

		return c;
	}

}
