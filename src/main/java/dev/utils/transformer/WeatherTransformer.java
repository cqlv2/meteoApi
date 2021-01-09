package dev.utils.transformer;

import java.time.LocalDate;

import dev.dto.weather.WeatherDtoQuery;
import dev.dto.weather.WeatherDtoResponse;
import dev.entity.City;
import dev.entity.Weather;

public class WeatherTransformer {
	
	public static WeatherDtoResponse entityToDtoResponse(Weather entity) {
		return new WeatherDtoResponse(entity);
	}

	public static Weather dtoToEntity(WeatherDtoQuery dtoQuery) {
		Weather w = new Weather();
		w.setId(dtoQuery.getId() != null ? dtoQuery.getId() : null);
		w.setDateAdd(dtoQuery.getDateAdd()!=null?dtoQuery.getDateAdd():LocalDate.now());
		w.setHumidity(dtoQuery.getHumidity());
		w.setPressure(dtoQuery.getPressure());
		w.setTemp(dtoQuery.getTemp());
		w.setTempMax(dtoQuery.getTempMax());
		w.setTempMin(dtoQuery.getTempMin());
		w.setWindDirection(dtoQuery.getWindDirection());
		w.setWindSpeed(dtoQuery.getWindSpeed());
		
		if(dtoQuery.getVilleId() != null) {
			City c = new City();
			c.setId(dtoQuery.getVilleId());
			w.setVille(c);
		}
		return w;
	}

}
