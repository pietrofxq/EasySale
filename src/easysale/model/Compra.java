package easysale.model;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


import javafx.beans.property.*;

public class Compra {
	
	private IntegerProperty id = new SimpleIntegerProperty();
	private Cliente cliente;
	private IntegerProperty quantidade = new SimpleIntegerProperty();
	private StringProperty nomeProduto = new SimpleStringProperty();
	private DoubleProperty preco = new SimpleDoubleProperty();

	private ObjectProperty<LocalDateTime> dataCompra = new SimpleObjectProperty<LocalDateTime>();
	
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
	
	public Date getDataCompra() {
		Instant instant = dataCompra.get().atZone(ZoneId.systemDefault()).toInstant();
		Date res = Date.from(instant);
		return res;
	}
	
	public void setDataCompra(Date value) {
		Instant instant = Instant.ofEpochMilli(value.getTime());
		LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		dataCompra.set(res);
	}
	
	public ObjectProperty<LocalDateTime> dataCompraProperty() {
		return dataCompra;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	

}
