package br.com.caelum.tarefas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Jogador {

	@Id
	@GeneratedValue
	private Long id;
	private Long idCampeonato;
	@NotEmpty(message = "Nome nao pode ser vazio")
	@Size(min = 5)
	private String nome;
	private int jogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int gp;
	private int gc;
	private int sg;
	private int pontos;

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
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getJogos() {
		return jogos;
	}

	public void setJogos(int jogos) {
		this.jogos = jogos;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getGp() {
		return gp;
	}

	public void setGp(int gp) {
		this.gp = gp;
	}

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}

	public int getSg() {
		return sg;
	}

	public void setSg(int sg) {
		this.sg = sg;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

}
