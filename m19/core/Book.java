package m19.core;

import java.io.Serializable;

public class Book extends Work implements Serializable{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -5863226379882723342L;
	private String _author;
	private int _isbn;		//enunciado diz String; parser diz int

	protected Book(String titulo, String autor, int preco, Category categoria, int isbn, int exemplares){
		super(titulo, preco, categoria, exemplares);
		_author = autor;
		_isbn = isbn;
	}

	/**
	 * @return Book's author
	 */
	protected String getAuthor() {
		return _author;
	}

	/**
	 * @return Books ISBN
	 */
	protected int getIsbn() {
		return _isbn;
	}

	/**
	 * @return Book's Description
	 */
	@Override
	public String getDescription(){
		return super.getDescription("Livro", " - " + _author + " - " + _isbn);
	}

	/**
	 * Check's if the Book's author matches the searchQuery
	 * @param searchQuery
	 * @return boolean
	 */
	protected boolean search(String searchQuery){
		return super.search(searchQuery) || super.containsIgnoreCase(_author, searchQuery);
	}
}