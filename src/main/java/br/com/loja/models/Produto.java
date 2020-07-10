package br.com.loja.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String marca;
	private String descricao;
	private String arquivoPath;
	@DateTimeFormat
	private Calendar dataValidade;
	@ElementCollection
	private List<Preco> precos;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Preco> getPrecos() {
		return precos;
	}
	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}
	public Calendar getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getArquivoPath() {
		return arquivoPath;
	}
	public void setArquivoPath(String arquivoPath) {
		this.arquivoPath = arquivoPath;
	}
	
	public BigDecimal precoPara(TipoPreco tipoPreco) {
		return precos.stream()
				.filter(preco -> preco.getTipoPreco().equals(tipoPreco))
				.findFirst().get().getPreco();
	}
	
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", marca=" + marca + ", descricao=" + descricao + "]";
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	


	
}
