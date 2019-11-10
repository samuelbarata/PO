package m19.core;

public enum Category {
	FICTION("Ficção"), SCITECH("Técnica e Científica"), REFERENCE("Referência");

	//TODO: preceber esta cena

	private String _categoria;


	private Category(String categoria){		//entao isto acrescenta uma categoria no enum?
		_categoria=categoria;
	}

	public String toString(){
		return _categoria;
	}

}   
