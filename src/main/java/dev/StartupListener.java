package dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.service.CityService;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private CityService cityServ;

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		System.out.println("initialization...");

		try {
			cityServ.updateCityFromApi();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
