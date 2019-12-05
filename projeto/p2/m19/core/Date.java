package m19.core;

import m19.core.exception.BadEntrySpecificationException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @see http://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/
 */
public class Date implements Serializable, Subject{
	private int _currentDate;
	private List<Observer> _observers;

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
	public void addObserver(Observer obs){
		_observers.add(obs);
	}

	@Override
	public void rmObserver(Observer obs){
		_observers.remove(obs);
	}

	@Override
	public void update(){
		for(Observer obs: _observers){
			obs.update(_currentDate);
		}
	}

	/**
	 * 
	 * @param nDays
	 * @return current date
	 */
	protected int advanceDay(int nDays) throws BadEntrySpecificationException{
		if(nDays < 0){
			throw new BadEntrySpecificationException("number of days to advance < 0");
		}
		_currentDate+=nDays;
		update();
		return _currentDate;
	}
}