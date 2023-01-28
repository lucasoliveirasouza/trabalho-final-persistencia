package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alergia {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String nome;
	
	public Alergia() {
		
	}
	
	public Alergia(String nome) {
		this.nome = nome;
	}
	
	public Alergia(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
