package m19.core;

public interface Subject{
	/**
	 * Adds observer
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