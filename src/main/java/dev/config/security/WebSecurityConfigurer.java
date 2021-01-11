package dev.config.security;

import org.springframework.context.annotation.Configuration;
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

		http.authorizeRequests()

//				.antMatchers("/api/login").permitAll()
//				.antMatchers("/api/public/**").permitAll()
//				.antMatchers("/api/admin/**").hasRole("ADMIN")
//				.antMatchers("/api/encode").permitAll()
				.antMatchers("/api/city/**").permitAll()
				.antMatchers("/api/**").authenticated()
				.and().addFilter(new JWTAuthorizationFilter(authenticationManager()))
				.addFilterAfter(new JWTAuthenticationFilter(userDetailsService), BasicAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic().and()
				.csrf().disable();
	}

	// 1
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

}
