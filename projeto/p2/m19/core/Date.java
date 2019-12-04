package m19.core;

import m19.core.exception.BadEntrySpecificationException;
import java.io.Serializable;

//https://www.youtube.com/watch?v=wiQdrH2YpT4&feature=youtu.be
//Data envia updates para os Requests


public class Date implements Serializable{
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
	 * 
	 * @param nDays
	 * @return current date
	 */
	protected int advanceDay(int nDays) throws BadEntrySpecificationException{
		if(nDays < 0){
			throw new BadEntrySpecificationException("number of days to advance < 0");
		}
		return _currentDate+=nDays;
	}
}