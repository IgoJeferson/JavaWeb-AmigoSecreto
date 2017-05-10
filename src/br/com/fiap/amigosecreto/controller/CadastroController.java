package br.com.fiap.amigosecreto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.amigosecreto.entity.Usuario;

@Controller
public class CadastroController {
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro() {
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String cadastro(ModelMap model, Usuario usuario) {
		System.out.println(usuario.getNome());
		System.out.println(usuario.getCpf());
		System.out.println(usuario.getLogin());
		System.out.println(usuario.getSenha());
		model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
		return "redirect:login";
	}

}
