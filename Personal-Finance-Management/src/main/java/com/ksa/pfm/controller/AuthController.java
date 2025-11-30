package com.ksa.pfm.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ksa.pfm.dto.RegisterDTO;
import com.ksa.pfm.model.User;
import com.ksa.pfm.repo.UserRepo;

@Controller
public class AuthController {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// login page
	@GetMapping("/login")
	public String getMethodName(Principal principal, @RequestParam(required = false) String msg, Model model) {
		model.addAttribute("msg", msg);
		if (principal != null) {
	        return "redirect:/dashboard";
	    }
		return "login";
	}

	// register page
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("dto", new RegisterDTO());
		return "register";
	}

	// register user
	@PostMapping("/register")
	public String registerUser(RegisterDTO dto) {
		Optional<User> opt = userRepo.findByEmail(dto.getEmail());
		String msg = null;
		if (opt.isPresent()) {
			msg = "Already Registered";
		} else {
			User user = new User();
			BeanUtils.copyProperties(dto, user);
			user.setPassword(passwordEncoder.encode(dto.getPassword()));
			userRepo.save(user);

			msg = "Registered Successfully";
		}

		return "redirect:/login?msg="+msg;
	}

}
