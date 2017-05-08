package br.com.fiap.amigosecreto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PARTICIPANTES")
public class Participante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	private Usuario usuario;
	private Participante amigoSecreto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Participante getAmigoSecreto() {
		return amigoSecreto;
	}
	public void setAmigoSecreto(Participante amigoSecreto) {
		this.amigoSecreto = amigoSecreto;
	}

}
