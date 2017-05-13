package br.com.fiap.amigosecreto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SORTEIO")
public class Participantes implements Serializable {
	
	@Id @GeneratedValue
	@Column(name="ID")
	private int id;
	
	@JoinColumn(name="ID_REMETENTE")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario remetente;
	
	@JoinColumn(name="ID_DESTINATARIO")
	@ManyToOne(fetch = FetchType.LAZY)
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
