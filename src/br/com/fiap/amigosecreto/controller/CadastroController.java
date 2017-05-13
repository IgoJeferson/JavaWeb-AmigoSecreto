package br.com.fiap.amigosecreto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;
import br.com.fiap.amigosecreto.repository.GenericDao;

@Controller
public class CadastroController {

	public static final List<Usuario> usuarios = new ArrayList<>();

	{
		Usuario usuario = new Usuario();
		usuario.setCpf("12345678910");
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		usuario.setPerfil(Perfil.ADMINISTRADOR);
		usuario.setNome("Administrador");
		usuarios.add(usuario);

		Usuario usuario1 = new Usuario();
		usuario1.setCpf("12345678910");
		usuario1.setLogin("teste1");
		usuario1.setSenha("teste1");
		usuario1.setPerfil(Perfil.PARTICIPANTE);
		usuario1.setNome("Administrador");
		usuarios.add(usuario1);

		Usuario usuario2 = new Usuario();
		usuario2.setCpf("12345678910");
		usuario2.setLogin("teste2");
		usuario2.setSenha("teste2");
		usuario2.setPerfil(Perfil.PARTICIPANTE);
		usuario2.setNome("Administrador");
		usuarios.add(usuario2);

		Usuario usuario3 = new Usuario();
		usuario3.setCpf("12345678910");
		usuario3.setLogin("teste3");
		usuario3.setSenha("teste3");
		usuario3.setPerfil(Perfil.PARTICIPANTE);
		usuario3.setNome("Administrador");
		usuarios.add(usuario3);
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro() {
		return "cadastro";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String cadastro(ModelMap model, Usuario usuario) {

		GenericDao<Usuario> genericUsuario = new GenericDao<Usuario>(Usuario.class);

		for (Usuario u : usuarios) {
			if (!u.getLogin().equals(usuario.getLogin())) {
				continue;
			}
			model.addAttribute("mensagem", "Login já existe");
			return "redirect:cadastro";
		}
		
		usuario.setPerfil(Perfil.PARTICIPANTE);
		genericUsuario.adicionar(usuario);
		model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");

		return "redirect:login";
	}
}
