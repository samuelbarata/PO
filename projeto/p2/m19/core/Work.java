package m19.core;

public abstract class Work{
    private static int _nextId=0;
    private int _id;
    private int _price;
    private int _numberOfCopies;
    private int _available;
    private String _title;
    private Category _category;

    public Work(String titulo, int preco, Category categoria, int exemplares){
        _id=_nextId++;
        _price = preco;
        _numberOfCopies = exemplares;
        _available = _numberOfCopies;
        _title = titulo;
        _category = categoria;
    }
    public void requestWorkId(String tipo){
        System.out.print(_id + " - " + _available + " de " + _numberOfCopies + " - " + tipo + " - " + _title + " - " + _price + " - " + _category.toString());
    }
}