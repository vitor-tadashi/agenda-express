package br.com.agendaexpress.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the tb_pessoa database table.
 * 
 */
@Entity
@Table(name = "tb_pessoa")
@NamedQuery(name = "PessoaEntity.findAll", query = "SELECT p FROM PessoaEntity p")
public class PessoaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PESSOA")
	private Integer idPessoa;

	@Column(name = "ID_ENDERECO")
	private String idEndereco;

	@OneToOne(mappedBy = "pessoa")
	private UsuarioEntity usuario;

	@OneToMany(mappedBy = "tbPessoa")
	private List<AvaliacaoEntity> avaliacaos;

	public PessoaEntity() {
	}

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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public List<AvaliacaoEntity> getAvaliacaos() {
		return avaliacaos;
	}

	public void setAvaliacaos(List<AvaliacaoEntity> avaliacaos) {
		this.avaliacaos = avaliacaos;
	}

}