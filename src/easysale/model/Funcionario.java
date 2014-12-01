package easysale.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Funcionario {
	private final StringProperty nome = new SimpleStringProperty();
	private final StringProperty pass = new SimpleStringProperty();
	private final IntegerProperty cpf = new SimpleIntegerProperty();
	private final IntegerProperty id = new SimpleIntegerProperty();
	private final StringProperty cargo = new SimpleStringProperty();
	
	public Funcionario() {
		
	}

	public String getNome() {
		return nome.get();
	}
	public void setNome(String value) {
		this.nome.setValue(value);
	}
	public StringProperty nomeProperty() {
		return nome;
	}
	
	public String getPass() {
		return pass.get();
	}
	public void setPass(String value) {
		this.pass.setValue(value);
	}
	public StringProperty passProperty() {
		return pass;
	}
	
	public String getCargo() {
		return cargo.get();
	}
	public void setCargo(String value) {
		this.cargo.set(value);
	}
	public StringProperty cargoProperty() {
		return cargo;
	}
	
	public int getId() {
		return id.get();
	}
	public void setId(int value) {
		this.id.set(value);
	}
	public IntegerProperty idProperty() {
		return id;
	}
	
	public int getCpf() {
		return cpf.get();
	}
	public void setCpf(int value) {
		this.cpf.set(value);
	}
	public IntegerProperty cpfProperty() {
		return cpf;
	}
	

}
