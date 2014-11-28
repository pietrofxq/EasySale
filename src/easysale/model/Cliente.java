package easysale.model;

import java.util.*;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cliente {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty cpf = new SimpleStringProperty();
	ObservableList<Compra> observableCompras = FXCollections.observableArrayList();
	private ListProperty<Compra> compras = new SimpleListProperty<Compra>(observableCompras);
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf, List<Compra> compras) {
		this.setNome(nome);
		this.setCpf(cpf);
	}
	
	public void addCompra(Compra compra) {
		observableCompras.add(compra);
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
	
	public List<Compra> getCompras() {
		return compras.get();
	}
	
	public void setCompras(List<Compra> value) {
		observableCompras.setAll(value);
		compras.set(observableCompras);
	}
	
	public ListProperty<Compra> comprasProperty() {
		return compras;
	}
	
	

}
