package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "SINTOMA" ) 
public class Sintoma extends Entidade<Sintoma> {

	private String nome;
	private Integer frequencia;
	private Integer intensidade;
	private String local;
	private Atendimento<?> atendimento;
	
	@Column(name="NOME", length=70)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Opcional - Frequência por segundo
	@Column(name="FREQUENCIA", length=3)
	public Integer getFrequencia() {
		return frequencia;
	}
	
	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}
	
	//Intensidade de 1 a 9
	@Column(name="INTENSIDADE", length=1)
	public Integer getIntensidade() {
		return intensidade;
	}
	
	public void setIntensidade(Integer intensidade) {
		this.intensidade = intensidade;
	}
	
	@Column(name="LOCAL", length=50)
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}

	@ManyToOne
	@JoinColumn( name = "ATENDIMENTO_ID" )
	public Atendimento<?> getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento<?> atendimento) {
		this.atendimento = atendimento;
	}
}
