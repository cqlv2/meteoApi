package dev.config.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthorizationFilter extends UsernamePasswordAuthenticationFilter {

	private final static long EXPIRATION_TIME = 3600000L;
	private final static String SECRET_KEY = "2932UHDOIUSDH982E92U92EU8ZHJD9IUHS";

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
		String token = JWT.create().withSubject(authResult.getName())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(SECRET_KEY));
		response.addHeader("Authorization", "Bearer " + token);
	}

}
