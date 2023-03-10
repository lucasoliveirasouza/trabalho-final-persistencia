package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private String nome;
	private Date data_nascimento;
	private char sexo;
	private String logradouro;
	private int numero;
	private String setor;
	private String cidade;
	private String uf;
	
	@ManyToMany
	@JoinTable(
	 name = "usuarios_alergias",
	 joinColumns = @JoinColumn(name = "usuarios_id"),
	 inverseJoinColumns = @JoinColumn(name = "alergias_id"))
	private List<Alergia> alergias = new ArrayList<Alergia>();
	
	public Usuario() {}
	
	public Usuario(String nome, Date data_nascimento, char sexo, String logradouro, int numero, String setor,
			String cidade, String uf, List<Alergia> alergias) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.setor = setor;
		this.cidade = cidade;
		this.uf = uf;
		this.alergias = alergias;
	}

	public Usuario(int id, String nome, Date data_nascimento, char sexo, String logradouro, int numero, String setor,
			String cidade, String uf, List<Alergia> alergias) {
		this.id = id;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.setor = setor;
		this.cidade = cidade;
		this.uf = uf;
		this.alergias = alergias;
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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public List<Alergia> getAlergias(){
		return this.alergias;
	}
	
	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}
}
