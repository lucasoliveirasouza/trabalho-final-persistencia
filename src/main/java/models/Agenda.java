package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Agenda {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	private Date data;
	private String hora;
	private Situacao situacao;
	private Date data_situacao;
	private String observacoes;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Vacina vacina;
	
	public Agenda() {
		
	}
	
	public Agenda(int id, Date data, String hora, Situacao situacao, Date data_situacao,
			String observacoes, Usuario usuario, Vacina vacina) {
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.situacao = situacao;
		this.data_situacao = data_situacao;
		this.observacoes = observacoes;
		this.usuario = usuario;
		this.vacina = vacina;
	}
	
	public Agenda(Date data, String hora, Situacao situacao, Date data_situacao,
			String observacoes, Usuario usuario, Vacina vacina) {
		
		this.data = data;
		this.hora = hora;
		this.situacao = situacao;
		this.data_situacao = data_situacao;
		this.observacoes = observacoes;
		this.usuario = usuario;
		this.vacina = vacina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Date getData_situacao() {
		return data_situacao;
	}

	public void setData_situacao(Date data_situacao) {
		this.data_situacao = data_situacao;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	
	
}
