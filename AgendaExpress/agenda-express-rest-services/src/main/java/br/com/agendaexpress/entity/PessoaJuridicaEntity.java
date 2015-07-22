package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_pessoa_juridica database table.
 * 
 */
@Entity
@Table(name="tb_pessoa_juridica")
@NamedQuery(name="PessoaJuridicaEntity.findAll", query="SELECT p FROM PessoaJuridicaEntity p")
public class PessoaJuridicaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PESSOA")
	private Integer idPessoa;

	private String cnpj;

	@Column(name="RAZAO_SOCIAL")
	private String razaoSocial;

	//bi-directional one-to-one association to PessoaEntity
	@OneToOne
	@JoinColumn(name="ID_PESSOA")
	private PessoaEntity tbPessoa;

	//bi-directional many-to-many association to PessoaEntity
	@ManyToMany
	@JoinTable(
		name="tb_pessoa_juridica_x_pessoa"
		, joinColumns={
			@JoinColumn(name="ID_PESSOA_JURIDICA")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_PESSOA")
			}
		)
	private List<PessoaEntity> tbPessoas;

	public PessoaJuridicaEntity() {
	}

	public Integer getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public PessoaEntity getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(PessoaEntity tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

	public List<PessoaEntity> getTbPessoas() {
		return this.tbPessoas;
	}

	public void setTbPessoas(List<PessoaEntity> tbPessoas) {
		this.tbPessoas = tbPessoas;
	}

}