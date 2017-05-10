package br.com.fiap.amigosecreto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(String login, String senha) {
		System.out.println(login);
		System.out.println(senha);
	}

}
