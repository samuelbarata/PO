package m19.core;

import java.io.Serializable;

public class Request implements Serializable, Observer{
	private int _deadline;
	private int _lastDayCheck;
	private Work _work;
	private User _user;

	public Request(Work work, User user, int currentDay){
		_deadline=user.getBehaviour().getDeadline(work.getNumberOfCopies());
		_work=work;
		_user=user;
		_lastDayCheck=currentDay;

		_work.requestWork();
		_user.workRequested(this);
		_user.addNotification(new Notification("REQUISIÇÃO", _work));

		for(Observer obs : work.getObservers()){
			if(obs == user){
				work.rmObserver(user);
			}
		}
	}

	/**
	 * @return Deadline
	 */
	protected int getDeadline(){
		return _deadline;
	}

	/**
	 * @return User that made the request
	 */
	protected User getUser(){
		return _user;
	}

	/**
	 * 
	 * @return
	 */
	protected Work getWork(){
		return _work;
	}

	protected void returnWork(){
		_user.workReturned(this);
		_user.addNotification(new Notification("ENTREGA", _work));
	}

	/**
	 * Recebe o novo dia
	 */
	@Override
	public void update(int currentDay) {
		if(_deadline<currentDay){
			_user.addDivida((currentDay-_lastDayCheck)*5);
		}
		_lastDayCheck = currentDay;
	}

	@Override public void update(Notification noti){}
}