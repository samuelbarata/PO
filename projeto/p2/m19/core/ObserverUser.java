package m19.core;

public class ObserverUser extends user, implements UserObserver{

	private int _previousNumberAvailable = 0; //quando começam as notifs è pq hà 0 availables;

	protected int getPreviousNumber(){
		return _previousNumberAvailable;
	}

	@Override
	public void update(int currentNumberAvailable){
		//falta diferenciar se entregaram ou requisitaram; maybe com strategy?
		if (getPreviousNumber() > currentNumberAvailable){
			_user.addNotification(new Notification("REQUISIÇÃO", _work));
			_previousNumberAvailable--; //se alguem requisitou ficaram menos availables;
		}
		else {
			_user.addNotification(new Notification("ENTREGA", _work));
			_previousNumberAvailable++; //tenho de fazer uma funçao que faz isto ou pode ser assim;
		}
	}
}



