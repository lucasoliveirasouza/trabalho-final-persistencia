package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vacina {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String titulo;
	private String descricao;
	private int doses;
	private int periodicidade;
	private int intervalo;
	
	public Vacina() {}
	
	public Vacina(String titulo, String descricao, int doses, int periodicidade, int intervalo) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.doses = doses;
		this.periodicidade = periodicidade;
		this.intervalo = intervalo;
	}
	
	public Vacina(int id,String titulo, String descricao, int doses, int periodicidade, int intervalo) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.doses = doses;
		this.periodicidade = periodicidade;
		this.intervalo = intervalo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDoses() {
		return doses;
	}

	public void setDoses(int doses) {
		this.doses = doses;
	}

	public int getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(int periodicidade) {
		this.periodicidade = periodicidade;
	}

	public int getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	
}
