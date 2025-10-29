package com.tyss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MsgController {

	// apis
	@RequestMapping("/msg")
	public String getMessage() {
		System.out.println("Message method triggered");
		return "message.jsp";
	}

	@RequestMapping("/greet")
	public String greetMsg() {
		System.out.println("greet method is triggered");
		return "good.jsp";
	}

}
