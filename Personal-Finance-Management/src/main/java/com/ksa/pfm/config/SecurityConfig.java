package com.ksa.pfm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.UserRepo;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserRepo userRepo;
	
	@Bean
	public UserDetailsService userService() {
		
		return username -> {
			User user = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
			return org.springframework.security.core.userdetails.User
				.withUsername(user.getEmail())
				.password(user.getPassword())
				.roles("USER")
				.build();
		};
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(req ->
				req.requestMatchers(
						"/register",
						"/login",
						"/error",
						"/static/**")
				.permitAll()
				.requestMatchers("/WEB-INF/**").permitAll()
				.anyRequest().authenticated()
				)
			.formLogin(form -> form
					.loginPage("/login")//GET
					.loginProcessingUrl("/do-login")//POST
					.defaultSuccessUrl("/dashboard",true)
					.failureHandler((request, response, exception) -> 
						response.sendRedirect("/login?msg=Invalid credintials"))//GET
					.permitAll()

			)
			.logout(logout ->logout
				 .logoutUrl("/logout")
			     .logoutSuccessUrl("/login?logout").permitAll());
			
		return http.build();
	}
}
