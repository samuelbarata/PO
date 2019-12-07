package m19.core;

import java.io.Serializable;

public class Request implements Serializable, Observer{
	private int _deadline;
	private int _lastDayCheck;
	private boolean _isLate;
	private int _currentDay;
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

	protected int returnWork(){
		_user.workReturned(this);
		_work.returnWork();
		return _deadline<=_currentDay ? (_currentDay-_deadline)*5 : 0;
	}

	/**
	 * Recebe o novo dia
	 */
	@Override
	public void update(int currentDay) {
		_currentDay = currentDay;
		int behaviorCounter;
		if(currentDay > _deadline && _lastDayCheck <= _deadline){
			behaviorCounter = _user.getCounter();
			behaviorCounter= behaviorCounter > 0 ? -1 : behaviorCounter-1;
			_user.setCounter(behaviorCounter);
		}
		if(_deadline<currentDay){
			_isLate=true;
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
