package m19.core;

public class Book extends Work{
	private String _author;
	private int _isbn;      //enunciado diz String; parser diz int

	protected Book(String titulo, String autor, int preco, Category categoria, int isbn, int exemplares){
		super(titulo, preco, categoria, exemplares);
		_author = autor;
		_isbn = isbn;
	}


	protected String getAuthor() {
		return _author;
	}

	protected int getIsbn() {
		return _isbn;
	}

    /**
     * 
     * @return Book's Description
     */
    @Override
    public String getDescription(){
        return super.getDescription("Livro",  " - " + _author + " - " + _isbn);
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