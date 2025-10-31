package com.tyss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tyss.dto.UserDTO;

@Controller
public class UserController {

	@RequestMapping("/")
	public String registerPage(Model model) {
		model.addAttribute("userdto", new UserDTO());
		System.out.println("Displaying register page with userDTO model");
		return "register.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(UserDTO userdto,Model model) {
		System.out.println(userdto);
		model.addAttribute("username", userdto.getFirstName());
		model.addAttribute("email", userdto.getEmail());
		return "message.jsp";
	}
	
}
