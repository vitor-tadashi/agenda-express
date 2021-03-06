package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_avaliacao database table.
 * 
 */
@Entity
@Table(name="tb_avaliacao")
@NamedQuery(name="AvaliacaoEntity.findAll", query="SELECT a FROM AvaliacaoEntity a")
public class AvaliacaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AVALIACAO")
	private Integer idAvaliacao;

	@Column(name="QTD_ESTRELAS")
	private Integer qtdEstrelas;
	
	@Column(name="DESCRICAO")
	private String descricao;

	//bi-directional many-to-one association to PessoaEntity
	@ManyToOne
	@JoinColumn(name="ID_PESSOA")
	private PessoaEntity tbPessoa;

	public AvaliacaoEntity() {
	}

	public Integer getIdAvaliacao() {
		return this.idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Integer getQtdEstrelas() {
		return this.qtdEstrelas;
	}

	public void setQtdEstrelas(Integer qtdEstrelas) {
		this.qtdEstrelas = qtdEstrelas;
	}

	public PessoaEntity getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(PessoaEntity tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}