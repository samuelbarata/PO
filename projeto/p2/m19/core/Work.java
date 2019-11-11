package m19.core;

public abstract class Work implements Comparable<Work>{  // Obra
    private int _id;
    private final int _price;
    private final int _numberOfCopies;
    private int _available;
    private String _title;
    private Category _category;

    public Work(String titulo, int preco, Category categoria, int exemplares){
        _price = preco;
        _numberOfCopies = exemplares;
        _available = _numberOfCopies;
        _title = titulo;
        _category = categoria;
        _id=-1;
    }

    /**
     * 
     * @return work's id
     */
    protected int getId() {
        return _id;
    }

    protected void setId(int id){
        _id = id;
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

    /**
     * 
     * @return Work's Description
     */
    public abstract String getDescription();

    /**
     * 
     * @return Work's Description
     */
    public String getDescription(String type, String addInfo){
        return _id + " - " + _available + " de " + _numberOfCopies + " - " + type + " - " + _title + " - " + _price + " - " + _category + addInfo;
    }

    /**
     * Compares if 2 works have the same title
     * @param work
     * @return
     */
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Work)) return false;
        Work otherWork = (Work)other;
        return this.getTitle().equals(otherWork.getTitle());
    }

    /**
     * Compares Work a to Work b by ID
     */
    @Override
    public int compareTo(Work b){
        return Integer.compare(this.getId(), b.getId());
    } 
}