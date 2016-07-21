package main.java.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "PACIENTE" )
public class Paciente extends Entidade<Paciente> {

	private String nome;
	private Date dataNascimento;
	private Double altura;
	private Double peso;
	private Endereco endereco = new Endereco();;
	
	@Column(name="NOME", length=70)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASCIMENTO")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Column(name="ALTURA", precision = 3, scale = 2)
	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	@Column(name="PESO", precision = 5, scale = 2)
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Endereco getEndereco() {
		return endereco = endereco == null ? new Endereco() : endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
