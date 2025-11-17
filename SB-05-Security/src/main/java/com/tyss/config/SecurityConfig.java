package com.tyss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
		    .authorizeHttpRequests(req -> req
		    			.requestMatchers("/admin/**").hasRole("ADMIN")
		    			.anyRequest().hasAnyRole("ADMIN","USER"))
						.formLogin(Customizer.withDefaults())
						.logout(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	public UserDetailsService getUsers() {
		UserDetails admin = User.withDefaultPasswordEncoder()
									.username("dinga")
									.password("123")
									.roles("ADMIN")
									.build();
		
		UserDetails user = User.withDefaultPasswordEncoder()
								.username("dingi")
								.password("234")
								.roles("USER")
								.build();
		
		UserDetails customer = User.withDefaultPasswordEncoder()
				.username("manga")
				.password("321")
				.roles("CUSTOMER")
				.build();
		
		return new InMemoryUserDetailsManager(admin,user,customer);
	}
}
