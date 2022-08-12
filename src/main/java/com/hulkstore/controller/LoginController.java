package com.hulkstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author coses
 *
 */
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	@GetMapping("/index")
	public String index() {
		return "/index";
	}
}
