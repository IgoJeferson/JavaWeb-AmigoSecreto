package br.com.fiap.amigosecreto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.amigosecreto.entity.Participantes;
import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.repository.ParticipantesDao;
import br.com.fiap.amigosecreto.repository.UsuarioDao;

@Controller
public class AdminController {
	UsuarioDao usuarioDao = new UsuarioDao();
	ParticipantesDao participantesDao = new ParticipantesDao();
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap model) {
		List<Participantes> sorteio = participantesDao.listar();
		model.addAttribute("sorteio", sorteio);
		return "admin/admin";
	}
	
	@RequestMapping(value = "/sorteio", method = RequestMethod.POST)
	public String sorteio(ModelMap model, RedirectAttributes rm) {
		try {
			List<Usuario> usuarios = usuarioDao.listarParticipantes();
			int size = usuarios.size(); 
			if (size < 3) {
//				model.addAttribute("mensagem", "São necessários ao menos 3 usuários para realizar o sorteio. Quantidade: " + size);
				rm.addFlashAttribute("mensagem", "São necessários ao menos 3 usuários para realizar o sorteio. Quantidade: " + size);
				return "redirect:admin";
			}
			
			List<Participantes> sorteio = new ArrayList<>();
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
			participantesDao.adicionar(sorteio);
			return "redirect:admin";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mensagem", "Erro no sorteio");
			return "redirect:admin";
		}
	}
	
	private static int getRandomIndex(List<Usuario> participantes) {
		return (int)(Math.random() * participantes.size());
	}
}
