package m19.core;

import java.io.Serializable;

/**
 * @see http://www.newthinktank.com/2012/08/observer-design-pattern-tutorial/
 */
public class Date implements Serializable{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -7653987002939589315L;
	private int _currentDate;

	public Date(){
		_currentDate=0;
	}

	/**
	 * @return current date
	 */
	protected int getCurrentDate(){
		return _currentDate;
	}

	/**
	 * Advances the current date
	 * @param nDays number of days to advance
	 * @return current date
	 */
	protected int advanceDay(int nDays){
		_currentDate += nDays <= 0 ? 0 : nDays;
		return _currentDate;
	}
}