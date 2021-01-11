package dev.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.dto.city.CityDtoResponse;
import dev.dto.weather.WeatherDtoQuery;
import dev.dto.weather.WeatherDtoResponse;
import dev.entity.Weather;
import dev.repository.WeatherRepository;

@Service
@Transactional
public class WeatherService extends SuperService<Weather, WeatherRepository, WeatherDtoResponse, WeatherDtoQuery> {

	@Autowired
	CityService cityServ;

	/**
	 * method automatically call 5 minutes after starting the application then every
	 * hour to update the weather data in the database
	 * 
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@Scheduled(initialDelay = 300 * 1000, fixedDelay = 3600 * 1000)
	public void updateFromApi() throws JsonMappingException, JsonProcessingException {
		// mise en place du chrono pour mesurer la durée de la requete
		Long start = System.currentTimeMillis();
		System.out.println("Updating weather dataBase...");
		String token = "f11b1f113049111b41343297805d6707";
		String api = "https://api.openweathermap.org/data/2.5/weather?appid=" + token + "&units=metric&q=";
		// chargement des objet de rest et de mapper json
		RestTemplate rt = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();

		// recuperation de toute les villes de la badabase
		List<CityDtoResponse> cityList = cityServ.getAll();

		// pour chaque ville ...
		for (CityDtoResponse city : cityList) {
			// on essaye d'appeler l'api
			HttpEntity<String> response = null;
			try {
				response = rt.getForEntity(api + city.getCityName(), String.class);
			} catch (Exception e) {
				// TODO faire un logger !
				// si l'appelle rate on affiche l'erreur et on continu
				System.err.println("error on city : " + city.getCityName());
				System.err.println(e.getMessage());
				continue;
			}

			// on parse les donnée obtenu
			JsonNode root = mapper.readTree(response.getBody());
			JsonNode weather = root.path("weather");
			JsonNode main = root.path("main");
			JsonNode wind = root.path("wind");

			// creation du DTO
			WeatherDtoQuery wDtoQ = new WeatherDtoQuery();
			wDtoQ.setHumidity(main.path("humidity").asDouble());
			wDtoQ.setPressure(main.path("pressure").asDouble());
			wDtoQ.setTemp(main.path("temp").asDouble());
			wDtoQ.setTempMax(main.path("temp_max").asDouble());
			wDtoQ.setTempMin(main.path("temp_min").asDouble());
			wDtoQ.setVilleId(city.getId());
			wDtoQ.setWindDirection(wind.path("deg").asInt());
			wDtoQ.setWindSpeed(wind.path("speed").asDouble());
			// enregistrement des données
			this.addUpdate(wDtoQ);
		}

		Long stop = System.currentTimeMillis();
		String time = new SimpleDateFormat("mm:ss:SSS").format(new Date(stop - start));
		System.out.println("... weather database updating in " + time + "at"
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

	}

}
