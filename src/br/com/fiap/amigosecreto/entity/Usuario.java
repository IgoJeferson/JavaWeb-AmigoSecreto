package br.com.fiap.amigosecreto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.amigosecreto.enums.Perfil;

@Entity
@Table(name="USUARIOS")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CPF", nullable=false, length=11)
	private String cpf;
	
	@Column(name="NOME", nullable=false, length=45)
	private String nome;
	
	@Column(name="LOGIN", nullable=false, length=100)
	private String login;

	@Column(name="SENHA", nullable=false, length=20)
	private String senha;
	
	@Column(name="PERFIL")
	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (cpf != null)
			builder.append("cpf=").append(cpf).append(", ");
		if (nome != null)
			builder.append("nome=").append(nome).append(", ");
		if (senha != null)
			builder.append("senha=").append(senha).append(", ");
		if (perfil != null)
			builder.append("perfil=").append(perfil);
		builder.append("]");
		return builder.toString();
	}
	
}
