package m19.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Work implements Comparable<Work>, Serializable, Subject{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -1407186276489357901L;
	private int _id;
	private final int _price;
	private final int _numberOfCopies;
	private int _available;
	private final String _title;
	private final Category _category;
	private List<Observer> _observers = new ArrayList<>();

	public Work(String titulo, int preco, Category categoria, int exemplares){
		_price = preco;
		_numberOfCopies = exemplares;
		_available = _numberOfCopies;
		_title = titulo;
		_category = categoria;
		_id=-1;
	}

	/**
	 * decreases the number of available copies
	 */
	protected void requestWork(){
		_available--;
		update("REQUISIÇÃO");
	}

	/**
	 * increases the number of available copies
	 */
	protected void returnWork(){
		_available++;
		update("ENTREGA");
	}

	/**
	 * @return work's id
	 */
	protected int getId() {
		return _id;
	}

	/**
	 * Sets the work id to a given id
	 * @param id
	 */
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

	/**
	 * Check's if the Work's title matches the searchQuery
	 * @param searchQuery
	 * @return boolean
	 */
	protected boolean search(String searchQuery){
		return containsIgnoreCase(_title, searchQuery);
	}

	/**
	 * Checks if subString is in str
	 * @param str
	 * @param subString
	 * @return boolean
	 */
	protected static boolean containsIgnoreCase(String str, String subString) {
		return str.toLowerCase().contains(subString.toLowerCase());
	}

	/**
	 * @return Work's Description
	 */
	@Override
	public String toString(){
		return this.getDescription();
	}

	
	@Override
	public void addObserver(Observer user){
		_observers.add(user);
	}

	@Override
	public void rmObserver(Observer user){
		_observers.remove(user);
	}

	/**
	 * @return The list of Users that wants to be notified of this work return
	 */
	public List<Observer> getObservers(){
		return _observers;
	}

	/**
	 * Sends Notification to every User that asked to be notified
	 */
	public void update(String label){
		User _user;
		for (Observer obs : _observers) {
			_user = (User) obs;
			_user.addNotification(new Notification(label, this));
		}
	}

	@Override public void update(){
		update("ENTREGA");
	}
}