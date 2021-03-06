package dev.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dto.city.CityDtoResponse;
import dev.dto.polluant.PolluantDtoQuery;
import dev.dto.polluant.PolluantDtoResponse;
import dev.entity.Polluant;
import dev.repository.PolluantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class PolluantService extends SuperService<Polluant, PolluantRepository, PolluantDtoQuery, PolluantDtoResponse> {

	@Autowired
	private CityService cityService;
	@Scheduled(initialDelay = 3 * 1000, fixedDelay = 3600 * 1000)
	public void updateFromApi() throws JsonProcessingException {
		// mise en place du chrono pour mesurer la durée de la requete
		Long start = System.currentTimeMillis();
		System.out.println("Updating polluant dataBase...");
		// https://api.waqi.info/feed/VILLE/?token=TOKEN
		String token = "42b702158eea48900039d943a75df764d5833772";
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		List<CityDtoResponse> cityList = cityService.getAll();
		for (CityDtoResponse city : cityList) {
			HttpEntity<String> reponse = null;
			try {
				reponse = restTemplate.getForEntity(
						"https://api.waqi.info/feed/" + city.getCityName() + "/?token=" + token, String.class);
			} catch (Exception e) {
				// TODO : faire un logger
				System.err.println("error on city : " + city.getCityName());
				System.err.println(e.getMessage());
				continue;
			}
			JsonNode root = objectMapper.readTree(reponse.getBody());
			JsonNode data = root.path("data");
			JsonNode iaqi = data.path("iaqi");
			PolluantDtoQuery pDtoQ = new PolluantDtoQuery();
			pDtoQ.setCityId(city.getId());
			pDtoQ.setRate(data.path("aqi").asInt());
			pDtoQ.setDominentpol(data.path("dominentpol").asText());
			pDtoQ.setNo2(iaqi.path("no2").path("v").asDouble());
			pDtoQ.setO3(iaqi.path("o3").path("v").asDouble());
			pDtoQ.setPm10(iaqi.path("pm10").path("v").asDouble());
			pDtoQ.setPm25(iaqi.path("pm25").path("v").asDouble());
			this.addUpdate(pDtoQ);
		}
		Long stop = System.currentTimeMillis();
		String time = new SimpleDateFormat("mm:ss:SSS").format(new Date(stop - start));
		System.out.println("... polluant database updated in " + time + "at"
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
	}
}
