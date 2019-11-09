package m19.core;

public class Book extends Work{
    private String _author;
    private int _isbn;

    public Book(String titulo, String autor, int preco, Category categoria, int isbn, int exemplares){
        super(titulo, preco, categoria, exemplares);
        _author = autor;
        _isbn = isbn;
    }

    public void requestWorkId(){
        super.requestWorkId("Livro");
        System.out.println(" - " + _author + " - " + _isbn);
    }
}