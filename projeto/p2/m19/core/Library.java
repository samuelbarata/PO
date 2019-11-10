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
	 * @return next user's id
	 */
	protected static int getNextUId(){
		return _nextUserId++;
	}

	/**
	 * @return next work's id
	 */
	protected static int getNextWId(){
		return _nextWorkId++;
	}
	
	/**
	 * @return current system date
	 */
	protected int getCurrentDate(){
		return _date.getCurrentDate();
	}

	protected int advanceDay(int nDays){
		try {
			return _date.advanceDay(nDays);
		} catch(BadEntrySpecificationException e) {
			return 0;
		}
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
		Parser _parser = new Parser(this);
		_parser.parseFile(filename);
	}
	
	/**
	 * checks if a work with the same title exists;
	 * if not, adds it
	 * @param work
	 */
	void addWork(Work work){
		for(Work myWork:_works){
			if(myWork.getTitle().equals(work.getTitle()))
				return;
		}
		_works.add(work);
	}

	/**
	 * checks if a user with the same name exists;
	 * if not, adds it
	 * @param user
	 */
	void addUser(User user){	//TODO verificar se manda exceção
		for(User myUser:_users){
			if(myUser.getName().equals(user.getName()))
				return;
		}
		_users.add(user);
	}

}
