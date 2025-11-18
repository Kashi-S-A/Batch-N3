package com.tyss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.dto.LoginDTO;
import com.tyss.entity.Customer;
import com.tyss.repo.CustomerRepo;
import com.tyss.service.JwtService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	// Register
	@PostMapping("/register")
	public ResponseEntity<String> save(@RequestBody Customer customer) {

		String encodedPwd = passwordEncoder.encode(customer.getPassword());

		customer.setPassword(encodedPwd);

		customerRepo.save(customer);

		return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
	}

	// login
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),
				loginDTO.getPassword());

		try {
			Authentication authication = authenticationManager.authenticate(token);

			if (authication.isAuthenticated()) {
				// login successful
				// generate jwt token and return it
				String jwt = jwtService.generateToken(loginDTO.getEmail());
				return ResponseEntity.status(HttpStatus.OK).body("Token :" + jwt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid cred");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
	}

	// welcome
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		return ResponseEntity.status(HttpStatus.OK).body("Welcome to App");
	}

}
