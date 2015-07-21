package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_perfil database table.
 * 
 */
@Entity
@Table(name="tb_perfil")
@NamedQuery(name="PerfilEntity.findAll", query="SELECT p FROM PerfilEntity p")
public class PerfilEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PERFIL")
	private int idPerfil;

	private String tipo;

	//bi-directional many-to-one association to FuncionalidadeEntity
	@OneToMany(mappedBy="tbPerfil")
	private List<FuncionalidadeEntity> tbFuncionalidades;

	public PerfilEntity() {
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<FuncionalidadeEntity> getTbFuncionalidades() {
		return this.tbFuncionalidades;
	}

	public void setTbFuncionalidades(List<FuncionalidadeEntity> tbFuncionalidades) {
		this.tbFuncionalidades = tbFuncionalidades;
	}

	public FuncionalidadeEntity addTbFuncionalidade(FuncionalidadeEntity tbFuncionalidade) {
		getTbFuncionalidades().add(tbFuncionalidade);
		tbFuncionalidade.setTbPerfil(this);

		return tbFuncionalidade;
	}

	public FuncionalidadeEntity removeTbFuncionalidade(FuncionalidadeEntity tbFuncionalidade) {
		getTbFuncionalidades().remove(tbFuncionalidade);
		tbFuncionalidade.setTbPerfil(null);

		return tbFuncionalidade;
	}

}