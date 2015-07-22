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
	private Integer idContato;

	private String email;

	@Column(name="ID_PESSOA")
	private Integer idPessoa;

	private String telefone;

	@Column(name="TELEFONE_CELULAR")
	private String telefoneCelular;

	public ContatoEntity() {
	}

	public Integer getIdContato() {
		return this.idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
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