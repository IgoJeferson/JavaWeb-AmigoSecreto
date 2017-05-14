package br.com.fiap.amigosecreto.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.repository.ParticipantesDao;

@Controller
public class UserController {
	private final ParticipantesDao dao = new ParticipantesDao();
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(ModelMap model, HttpServletRequest request) {
		if (!dao.sorteioRealizado()) {
			return "user/user";
		}
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		int id = usuario.getId();
		String amigoSecreto = dao.busqueAmigoSecreto(id);
		model.addAttribute("amigoSecreto", amigoSecreto);
		return "user/user";
	}
}
