package m19.core;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.IOException;

import m19.core.exception.MissingFileAssociationException;
import m19.core.exception.BadEntrySpecificationException;
import m19.app.exception.UserRegistrationFailedException;
import m19.app.exception.WorkNotBorrowedByUserException;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;

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
		_users = new HashSet<>();
		_works = new HashSet<>();
		_requests = new HashSet<>();
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
		new Parser(this).parseFile(filename);
	}
	
	/**
	 * checks if a work with the same title exists;
	 * if not, adds it
	 * @param work
	 */
	void addWork(Work work){
		for(Work myWork:_works){
			if(myWork==work)
				return;
		}
		work.setId(Library.getNextWId());
		_works.add(work);
	}

	/**
	 * checks if a user with the same name exists;
	 * if not, adds it
	 * @param user
	 * @throws UserRegistrationFailedException
	 */
	protected int addUser(User user) throws UserRegistrationFailedException{
		for(User myUser:_users){
			if(myUser==user)
				throw new UserRegistrationFailedException(user.getName(), user.getEmail());
		}
		user.setId(Library.getNextUId());
		_users.add(user);
		return user.getId();
	}

	/**
	 * 
	 * @param id
	 * @return Work's Description
	 * @throws NoSuchWorkException
	 */
	protected String getWorkDescription(int id) throws NoSuchWorkException{
		return getWorkById(id).getDescription();
	}

	/**
	 * 
	 * @param id
	 * @return User's Description
	 * @throws NoSuchUserException
	 */
	protected String getUserDescription(int id) throws NoSuchUserException{
		return getUserById(id).getDescription();
	}

	/**
	 * 
	 * @return Sorted Users List
	 */
	protected List<String> getAllUsers(){
		List<User> sorted = new ArrayList<>();
		for(User myUser:_users){
			sorted.add(myUser);
		}
		Collections.sort(sorted);
		return listToString(sorted);
	}

	/**
	 * 
	 * @return Sorted Works List
	 */
	protected List<String> getAllWorks(){
		List<Work> sorted = new ArrayList<>();
		for(Work myWork:_works){
			sorted.add(myWork);
		}
		Collections.sort(sorted);
		return listToString(sorted);
	}

	/**
	 * Recebe uma string e pesquisa nos campos relevantes do work
	 * @param searchQuery
	 * @return 
	 */
	protected List<String> searchWork(String searchQuery){
		List<Work> sorted = new ArrayList<>();
		for(Work myWork:_works){
			if(myWork.search(searchQuery))
				sorted.add(myWork);
		}
		Collections.sort(sorted);
		return listToString(sorted);
	}

	protected List<String> getUserNotifications(int id) throws NoSuchUserException{
		User myUser = getUserById(id);
		return myUser.getNotifications();
	}

	private User getUserById(int id) throws NoSuchUserException{
		if(id < 0 || id >= _nextUserId)
			throw new NoSuchUserException(id);
		for(User myUser:_users){
			if(myUser.getId()==id)
				return myUser;			
		}
		throw new NoSuchUserException(id);
	}

	private Work getWorkById(int id) throws NoSuchWorkException{
		if(id < 0 || id >= _nextWorkId)
			throw new NoSuchWorkException(id);
		for(Work myWork:_works){
			if(myWork.getId()==id)
				return myWork;			
		}
		throw new NoSuchWorkException(id);
	}

	private List<String> listToString(List<?> myList){
		List<String> res = new ArrayList<>();
		for(Object myObject:myList){
			res.add(myObject.toString());
		}
		return res;
	}

	/**NAO IMPLEMENTADO */
	protected void requestWork(User user, Work work, int deadline) throws WorkNotBorrowedByUserException{
		Request request = new Request(deadline, work, user);
		_requests.add(request);
	}
}
