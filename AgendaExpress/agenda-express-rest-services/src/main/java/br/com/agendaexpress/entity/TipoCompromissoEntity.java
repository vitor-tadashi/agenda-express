package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_tipo_compromisso database table.
 * 
 */
@Entity
@Table(name="tb_tipo_compromisso")
@NamedQuery(name="TipoCompromissoEntity.findAll", query="SELECT t FROM TipoCompromissoEntity t")
public class TipoCompromissoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TIPO_COMPROMISSO")
	private int idTipoCompromisso;

	private String descricao;

	public TipoCompromissoEntity() {
	}

	public int getIdTipoCompromisso() {
		return this.idTipoCompromisso;
	}

	public void setIdTipoCompromisso(int idTipoCompromisso) {
		this.idTipoCompromisso = idTipoCompromisso;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}