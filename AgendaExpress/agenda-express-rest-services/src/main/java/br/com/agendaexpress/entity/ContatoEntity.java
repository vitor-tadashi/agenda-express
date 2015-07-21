package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_contato database table.
 * 
 */
@Entity
@Table(name="tb_contato")
@NamedQuery(name="ContatoEntity.findAll", query="SELECT c FROM ContatoEntity c")
public class ContatoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CONTATO")
	private int idContato;

	private String email;

	@Column(name="ID_PESSOA")
	private int idPessoa;

	private String telefone;

	@Column(name="TELEFONE_CELULAR")
	private String telefoneCelular;

	public ContatoEntity() {
	}

	public int getIdContato() {
		return this.idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneCelular() {
		return this.telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

}