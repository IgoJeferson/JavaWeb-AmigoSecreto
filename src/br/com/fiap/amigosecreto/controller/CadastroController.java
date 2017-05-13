package br.com.fiap.amigosecreto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;

@Controller
public class CadastroController {
	
	public static final List<Usuario> usuarios = new ArrayList<>();
	
	{
		Usuario usuario = new Usuario();
		usuario.setCpf("12345678910");
		usuario.setId(1);
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		usuario.setPerfil(Perfil.ADMINISTRADOR);
		usuario.setNome("Administrador");
		usuarios.add(usuario);
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro() {
		return "cadastro";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String cadastro(ModelMap model, Usuario usuario) {
		for (Usuario u : usuarios) {
			if (!u.getLogin().equals(usuario.getLogin())) {
				continue;
			}
			model.addAttribute("mensagem", "Login já existe");
			return "redirect:cadastro";
		}
		usuario.setPerfil(Perfil.PARTICIPANTE);
		usuarios.add(usuario);
		model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
		return "redirect:login";
	}

}
