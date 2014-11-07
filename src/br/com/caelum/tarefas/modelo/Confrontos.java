package br.com.caelum.tarefas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Confrontos {

	@Id
	@GeneratedValue
	private Long id;
	private Long idCampeonato;
	@NotEmpty(message = "Nome nao pode ser vazio")
	@Size(min = 1)
	private String JogadorCasa;
	private String JogadorFora;
	private long GolsCasa;
	private long GolsFora;
	private boolean finalizado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCampeonato() {
		return idCampeonato;
	}

	public void setIdCampeonato(Long idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public String getJogadorCasa() {
		return JogadorCasa;
	}

	public void setJogadorCasa(String jogadorCasa) {
		JogadorCasa = jogadorCasa;
	}

	public String getJogadorFora() {
		return JogadorFora;
	}

	public void setJogadorFora(String jogadorFora) {
		JogadorFora = jogadorFora;
	}

	public long getGolsCasa() {
		return GolsCasa;
	}

	public void setGolsCasa(long golsCasa) {
		GolsCasa = golsCasa;
	}

	public long getGolsFora() {
		return GolsFora;
	}

	public void setGolsFora(long golsFora) {
		GolsFora = golsFora;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

}
