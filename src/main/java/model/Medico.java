package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "MEDICO" )
public class Medico extends Entidade<Medico> {

	private PessoaFisica pessoaFisica = new PessoaFisica();
	private Integer crm;
	private String especialidade;

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica = pessoaFisica == null ? new PessoaFisica() : pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	@Column(name="CRM", length=8)
	public Integer getCrm() {
		return crm;
	}

	public void setCrm(Integer crm) {
		this.crm = crm;
	}
	
	@Column(name="ESPECIALIDADE", length=70)
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
