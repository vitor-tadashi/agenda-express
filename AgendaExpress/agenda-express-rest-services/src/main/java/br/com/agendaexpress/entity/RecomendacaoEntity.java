package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_recomendacao database table.
 * 
 */
@Entity
@Table(name="tb_recomendacao")
@NamedQuery(name="RecomendacaoEntity.findAll", query="SELECT r FROM RecomendacaoEntity r")
public class RecomendacaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_RECOMENDACAO")
	private int idRecomendacao;

	//bi-directional many-to-one association to PessoaEntity
	@ManyToOne
	@JoinColumn(name="ID_PESSOA")
	private PessoaEntity tbPessoa;

	public RecomendacaoEntity() {
	}

	public int getIdRecomendacao() {
		return this.idRecomendacao;
	}

	public void setIdRecomendacao(int idRecomendacao) {
		this.idRecomendacao = idRecomendacao;
	}

	public PessoaEntity getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(PessoaEntity tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

}