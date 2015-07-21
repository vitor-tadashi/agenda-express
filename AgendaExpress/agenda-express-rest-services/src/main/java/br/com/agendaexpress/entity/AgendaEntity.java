package br.com.agendaexpress.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_agenda database table.
 * 
 */
@Entity
@Table(name="tb_agenda")
@NamedQuery(name="AgendaEntity.findAll", query="SELECT a FROM AgendaEntity a")
public class AgendaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AGENDA")
	private int idAgenda;

	//bi-directional many-to-one association to PessoaEntity
	@ManyToOne
	@JoinColumn(name="ID_PESSOA")
	private PessoaEntity tbPessoa;

	public AgendaEntity() {
	}

	public int getIdAgenda() {
		return this.idAgenda;
	}

	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}

	public PessoaEntity getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(PessoaEntity tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

}