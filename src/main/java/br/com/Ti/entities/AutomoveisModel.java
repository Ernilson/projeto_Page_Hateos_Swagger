package br.com.Ti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name="tab_automoveis")
public class AutomoveisModel extends RepresentationModel<AutomoveisModel> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int quantidade;
	private String placa;
	private Double preco;
	private int chaci;
	
	public AutomoveisModel() {
		// TODO Auto-generated constructor stub
	}

	public AutomoveisModel(Long id, String nome, int quantidade, String placa, Double preco, int chaci) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.placa = placa;
		this.preco = preco;
		this.chaci = chaci;
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getquantidade() {
		return quantidade;
	}

	public void setquantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getChaci() {
		return chaci;
	}

	public void setChaci(int chaci) {
		this.chaci = chaci;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutomoveisModel other = (AutomoveisModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AutomoveisModel [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", placa=" + placa
				+ ", preco=" + preco + ", chaci=" + chaci + "]";
	}
	
}
