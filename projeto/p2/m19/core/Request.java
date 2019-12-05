package m19.core;

import java.io.Serializable;
import m19.app.exception.WorkNotBorrowedByUserException;

public class Request implements Serializable, Observer{
	private int _deadline;
	private int _lastDayCheck;
	private Work _work;
	private User _user;

	public Request(int deadline, Work work, User user, int currentDay) throws WorkNotBorrowedByUserException{
		_deadline=deadline;
		_work=work;
		_user=user;
		_lastDayCheck=currentDay;
		//TODO: verificar regras

		if(_work.requestWork()){
			_user.addNotification(new Notification("REQUISIÇÃO", _work));
		} else {
			throw new WorkNotBorrowedByUserException(work.getId(), user.getId());
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
		//TODO: verificar o resto das cenas
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