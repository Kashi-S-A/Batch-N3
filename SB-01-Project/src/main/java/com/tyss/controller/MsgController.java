package com.tyss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MsgController {

	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public String readData(HttpServletRequest request,Model model) {
		System.out.println("======User Data=========");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		System.out.println(name);
		System.out.println(email);
		System.out.println(pwd);
		
		model.addAttribute("username", name);
		model.addAttribute("email", email);
		
		return "message.jsp";
	}

	@RequestMapping("/greet")
	public String greetMsg() {
		System.out.println("greet method is triggered");
		return "good.jsp";
	}

	@RequestMapping("/send")
	public String sendData(Model model) {
		String name = "John";
		int age = 34;

		model.addAttribute("username", name);
		model.addAttribute("userage", age);

		return "message.jsp";
	}

	@RequestMapping("/pass")
	public ModelAndView sendData() {

		Employee employee = new Employee(101, "Martin", "martin@gmail.com", 54000);

		ModelAndView mv = new ModelAndView("greet.jsp");
		mv.addObject("emp", employee);
//		mv.setViewName("greet.jsp");

		return mv;
	}
}
