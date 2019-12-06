package m19.core;

import java.io.Serializable;

public class Request implements Serializable, Observer{
	private int _deadline;
	private int _lastDayCheck;
	private boolean _isLate;
	private Work _work;
	private User _user;

	public Request(Work work, User user, int currentDay){
		_deadline=currentDay + user.getBehaviour().getDeadline(work.getNumberOfCopies());
		_work=work;
		_user=user;
		_lastDayCheck=currentDay;
		_isLate=false;
		_work.requestWork();
		_user.workRequested(this);
		//_user.addNotification(new Notification("REQUISIÇÃO", _work));

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
		_work.returnWork();
		//_user.addNotification(new Notification("ENTREGA", _work));
	}

	/**
	 * Recebe o novo dia
	 */
	@Override
	public void update(int currentDay) {
		if(_deadline<currentDay){
			if (_lastDayCheck < _deadline){
				_lastDayCheck = _deadline;
			}
			_isLate=true;
			_user.addDivida((currentDay-_lastDayCheck)*5); //o erro n começa no lastdaycheck acho;
		}
		_lastDayCheck = currentDay;
	}

	/**
	 * @return if the user is late to return or not
	 */
	public boolean isLate() {
		return _isLate;
	}

	@Override public void update(Notification noti){}
}