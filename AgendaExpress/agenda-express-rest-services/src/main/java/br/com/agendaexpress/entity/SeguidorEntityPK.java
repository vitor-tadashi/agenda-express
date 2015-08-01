package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_seguidor database table.
 * 
 */
@Embeddable
public class SeguidorEntityPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PESSOA", insertable=false, updatable=false)
	private int idPessoa;

	@Column(name="ID_PESSOA_SEGUIDOR")
	private int idPessoaSeguidor;

	public SeguidorEntityPK() {
	}
	public int getIdPessoa() {
		return this.idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public int getIdPessoaSeguidor() {
		return this.idPessoaSeguidor;
	}
	public void setIdPessoaSeguidor(int idPessoaSeguidor) {
		this.idPessoaSeguidor = idPessoaSeguidor;
	}
	
	public SeguidorEntityPK(int idPessoa, int idPessoaSeguidor) {
		super();
		this.idPessoa = idPessoa;
		this.idPessoaSeguidor = idPessoaSeguidor;
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SeguidorEntityPK)) {
			return false;
		}
		SeguidorEntityPK castOther = (SeguidorEntityPK)other;
		return 
			(this.idPessoa == castOther.idPessoa)
			&& (this.idPessoaSeguidor == castOther.idPessoaSeguidor);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPessoa;
		hash = hash * prime + this.idPessoaSeguidor;
		
		return hash;
	}
}