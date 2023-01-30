package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Alergia {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String nome;
	
	@ManyToMany
	@JoinTable(
	 name = "alergias_usuarios",
	 joinColumns = @JoinColumn(name = "alergia_id"),
	 inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
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
