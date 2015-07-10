package br.com.agendaexpress.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Heroe {
	private Long id;
	private String nome;

	public Heroe() {
	}

	public Heroe(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
