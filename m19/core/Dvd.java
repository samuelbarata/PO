package m19.core;

import java.io.Serializable;


public class Dvd extends Work implements Serializable{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -539363745797215253L;
	private String _director;
	private int _igac;		//enunciado diz String; parser diz int

	protected Dvd(String titulo, String realizador, int preco, Category categoria, int igac, int exemplares){
		super(titulo, preco, categoria, exemplares);
		_director = realizador;
		_igac = igac;
	}

	/**
	 * @return DVD's Director
	 */
	protected String getDirector() {
		return _director;
	}

	/**
	 * @return DVD's IGAC
	 */
	protected int getIgac() {
		return _igac;
	}

	/**
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