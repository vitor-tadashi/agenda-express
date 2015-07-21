package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_pessoa_fisica database table.
 * 
 */
@Entity
@Table(name="tb_pessoa_fisica")
@NamedQuery(name="PessoaFisicaEntity.findAll", query="SELECT p FROM PessoaFisicaEntity p")
public class PessoaFisicaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PESSOA")
	private int idPessoa;

	private String cpf;

	private String nome;

	//bi-directional one-to-one association to PessoaEntity
	@OneToOne
	@JoinColumn(name="ID_PESSOA")
	private PessoaEntity tbPessoa;

	public PessoaFisicaEntity() {
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PessoaEntity getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(PessoaEntity tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

}