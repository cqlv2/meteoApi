package dev.utils.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoder {

	public static String encode(String toEncode) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(toEncode);
	}

}
