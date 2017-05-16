package br.com.fiap.amigosecreto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;
import br.com.fiap.amigosecreto.repository.UsuarioDao;

@Controller
public class CadastroController {
	
	private final UsuarioDao dao = new UsuarioDao();

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro(ModelMap model) {
		return "cadastro";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String cadastro(ModelMap model, Usuario usuario, RedirectAttributes redirectAttributes) {
		try {
			String login = usuario.getLogin();
			if (dao.existe(login)) {
				redirectAttributes.addFlashAttribute("mensagem", "Login já existe");
				return "redirect:cadastro";
			}
			usuario.setPerfil(Perfil.PARTICIPANTE);
			dao.adicionar(usuario);
			redirectAttributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
			return "redirect:login";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao cadastrar usuário " + e.getMessage());
			return "redirect:cadastro";
		}
	}
}
