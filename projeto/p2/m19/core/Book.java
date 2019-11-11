package m19.core;


public class Book extends Work{
	private String _author;
	private int _isbn;

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
    
/*
    protected void setPrice(int price) {
        _price = price;
    }

    protected void setNumberOfCopies(int number) {
        _numberOfCopies = number;
    }

    protected void setCategory(Category category) {
        _category = category;
    }
*/


}