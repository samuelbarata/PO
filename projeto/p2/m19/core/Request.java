package m19.core;

import java.io.Serializable;

public class Request implements Serializable, DateObserver{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -1549234534516490041L;
	private int _deadline;
	private int _currentDay;
	private Work _work;
	private User _user;

	/**
	 * Creates a new Request
	 * @param work	Work that was requested
	 * @param user	User that made the request
	 * @param currentDay Day of the Request
	 */
	public Request(Work work, User user, int currentDay){
		_deadline=currentDay + user.getBehaviour().getDeadline(work.getNumberOfCopies());
		_work=work;
		_user=user;
		_work.requestWork();
		_user.workRequested(this);
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
	 * @return Work that was requested
	 */
	protected Work getWork(){
		return _work;
	}

	/**
	 * @return fine
	 */
	protected int returnWork(){
		_user.workReturned(this);
		_work.returnWork();
		return _deadline<_currentDay ? (_currentDay-_deadline)*5 : 0;
	}

	@Override
	public void update(int currentDay) {
		_currentDay = currentDay;
	}

	/**
	 * @return if the user is late to return or not
	 */
	public boolean isLate() {
		return _currentDay>_deadline;
	}
}
