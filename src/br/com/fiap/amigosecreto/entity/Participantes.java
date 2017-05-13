package br.com.fiap.amigosecreto.entity;

public class Participantes {
	private int id;
	private Usuario remetente;
	private Usuario destinatario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}
}
