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
		List<Usuario> usuarios = new ArrayList<>();
		
		for (Usuario usuario : CadastroController.usuarios) {
			if (usuario.getPerfil() == Perfil.PARTICIPANTE) {
				usuarios.add(usuario);
			}
		}
		int size = usuarios.size(); 
		if (size < 3) {
			model.addAttribute("mensagem", "S�o necess�rios ao menos 3 usu�rios para realizar o sorteio. Quantidade: " + size);
			return "redirect:admin";
		}
		
		int i = getRandomIndex(usuarios);
		Usuario primeiroRemetente = usuarios.get(i); 
		Usuario remetente = primeiroRemetente;
		usuarios.remove(i);
		
		while (!usuarios.isEmpty()) {
			i = getRandomIndex(usuarios);
			Usuario destinatario = usuarios.get(i);
			usuarios.remove(i);
			Participantes participantes = new Participantes();
			participantes.setRemetente(remetente);
			participantes.setDestinatario(destinatario);
			sorteio.add(participantes);
			remetente = destinatario;
		}
		Participantes p = new Participantes();
		p.setRemetente(remetente);
		p.setDestinatario(primeiroRemetente);
		sorteio.add(p);
		
		return "redirect:admin";
	}
	
	private static int getRandomIndex(List<Usuario> participantes) {
		return (int)(Math.random() * participantes.size());
	}
}
