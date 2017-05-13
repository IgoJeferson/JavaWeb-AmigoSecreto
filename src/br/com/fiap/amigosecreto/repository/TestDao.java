package br.com.fiap.amigosecreto.repository;

import br.com.fiap.amigosecreto.entity.Participantes;
import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;

public class TestDao {

	public static void main(String[] args) {

		GenericDao<Usuario> genericUsuario = new GenericDao<Usuario>(Usuario.class);
		GenericDao<Participantes> genericSorteio = new GenericDao<Participantes>(Participantes.class);
		
		adicionarUsuariosParaTeste(genericUsuario, genericSorteio);
		buscarUsuarioTeste(genericUsuario);
		buscarUsuariosTeste(genericUsuario);
	}

	private static void buscarUsuariosTeste(GenericDao<Usuario> genericUsuario) {
		genericUsuario.listar();
	}

	private static void buscarUsuarioTeste(GenericDao<Usuario> genericUsuario) {
		Usuario usuario = genericUsuario.buscar(1);
		System.out.println(usuario.toString());
	}

	public static void adicionarUsuariosParaTeste(GenericDao<Usuario> genericUsuario, GenericDao<Participantes> genericSorteio) {

		Usuario usuario = new Usuario();
		usuario.setCpf("12345678910");
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		usuario.setPerfil(Perfil.ADMINISTRADOR);
		usuario.setNome("Administrador");

		Usuario usuario1 = new Usuario();
		usuario1.setCpf("12345678911");
		usuario1.setLogin("teste1");
		usuario1.setSenha("teste1");
		usuario1.setPerfil(Perfil.PARTICIPANTE);
		usuario1.setNome("teste1");

		Usuario usuario2 = new Usuario();
		usuario2.setCpf("12345678912");
		usuario2.setLogin("teste2");
		usuario2.setSenha("teste2");
		usuario2.setPerfil(Perfil.PARTICIPANTE);
		usuario2.setNome("teste2");

		Usuario usuario3 = new Usuario();
		usuario3.setCpf("12345678913");
		usuario3.setLogin("teste3");
		usuario3.setSenha("teste3");
		usuario3.setPerfil(Perfil.PARTICIPANTE);
		usuario3.setNome("teste3");

		genericUsuario.adicionar(usuario);
		genericUsuario.adicionar(usuario1);
		genericUsuario.adicionar(usuario2);
		genericUsuario.adicionar(usuario3);
		
		Participantes participantes = new Participantes();
		participantes.setRemetente(usuario1); 
		participantes.setDestinatario(usuario2);
		genericSorteio.adicionar(participantes);
	}
}
