package m19.core;

import m19.app.works.*;
import Category;

public abstract class Work{  // Obra
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

    protected int getId() {
        return _id;
    }

    protected int getPrice() {
        return _price;
    }

    protected int getNumberOfCopies() {
        return _numberOfCopies;
    }

    protected int getAvailable() {
        return _available;
    }

    protected String getTitle() {
        return _title;
    }

    protected Category getCategory() {
        return _category;
    }

    protected void setPrice(int price) {
        _price = price;
    }

    protected void setNumberOfCopies(int number) {
        _numberOfCopies = number;
    }

    protected void setCategory(Category category) {
        _category = category;
    }


}