package m19.core;

import m19.app.works.*;

public abstract class Work{
    private int _id;
    private int _price;
    private int _numberOfCopies;
    private int _available;
    private String _title;
    private Category _category;

    protected Work(String titulo, int preco, Category categoria, int exemplares){
        _id=Library.getNextWId();
        _price = preco;
        _numberOfCopies = exemplares;
        _available = _numberOfCopies;
        _title = titulo;
        _category = categoria;
    }
	protected void requestWorkId(String tipo){
		//_id + " - " + _available + " de " + _numberOfCopies + " - " + tipo + " - " + _title + " - " + _price + " - " + _category
	}
}