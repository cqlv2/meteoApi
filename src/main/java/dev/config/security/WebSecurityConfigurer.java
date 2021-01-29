package dev.config.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;
	private PasswordEncoder passwordEncoder;
	


	public WebSecurityConfigurer(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/main/resources/application.properties"));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		String TOKEN_COOKIE = properties.getProperty("jwt.auth_name");
		
		http
		.csrf().disable()
        .cors()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.httpBasic()
		.and()
		.exceptionHandling().authenticationEntryPoint((request, response, authException) -> response.setStatus(HttpServletResponse.SC_FORBIDDEN))
		 .and()
		.authorizeRequests()
		.antMatchers("/api/login").permitAll()
		.antMatchers(HttpMethod.GET, "/api/cities/**").permitAll()
		.antMatchers(HttpMethod.GET, "/forum/**").permitAll()
		.antMatchers(HttpMethod.POST, "/api/members").permitAll()
//		.antMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
//		.antMatchers("/forum/admin/**").hasAuthority("ROLE_ADMIN")
		.antMatchers("/api/**").authenticated()
		.antMatchers("/forum/**").authenticated()
		.and()
		.addFilter(new JWTAuthorizationFilter(authenticationManager()))
		.addFilterBefore(new JWTAuthenticationFilter(userDetailsService), BasicAuthenticationFilter.class)
		.logout()
        .logoutSuccessHandler((req, resp, auth) -> resp.setStatus(HttpServletResponse.SC_OK))
        .deleteCookies(TOKEN_COOKIE);
		http.headers().frameOptions().sameOrigin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

}
