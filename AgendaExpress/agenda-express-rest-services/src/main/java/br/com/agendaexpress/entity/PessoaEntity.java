package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_pessoa database table.
 * 
 */
@Entity
@Table(name="tb_pessoa")
@NamedQuery(name="PessoaEntity.findAll", query="SELECT p FROM PessoaEntity p")
public class PessoaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PESSOA")
	private Integer idPessoa;

	@Column(name="ID_ENDERECO")
	private String idEndereco;

	//bi-directional many-to-one association to AgendaEntity
	@OneToMany(mappedBy="tbPessoa")
	private List<AgendaEntity> tbAgendas;

	//bi-directional many-to-one association to AvaliacaoEntity
	@OneToMany(mappedBy="tbPessoa")
	private List<AvaliacaoEntity> tbAvaliacaos;

	//bi-directional one-to-one association to PessoaFisicaEntity
	@OneToOne(mappedBy="tbPessoa")
	private PessoaFisicaEntity tbPessoaFisica;

	//bi-directional one-to-one association to PessoaJuridicaEntity
	@OneToOne(mappedBy="tbPessoa")
	private PessoaJuridicaEntity tbPessoaJuridica;

	//bi-directional many-to-many association to PessoaJuridicaEntity
	@ManyToMany(mappedBy="tbPessoas")
	private List<PessoaJuridicaEntity> tbPessoaJuridicas;

	//bi-directional many-to-one association to RecomendacaoEntity
	@OneToMany(mappedBy="tbPessoa")
	private List<RecomendacaoEntity> tbRecomendacaos;

	//bi-directional one-to-one association to SeguidorEntity
	@OneToOne(mappedBy="tbPessoa1")
	private SeguidorEntity tbSeguidor1;

	//bi-directional one-to-one association to SeguidorEntity
	@OneToOne(mappedBy="tbPessoa2")
	private SeguidorEntity tbSeguidor2;

	public PessoaEntity() {
	}

	public Integer getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}

	public List<AgendaEntity> getTbAgendas() {
		return this.tbAgendas;
	}

	public void setTbAgendas(List<AgendaEntity> tbAgendas) {
		this.tbAgendas = tbAgendas;
	}

	public AgendaEntity addTbAgenda(AgendaEntity tbAgenda) {
		getTbAgendas().add(tbAgenda);
		tbAgenda.setTbPessoa(this);

		return tbAgenda;
	}

	public AgendaEntity removeTbAgenda(AgendaEntity tbAgenda) {
		getTbAgendas().remove(tbAgenda);
		tbAgenda.setTbPessoa(null);

		return tbAgenda;
	}

	public List<AvaliacaoEntity> getTbAvaliacaos() {
		return this.tbAvaliacaos;
	}

	public void setTbAvaliacaos(List<AvaliacaoEntity> tbAvaliacaos) {
		this.tbAvaliacaos = tbAvaliacaos;
	}

	public AvaliacaoEntity addTbAvaliacao(AvaliacaoEntity tbAvaliacao) {
		getTbAvaliacaos().add(tbAvaliacao);
		tbAvaliacao.setTbPessoa(this);

		return tbAvaliacao;
	}

	public AvaliacaoEntity removeTbAvaliacao(AvaliacaoEntity tbAvaliacao) {
		getTbAvaliacaos().remove(tbAvaliacao);
		tbAvaliacao.setTbPessoa(null);

		return tbAvaliacao;
	}

	public PessoaFisicaEntity getTbPessoaFisica() {
		return this.tbPessoaFisica;
	}

	public void setTbPessoaFisica(PessoaFisicaEntity tbPessoaFisica) {
		this.tbPessoaFisica = tbPessoaFisica;
	}

	public PessoaJuridicaEntity getTbPessoaJuridica() {
		return this.tbPessoaJuridica;
	}

	public void setTbPessoaJuridica(PessoaJuridicaEntity tbPessoaJuridica) {
		this.tbPessoaJuridica = tbPessoaJuridica;
	}

	public List<PessoaJuridicaEntity> getTbPessoaJuridicas() {
		return this.tbPessoaJuridicas;
	}

	public void setTbPessoaJuridicas(List<PessoaJuridicaEntity> tbPessoaJuridicas) {
		this.tbPessoaJuridicas = tbPessoaJuridicas;
	}

	public List<RecomendacaoEntity> getTbRecomendacaos() {
		return this.tbRecomendacaos;
	}

	public void setTbRecomendacaos(List<RecomendacaoEntity> tbRecomendacaos) {
		this.tbRecomendacaos = tbRecomendacaos;
	}

	public RecomendacaoEntity addTbRecomendacao(RecomendacaoEntity tbRecomendacao) {
		getTbRecomendacaos().add(tbRecomendacao);
		tbRecomendacao.setTbPessoa(this);

		return tbRecomendacao;
	}

	public RecomendacaoEntity removeTbRecomendacao(RecomendacaoEntity tbRecomendacao) {
		getTbRecomendacaos().remove(tbRecomendacao);
		tbRecomendacao.setTbPessoa(null);

		return tbRecomendacao;
	}

	public SeguidorEntity getTbSeguidor1() {
		return this.tbSeguidor1;
	}

	public void setTbSeguidor1(SeguidorEntity tbSeguidor1) {
		this.tbSeguidor1 = tbSeguidor1;
	}

	public SeguidorEntity getTbSeguidor2() {
		return this.tbSeguidor2;
	}

	public void setTbSeguidor2(SeguidorEntity tbSeguidor2) {
		this.tbSeguidor2 = tbSeguidor2;
	}

}