package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_funcionalidade database table.
 * 
 */
@Entity
@Table(name="tb_funcionalidade")
@NamedQuery(name="FuncionalidadeEntity.findAll", query="SELECT f FROM FuncionalidadeEntity f")
public class FuncionalidadeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FUNCIONALIDADE")
	private Integer idFuncionalidade;

	private String descricao;

	//bi-directional many-to-one association to PerfilEntity
	@ManyToOne
	@JoinColumn(name="ID_PERFIL")
	private PerfilEntity tbPerfil;

	public FuncionalidadeEntity() {
	}

	public Integer getIdFuncionalidade() {
		return this.idFuncionalidade;
	}

	public void setIdFuncionalidade(Integer idFuncionalidade) {
		this.idFuncionalidade = idFuncionalidade;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PerfilEntity getTbPerfil() {
		return this.tbPerfil;
	}

	public void setTbPerfil(PerfilEntity tbPerfil) {
		this.tbPerfil = tbPerfil;
	}

}