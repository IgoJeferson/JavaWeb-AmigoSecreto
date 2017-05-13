package br.com.fiap.amigosecreto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.amigosecreto.entity.Participantes;
import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;

@Controller
public class AdminController {
	private static final List<Participantes> sorteio = new ArrayList<>();
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.addAttribute("sorteio", sorteio);
		return "admin/admin";
	}
	
	@RequestMapping(value = "/sorteio", method = RequestMethod.POST)
	public String sorteio(ModelMap model) {
		List<Usuario> participantes = new ArrayList<>();
		
		for (Usuario usuario : CadastroController.usuarios) {
			if (usuario.getPerfil() == Perfil.PARTICIPANTE) {
				participantes.add(usuario);
			}
		}
		int size = participantes.size(); 
		if (size < 3) {
			model.addAttribute("mensagem", "São necessários ao menos 3 usuários para realizar o sorteio. Quantidade: " + size);
			return "redirect:admin";
		}
		
		do {
			int i = getRandomIndex(participantes);
			Usuario remetente = participantes.get(i);
			participantes.remove(i);
			i = getRandomIndex(participantes);
			Usuario destinatario = participantes.get(i);
			participantes.remove(i);
		} while(!participantes.isEmpty());
		
		Usuario remetente;
		
		
		while (!participantes.isEmpty()) {
			
		}
		
		return "";
	}
	
	private static int getRandomIndex(List<Usuario> participantes) {
		return (int)(Math.random() * participantes.size());
	}
}
