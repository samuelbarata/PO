package m19.core;


public class Dvd extends Work{
	private String _director;
	private int _igac;

	protected Dvd(String titulo, String realizador, int preco, Category categoria, int igac, int exemplares){
		super(titulo, preco, categoria, exemplares);
		_director = realizador;
		_igac = igac;
	}


	protected String getDirector() {
		return _director;
	}

	protected int getIgac() {
		return _igac;
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
     * @return Dvd's Description
     */
    @Override
    public String getDescription(){
        return super.getDescription("DVD", " - " + _director + " - " + _igac);
    }

    /**
     * Check's if the Dvd's director matches the searchQuery
     * @param searchQuery
     * @return boolean
     */
    protected boolean search(String searchQuery){
        if(super.search(searchQuery) || super.containsIgnoreCase(_director, searchQuery)){
            return true;
        }
        return false;
    }

}