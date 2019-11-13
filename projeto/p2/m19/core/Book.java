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

    protected int getId() {
        return super.getId();
    }

    protected int getPrice() {
        return super.getPrice();
    }

    protected int getNumberOfCopies() {
        return super.getNumberOfCopies();
    }

    protected int getAvailable() {
        return super.getAvailable();
    }

    protected String getTitle() {
        return super.getTitle();
    }

    protected Category getCategory() {
        return super.getCategory();
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
        if(super.search(searchQuery) || super.containsIgnoreCase(_author, searchQuery)){
            return true;
        }
        return false;
    }


}