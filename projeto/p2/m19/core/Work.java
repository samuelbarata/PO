package m19.core;

public abstract class Work{  // Obra
    private final int _id;
    private final int _price;
    private final int _numberOfCopies;
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

    /**
     * 
     * @return work's id
     */
    protected int getId() {
        return _id;
    }

    /**
     * 
     * @return work's price
     */
    protected int getPrice() {
        return _price;
    }

    /**
     * 
     * @return total number of copies
     */
    protected int getNumberOfCopies() {
        return _numberOfCopies;
    }

    /**
     * 
     * @return number of available copies
     */
    protected int getAvailable() {
        return _available;
    }

    /**
     * 
     * @return Work's title
     */
    protected String getTitle() {
        return _title;
    }

    /**
     * 
     * @return Work's category
     */
    protected Category getCategory() {
        return _category;
    }

    /**
     * Set Work's category to
     * @param category
     */
    protected void setCategory(Category category) {
        _category = category;
    }

    public String getDescritpion(){
        //FIXME
    }

}