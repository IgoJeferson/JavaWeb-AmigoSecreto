package br.com.fiap.amigosecreto.repository;

import br.com.fiap.amigosecreto.entity.Usuario;
import br.com.fiap.amigosecreto.enums.Perfil;

public class TestDao {

	public static void main(String[] args) {

		GenericDao<Usuario> genericUsuario = new GenericDao<Usuario>(Usuario.class);
		genericUsuario.em = JpaUtil.getEntityManager();

		adicionarUsuariosParaTeste(genericUsuario);
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

	public static void adicionarUsuariosParaTeste(GenericDao<Usuario> genericUsuario) {

		Usuario usuario = new Usuario();
		usuario.setCpf("12345678910");
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		usuario.setPerfil(Perfil.ADMINISTRADOR);
		usuario.setNome("Administrador");

		Usuario usuario1 = new Usuario();
		usuario1.setCpf("12345678910");
		usuario1.setLogin("teste1");
		usuario1.setSenha("teste1");
		usuario1.setPerfil(Perfil.PARTICIPANTE);
		usuario1.setNome("Administrador");

		Usuario usuario2 = new Usuario();
		usuario2.setCpf("12345678910");
		usuario2.setLogin("teste2");
		usuario2.setSenha("teste2");
		usuario2.setPerfil(Perfil.PARTICIPANTE);
		usuario2.setNome("Administrador");

		Usuario usuario3 = new Usuario();
		usuario3.setCpf("12345678910");
		usuario3.setLogin("teste3");
		usuario3.setSenha("teste3");
		usuario3.setPerfil(Perfil.PARTICIPANTE);
		usuario3.setNome("Administrador");

		genericUsuario.adicionar(usuario);
		genericUsuario.adicionar(usuario1);
		genericUsuario.adicionar(usuario2);
		genericUsuario.adicionar(usuario3);
	}

}
