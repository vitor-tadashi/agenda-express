package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_seguidor database table.
 * 
 */
@Entity
@Table(name="tb_seguidor")
@NamedQuery(name="SeguidorEntity.findAll", query="SELECT s FROM SeguidorEntity s")
public class SeguidorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PESSOA")
	private Integer idPessoa;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(name="ID_PESSOA_SEGUIDOR")
	private Integer idPessoaSeguidor;

	//bi-directional one-to-one association to PessoaEntity
	@OneToOne
	@JoinColumn(name="ID_PESSOA")
	private PessoaEntity tbPessoa1;

	//bi-directional one-to-one association to PessoaEntity
	@OneToOne
	@JoinColumn(name="ID_PESSOA")
	private PessoaEntity tbPessoa2;

	public SeguidorEntity() {
	}

	public Integer getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getIdPessoaSeguidor() {
		return this.idPessoaSeguidor;
	}

	public void setIdPessoaSeguidor(Integer idPessoaSeguidor) {
		this.idPessoaSeguidor = idPessoaSeguidor;
	}

	public PessoaEntity getTbPessoa1() {
		return this.tbPessoa1;
	}

	public void setTbPessoa1(PessoaEntity tbPessoa1) {
		this.tbPessoa1 = tbPessoa1;
	}

	public PessoaEntity getTbPessoa2() {
		return this.tbPessoa2;
	}

	public void setTbPessoa2(PessoaEntity tbPessoa2) {
		this.tbPessoa2 = tbPessoa2;
	}

}