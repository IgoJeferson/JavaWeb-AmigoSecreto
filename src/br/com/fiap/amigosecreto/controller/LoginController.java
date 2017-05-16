package br.com.fiap.amigosecreto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;
import br.com.fiap.amigosecreto.repository.UsuarioDao;

@Controller
public class LoginController {
	
	private final UsuarioDao dao = new UsuarioDao();
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String login, String senha, ModelMap model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		try {
			Usuario usuario = dao.buscarUsuario(login, senha);
			if (usuario == null) {
				redirectAttributes.addFlashAttribute("mensagem", "Usuário e/ou senha inválidos");
				return "redirect:login";
			}
			request.getSession().setAttribute("usuario", usuario);
			if (usuario.getPerfil() == Perfil.ADMINISTRADOR) {
				return "redirect:admin";
			}
			return "redirect:user";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao fazer login");
			return "redirect:login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("usuario");
		return "redirect:login";
	}

}
