package dev.utils.transformer;

import java.time.LocalDate;

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
		c.setDateAdd(dtoQuery.getDateAdd()!=null?dtoQuery.getDateAdd():LocalDate.now());
		c.setInseeCode(dtoQuery.getInseeCode());
		c.setPopulation(dtoQuery.getPopulation());
		c.setCityName(dtoQuery.getCityName());
		c.setState(dtoQuery.getState());
		c.setDepartment(dtoQuery.getDepartment());

		if (dtoQuery.getWeathersId() != null) {
			for (Long weatherId : dtoQuery.getWeathersId()) {
				Weather w = new Weather();
				w.setId(weatherId);
				c.getWeathers().add(w);
			}
		}

		if (dtoQuery.getPolluantsId() != null) {
			for (Long polluantId : dtoQuery.getPolluantsId()) {
				Polluant p = new Polluant();
				p.setId(polluantId);
				c.getPolluants().add(p);
			}
		}

		return c;
	}

}
