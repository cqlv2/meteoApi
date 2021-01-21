package dev.config.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.management.RuntimeErrorException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

	private final UserDetailsService userDetailsService;

	public JWTAuthenticationFilter(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

//recuperation des variable d'environement
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

		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(TOKEN_COOKIE)) {
					String token = cookie.getValue();
					DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token);
					String username = decodedJWT.getSubject();
					UserDetails user = userDetailsService.loadUserByUsername(username);
					Authentication authentication = new UsernamePasswordAuthenticationToken(username, null,
							user.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authentication);
					// create the new token
					String newToken = JWT.create().withSubject(username)
							.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME*1000))
							.sign(Algorithm.HMAC512(SECRET_KEY));
					ResponseCookie responseCookie = ResponseCookie.from(TOKEN_COOKIE, newToken).httpOnly(true)
							.maxAge(EXPIRATION_TIME).path("/").sameSite("lax").secure(COOKIE_SECURE).build();
					response.setHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
				}
			}
		}
		filterChain.doFilter(request, response);
	}

}
