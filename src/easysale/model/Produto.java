package easysale.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.*;

public class Produto {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty nome = new SimpleStringProperty();
	private IntegerProperty quantidade = new SimpleIntegerProperty();
	private IntegerProperty codigo = new SimpleIntegerProperty();
	private DoubleProperty preco = new SimpleDoubleProperty();
	
	public Produto() {
		
	}
	
	public Produto(String nome, int qnt, int cod, double preco) {
		this.setNome(nome);
		this.setQuantidade(qnt);
		this.setCodigo(cod);
		this.setPreco(preco);
	}
	

	public int getId() {
		return id.get();
	}
	
	public IntegerProperty idProperty() {
		return id;
	}

	public void setId(int value) {
		id.set(value);
	}

	public String getNome() {
		return nome.get();
	}
	
	public StringProperty nomeProperty() {
		return nome;
	}

	public void setNome(String value) {
		nome.set(value);
	}

	public int getQuantidade() {
		return quantidade.get();
	}
	
	public IntegerProperty quantidadeProperty() {
		return quantidade;
	}

	public void setQuantidade(int value) {
		quantidade.set(value);
	}
	
	public int getCodigo() {
		return codigo.get();
	}
	
	public void setCodigo(int value) {
		codigo.set(value);
	}
	
	public IntegerProperty codigoProperty() {
		return codigo;
	}
	
	public void setPreco(double value) {
		preco.set(value);
	}


	public double getPreco() {
		return preco.get();
	}
	
	public DoubleProperty precoProperty() {
		return preco;
	}
	
	

}
