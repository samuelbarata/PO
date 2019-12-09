package m19.core;

public interface WorkSubject{
	/**
	 * Adds observer
	 * @param obs Observer
	 */
	void addObserver(WorkObserver obs, NotiType type);

	/**
	 * Removes an Observer
	 * @param obs
	 */
	void rmObserver(WorkObserver obs, NotiType type);

	/**
	 * Sends notification to users subscribed to this type of notification
	 */
	abstract void update(NotiType label);
}