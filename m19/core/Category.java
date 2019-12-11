package m19.core;

import java.io.Serializable;

public enum Category implements Serializable{
	FICTION("Ficção"), SCITECH("Técnica e Científica"), REFERENCE("Referência");
	
	private String _categoria;

	private Category(String categoria){
		_categoria=categoria;
	}

	public String toString(){
		return _categoria;
	}

}
