package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;

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
	private int idUsuario;

	private String email;

	@Column(name = "IMAGEM_USUARIO")
	private byte[] imagemUsuario;

	private String login;

	private String senha;

	public UsuarioEntity() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return this.email;
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
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}