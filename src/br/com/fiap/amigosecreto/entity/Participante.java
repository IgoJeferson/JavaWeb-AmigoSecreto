package br.com.fiap.amigosecreto.entity;

public class Participante {
	
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
