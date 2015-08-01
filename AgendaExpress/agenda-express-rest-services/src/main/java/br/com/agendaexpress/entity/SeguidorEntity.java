package br.com.agendaexpress.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_seguidor database table.
 * 
 */
@Entity
@Table(name="tb_seguidor")
public class SeguidorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SeguidorEntityPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	public SeguidorEntity() {
	}

	public SeguidorEntityPK getId() {
		return this.id;
	}

	public void setId(SeguidorEntityPK id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}