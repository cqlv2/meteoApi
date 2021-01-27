package dev.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.dto.city.CityDtoQuery;
import dev.dto.city.CityDtoResponse;
import dev.entity.City;
import dev.repository.CityRepository;

@Service
@Transactional
public class CityService extends SuperService<City, CityRepository, CityDtoResponse, CityDtoQuery> {

	public String[] getAllStates(){
		return this.repository.getState();
	}
	
	
	public String[] getAllDepartment() {
		return this.repository.getDepartment();
	}
	
	
	
	/**
	 * method call when starting the application. it searches and adds the 5 largest
	 * cities of each department of France in database if it is empty
	 * 
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */

//	methode appeler au demarage de l'application
	public void updateCityFromApi() throws JsonMappingException, JsonProcessingException {

		// si la liste de ville est vide
		if (this.getAll().size() == 0) {
			Long start = System.currentTimeMillis();
			System.out.println("Updating city dataBase...");
			RestTemplate rt = new RestTemplate();
			ObjectMapper mapper = new ObjectMapper();
			String api = "https://geo.api.gouv.fr/";
			// appelle de l'api pour lister de toutes les regions de france
			ResponseEntity<String> response = rt.getForEntity(api + "regions?fields=nom,code", String.class);
			JsonNode states = mapper.readTree(response.getBody());

			// pour chaque region on appelle l'api pour lister ses departement
			for (JsonNode stateJn : states) {
				String state = stateJn.path("nom").asText();
				String codeRegion = stateJn.path("code").asText();
				response = rt.getForEntity(api + "regions/" + codeRegion + "/departements?fields=nom,code",
						String.class);
				JsonNode departments = mapper.readTree(response.getBody());

				// pour chaque departement on appelle l'api pour lister ses villes
				for (JsonNode departmentJn : departments) {
					String department = departmentJn.path("nom").asText();
					String departementCode = departmentJn.path("code").asText();
					response = rt.getForEntity(
							api + "departements/" + departementCode
									+ "/communes?fields=nom,code,population,centre&format=json&geometry=centre",
							String.class);
					JsonNode villes = mapper.readTree(response.getBody());

					// creation de la liste des dto city
					List<CityDtoQuery> cityList = new ArrayList<CityDtoQuery>();
					for (JsonNode villeJn : villes) {
						// creation du dtoQuery
						CityDtoQuery cDtoQ = new CityDtoQuery();
						cDtoQ.setCityName(villeJn.path("nom").asText());
						cDtoQ.setDepartment(department);
						cDtoQ.setState(state);
						cDtoQ.setInseeCode(villeJn.path("code").asText());
						cDtoQ.setPopulation(villeJn.path("population").asLong());
						
						JsonNode coordone = villeJn.path("centre").path("coordinates");
						cDtoQ.setLongitude(coordone.get(0).asDouble());
						cDtoQ.setLatitude(coordone.get(1).asDouble());

						cityList.add(cDtoQ);
					}

					// trier la liste en ordre croissant
					cityList.sort(Comparator.comparing(c -> c.getPopulation()));

					// si la liste contient plus de 5 entrée, on recupere les 5 derniere sinon prend
					// tout !
					int nbCity = cityList.size() > 5 ? cityList.size() - 6 : 0;
					for (int i = cityList.size() - 1; i > nbCity; i--) {
						// enregistrement des villes en bdd
						this.addUpdate(cityList.get(i));
					}
				}
			}
			Long stop = System.currentTimeMillis();
			String time = new SimpleDateFormat("mm:ss:SSS").format(new Date(stop - start));
			System.out.println("... city database updating in " + time);
		} else {
			System.out.println("city database is up to date.");
		}
	}








}
