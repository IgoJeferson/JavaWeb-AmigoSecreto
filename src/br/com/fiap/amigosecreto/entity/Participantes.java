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
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	@Column(name="ID")
	private int id;
	
	@JoinColumn(name="ID_REMETENTE", unique = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario remetente;
	
	@JoinColumn(name="ID_DESTINATARIO", unique = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario destinatario;
	
	public int getId() {
		return id;
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
