package easysale.model;


import java.time.LocalDateTime;

import javafx.beans.property.*;

public class Compra {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private Produto produto;
	private IntegerProperty quantidade = new SimpleIntegerProperty();
	private StringProperty nomeProduto = new SimpleStringProperty();
	private DoubleProperty preco = new SimpleDoubleProperty();
	private ObjectProperty<LocalDateTime> dataCompra;
	
	public Compra() {
		
	}
	
	
	
	public int getId() {
		return id.get();
	}
	
	public void setId(int value) {
		id.set(value);
	}
	
	public String getNomeProduto() {
		return nomeProduto.get();
	}
	
	public void setNomeProduto(String value) {
		nomeProduto.set(value);
	}
	
	public StringProperty nomeProdutoProperty() {
		return nomeProduto;
	}
	
	public int getQuantidade() {
		return quantidade.get();
	}
	
	public void setQuantidade(int value) {
		quantidade.set(value);
	}
	
	public IntegerProperty quantidadeProperty() {
		return quantidade;
	}
	
	public double getPreco() {
		return preco.get();
	}
	
	public void setPreco(double value) {
		preco.set(value);
	}
	
	public DoubleProperty precoProperty() {
		return preco;
	}
	
	public LocalDateTime getDataCompra() {
		return dataCompra.get();
	}
	
	public void setDataCompra(LocalDateTime value) {
		dataCompra.set(value);
	}
	
	public ObjectProperty<LocalDateTime> dataCompraProperty() {
		return dataCompra;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	

}
