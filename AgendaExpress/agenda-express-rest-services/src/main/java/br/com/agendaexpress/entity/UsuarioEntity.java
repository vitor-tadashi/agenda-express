package br.com.agendaexpress.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name = "tb_usuario")
@NamedQuery(name = "UsuarioEntity.findAll", query = "SELECT u FROM UsuarioEntity u")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUARIO")
	private Integer idUsuario;

	private String email;

	@Column(name = "IMAGEM_USUARIO")
	private byte[] imagemUsuario;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "SENHA")
	private String senha;

	@Column(name = "ATIVO")
	private String ativo;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ID_PESSOA")
	private PessoaEntity pessoa;

	public UsuarioEntity() {
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getImagemUsuario() {
		return imagemUsuario;
	}

	public void setImagemUsuario(byte[] imagemUsuario) {
		this.imagemUsuario = imagemUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public PessoaEntity getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaEntity pessoa) {
		this.pessoa = pessoa;
	}

}