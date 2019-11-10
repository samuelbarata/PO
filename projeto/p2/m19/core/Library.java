package m19.core;

import java.io.Serializable;
import java.util.Set;
import java.util.Collections;
import java.io.IOException;

import m19.core.exception.MissingFileAssociationException;
import m19.core.exception.BadEntrySpecificationException;

// FIXME import other system types
// FIXME import project (core) types if needed

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 201901101348L;
	
	private static int _nextWorkId;
	private static int _nextUserId;
	private static Date _date;
	private Set<User> _users;
	private Set<Work> _works;
	private Set<Request> _requests;

	/**
	 * Initialize empty library
	 */
	public Library(){
		_nextUserId=0;
		_nextWorkId=0;
		_date = new Date();
		_users = Collections.emptySet();
		_works = Collections.emptySet();
		_requests = Collections.emptySet();
	}

	/**
	 * @return next user's id 				// @return == comentar return ; @param comentar variavel ;
	 */
	public static int getNextUId(){
		return _nextUserId++;
	}

	/**
	 * @return next work's id
	 */
	public static int getNextWId(){
		return _nextWorkId++;
	}
	
	/**
	 * @return current system date
	 */
	public int getCurrentDate(){
		return _date.getCurrentDate();
	}
	

	/**
	 * Read the text input file at the beginning of the program and populates the
	 * instances of the various possible types (books, DVDs, users).
	 * 
	 * @param filename
	 *          name of the file to load
	 * @throws BadEntrySpecificationException
	 * @throws IOException
	 */
	void importFile(String filename) throws BadEntrySpecificationException, IOException {
		// FIXME implement method
	}
	
	// FIXME define methods

}
