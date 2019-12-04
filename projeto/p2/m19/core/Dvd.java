package m19.core;

import java.io.Serializable;


public class Dvd extends Work implements Serializable{
	private String _director;
	private int _igac;      //enunciado diz String; parser diz int

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
        return super.search(searchQuery) || super.containsIgnoreCase(_director, searchQuery);
    }

}