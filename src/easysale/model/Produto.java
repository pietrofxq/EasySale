package easysale.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.*;

public class Produto {
	
	private final IntegerProperty id = new SimpleIntegerProperty();
	private final StringProperty nome = new SimpleStringProperty();
	private final StringProperty descricao = new SimpleStringProperty();
	private final IntegerProperty quantidade = new SimpleIntegerProperty();
	private final IntegerProperty codigo = new SimpleIntegerProperty();
	
	public Produto() {
		
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

	public String getDescricao() {
		return descricao.get();
	}
	
	public StringProperty descricaoProperty() {
		return descricao;
	}

	public void setDescricao(String value) {
		descricao.set(value);
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
	
	

}
