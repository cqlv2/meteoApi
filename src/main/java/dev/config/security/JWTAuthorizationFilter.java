package dev.config.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthorizationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		setFilterProcessesUrl("/api/login");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			InputStream reqBody = request.getInputStream();
			AuthPOJO authInfo = new ObjectMapper().readValue(reqBody, AuthPOJO.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authInfo.getUsername(),
					authInfo.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// recuperation des variable d'environement
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/main/resources/application.properties"));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		String SECRET_KEY = properties.getProperty("jwt.secret_key");
		String TOKEN_COOKIE = properties.getProperty("jwt.auth_name");
		Long EXPIRATION_TIME = Long.parseLong(properties.getProperty("jwt.expiration_time"));
		Boolean COOKIE_SECURE = Boolean.parseBoolean(properties.getProperty("jwt.cookie_secure"));

		// ------------------------
		String token = JWT.create().withSubject(authResult.getName())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME*1000))
				.sign(Algorithm.HMAC512(SECRET_KEY));
		response.addHeader("Authorization", "Bearer " + token); 
		ResponseCookie responseCookie = ResponseCookie.from(TOKEN_COOKIE, token).httpOnly(true).maxAge(EXPIRATION_TIME*1000)
				.path("/").sameSite("None").secure(COOKIE_SECURE).build();
		response.setHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());

	}

}
