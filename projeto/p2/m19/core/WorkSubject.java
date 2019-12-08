package m19.core;

public interface WorkSubject{
	/**
	 * Adds observer
	 * @param obs Observer
	 */
	public void addObserver(WorkObserver obs, NotiType type);

	/**
	 * Removes an Observer
	 * @param obs
	 */
	public void rmObserver(WorkObserver obs, NotiType type);

	/**
	 * Sends update to observers
	 */
	public abstract void update();
}