package br.com.agendaexpress.beans;

public class PessoaBean {

	private Integer idPessoa;

	private String idEndereco;

	private UsuarioBean usuarioBean;

	private PessoaFisicaBean pessoaFisica;

	private PessoaJuridicaBean pessoaJuridica;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(String idEndereco) {
		this.idEndereco = idEndereco;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public PessoaFisicaBean getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisicaBean pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridicaBean getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridicaBean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	/*
	 * private List<AgendaEntity> tbAgendas;
	 * 
	 * private List<AvaliacaoEntity> tbAvaliacaos;
	 * 
	 * private PessoaFisicaEntity tbPessoaFisica;
	 * 
	 * private PessoaJuridicaEntity tbPessoaJuridica;
	 * 
	 * private List<PessoaJuridicaEntity> tbPessoaJuridicas;
	 * 
	 * private List<RecomendacaoEntity> tbRecomendacaos;
	 */

}
