package m19.core;

public interface Observer{
	/**
	 * recebe novo dia do sistema
	 * @param day
	 */
	public void update(int day);

	/**
	 * recebe notificação
	 * @param noti
	 */
	public void update(Notification noti);
}