package br.com.fiap.amigosecreto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String login, String senha, ModelMap model) {
		for (Usuario usuario : CadastroController.usuarios) {
			if (!usuario.getLogin().equals(login) || !usuario.getSenha().equals(senha)) {
				continue;
			}
			if (usuario.getPerfil() == Perfil.ADMINISTRADOR) {
				return "redirect:admin";
			}
			return "redirect:user";
		}
		model.addAttribute("mensagem", "Usuário e/ou senha inválidos");
		return "redirect:login";
	}

}
