package m19.core;

public interface DateSubject{
	/**
	 * Adds observer
	 * @param obs Observer
	 */
	public void addObserver(DateObserver obs);

	/**
	 * Removes an Observer
	 * @param obs
	 */
	public void rmObserver(DateObserver obs);

	/**
	 * Sends update to observers
	 */
	public abstract void update();
}