package br.com.agendaexpress.beans;

public class UsuarioBean {
	private Integer idUsuario;

	private String email;

	private byte[] imagemUsuario;

	private String login;

	private String senha;

	private PessoaBean pessoaBean;

	public UsuarioBean() {

	}

	public UsuarioBean(Integer idUsuario, String email, byte[] imagemUsuario,
			String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.imagemUsuario = imagemUsuario;
		this.login = login;
		this.senha = senha;
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

	public PessoaBean getPessoaBean() {
		return pessoaBean;
	}

	public void setPessoaBean(PessoaBean pessoaBean) {
		this.pessoaBean = pessoaBean;
	}

}
