package m19.core;

import java.io.Serializable;

public class Request implements Serializable, Observer{
	private int _deadline;
	private int _lastDayCheck;
	private Work _work;
	private User _user;

	public Request(int deadline, Work work, User user, int currentDay) throws Exception{
		_deadline=deadline;
		_work=work;
		_user=user;
		_lastDayCheck=currentDay;
		//TODO: verificar regras

		if(_work.requestWork()){
			_user.addNotification(new Notification("REQUISIÇÃO", _work));
		} throw new Exception();
	}

	protected int getDeadline(){
		return _deadline;
	}

	protected void returnWork(){
		//TODO: verificar o resto das cenas
		_user.addNotification(new Notification("ENTREGA", _work));
	}

	@Override
	public void update(int currentDay) {
		if(_deadline<currentDay){
			_user.addDivida((currentDay-_lastDayCheck)*5);
		}
		_lastDayCheck = currentDay;
	}

	protected User getUser(){
		return _user;
	}

	protected Work getWork(){
		return _work;
	}
}