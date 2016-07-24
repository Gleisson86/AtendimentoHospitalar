package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "HOSPITAL" )
public class Hospital extends Entidade<Hospital> {

	private PessoaJuridica pessoaJuridica = new PessoaJuridica();
	private List<Atendimento> atendimentos;
	
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica == null ? new PessoaJuridica() : pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hospital", cascade = CascadeType.REMOVE, targetEntity=Atendimento.class)
	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}
}
