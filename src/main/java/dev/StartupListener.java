package dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import dev.dto.member.MemberDtoQuery;
import dev.enumeration.RoleEnum;
import dev.exceptions.RepositoryException;
import dev.service.CityService;
import dev.service.MemberService;
import dev.service.RoleService;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private CityService cityServ;
	@Autowired
	private MemberService memberserv;


	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		System.out.println("initialization...");

		
		try {
			memberserv.checkAdmin();
		} catch (RepositoryException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			

		try {
			cityServ.updateCityFromApi();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
