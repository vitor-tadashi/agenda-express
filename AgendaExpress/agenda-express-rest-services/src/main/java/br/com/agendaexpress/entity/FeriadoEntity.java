package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_feriado database table.
 * 
 */
@Entity
@Table(name="tb_feriado")
@NamedQuery(name="FeriadoEntity.findAll", query="SELECT f FROM FeriadoEntity f")
public class FeriadoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FERIADO")
	private Integer idFeriado;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String descricao;

	public FeriadoEntity() {
	}

	public Integer getIdFeriado() {
		return this.idFeriado;
	}

	public void setIdFeriado(Integer idFeriado) {
		this.idFeriado = idFeriado;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}