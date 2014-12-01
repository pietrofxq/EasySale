package easysale.model;

import java.util.*;

import javafx.beans.property.*;

public class Cliente {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	private Set<Compra> compras = new HashSet<>();
	
	public Cliente() {
		
	}
	
	public void addCompra(Compra compra) {
		compras.add(compra);
	}
	
	public void removeCompra(Compra compra) {
		compras.remove(compra);
	}
	
	public int getId() {
		return id.get();
	}
	public void setId(int value) {
		id.set(value);
	}
	public String getNome() {
		return nome.get();
	}
	public void setNome(String value) {
		nome.set(value);
	}
	
	public StringProperty nomeProperty() {
		return nome;
	}
	
	public String getCpf() {
		return cpf.get();
	}
	
	public void setCpf(String value) {
		cpf.set(value);
	}
	
	public StringProperty cpfProperty() {
		return cpf;
	}
	
	public Set<Compra> getCompras() {
		return compras;
	}
	
	public void setCompras(List<Compra> value) {
		compras.addAll(value);
	}

}
