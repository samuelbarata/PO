package m19.core;

public interface Subject{
	/**
	 * Adds observers that will be notified of a change of date
	 * @param obs Observer
	 */
	public void addObserver(Observer obs);

	/**
	 * Removes an Observer
	 * @param obs
	 */
	public void rmObserver(Observer obs);

	/**
	 * Sends update to observers
	 */
	public void update();
}