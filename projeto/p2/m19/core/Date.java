package m19.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @see http://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/
 */
public class Date implements Serializable, DateSubject{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -7653987002939589315L;
	private int _currentDate;
	private List<DateObserver> _observers;

	public Date(){
		_currentDate=0;
		_observers = new ArrayList<>();
	}

	/**
	 * @return current date
	 */
	protected int getCurrentDate(){
		return _currentDate;
	}

	@Override
	public void addObserver(DateObserver obs){
		_observers.add(obs);
	}

	@Override
	public void rmObserver(DateObserver obs){
		_observers.remove(obs);
	}

	/**
	 * Sends an update with the current date to every observer
	 */
	@Override
	public void update(){
		for(DateObserver obs: _observers){
			obs.update(_currentDate);
		}
	}

	/**
	 * Advances the current date
	 * @param nDays number of days to advance
	 * @return current date
	 */
	protected int advanceDay(int nDays){
		if(nDays <= 0){
			return _currentDate;
		}
		_currentDate+=nDays;
		update();
		return _currentDate;
	}
}