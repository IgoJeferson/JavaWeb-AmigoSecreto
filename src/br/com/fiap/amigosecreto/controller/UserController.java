package br.com.fiap.amigosecreto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(ModelMap model) {
		if (AdminController.sorteio.isEmpty()) {
			return "user/user";
		}
		//lógica provisória, buscar remetente por id
		int i = (int)(Math.random() * AdminController.sorteio.size());
		String amigoSecreto = AdminController.sorteio.get(i).getDestinatario().getNome();
		model.addAttribute("amigoSecreto", amigoSecreto);
		return "user/user";
	}
}
