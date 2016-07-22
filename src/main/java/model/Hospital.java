package main.java.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "HOSPITAL" )
public class Hospital extends Entidade<Hospital> {

	private String nome;
	private Endereco endereco = new Endereco();
	private List<Atendimento<?>> atendimentos;
	
	@Column(name="NOME", length=70)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco = endereco == null ? new Endereco() : endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hospital", cascade = CascadeType.ALL, targetEntity=Atendimento.class)
	public List<Atendimento<?>> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento<?>> atendimentos) {
		this.atendimentos = atendimentos;
	}
}
