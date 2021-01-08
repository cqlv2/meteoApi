package dev.controlleur;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/encode")
public class UtilController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
 	
	@GetMapping
	public String encode(@RequestParam String word) {
		return passwordEncoder.encode(word);
	}
}

