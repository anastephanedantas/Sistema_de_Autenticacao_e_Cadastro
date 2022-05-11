package projeto.ifsol.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produtos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	private long id;
	private String produto;
	private String nomeProdutor;
	private String dataReserva;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getNomeProdutor() {
		return nomeProdutor;
	}
	public void setNomeProdutor(String nomeProdutor) {
		this.nomeProdutor = nomeProdutor;
	}
	public String getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}
	
	
	
}
