package m19.core;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.IOException;

import m19.app.exception.*;
import m19.core.exception.*;

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 201901101348L;
	
	private int _nextWorkId;
	private int _nextUserId;
	private Date _date;
	private Set<User> _users;
	private Set<Work> _works;
	private List<Rule> _rules;

	/**
	 * Initialize empty library
	 */
	public Library(){
		_nextUserId=0;
		_nextWorkId=0;
		_date = new Date();
		_users = new HashSet<>();
		_works = new HashSet<>();
		_rules = new ArrayList<>();
		_rules.add(new CheckRequestTwice());
		_rules.add(new CheckUserSuspended());
		_rules.add(new CheckWorkAvailable());
		_rules.add(new CheckUserSpace());
		_rules.add(new CheckWorkCategory());
		_rules.add(new CheckWorkPrice());
	}

	/**
	 * @return next user's id
	 */
	protected int getNextUId(){
		return _nextUserId++;
	}

	/**
	 * @return next work's id
	 */
	protected int getNextWId(){
		return _nextWorkId++;
	}
	
	/**
	 * @return current system date
	 */
	protected int getCurrentDate(){
		return _date.getCurrentDate();
	}

	/**
	 * Advances date
	 * @param nDays Days to advance
	 * @return current date
	 */
	protected int advanceDay(int nDays){
		return _date.advanceDay(nDays);
	}
	
	/**
	 * Read the text input file at the beginning of the program and populates the
	 * instances of the various possible types (books, DVDs, users).
	 * 
	 * @param filename name of the file to load
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
			if(myWork.equals(work))
				return;
		}
		work.setId(getNextWId());
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
			if(myUser.equals(user))
				throw new UserRegistrationFailedException(user.getName(), user.getEmail());
		}
		user.setId(getNextUId());
		_users.add(user);
		_date.addObserver(user);
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
	 * @return Sorted Users String List
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
	 * @return Sorted Works String List
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

	/**
	 * 
	 * @param id User
	 * @return Notifications as String List
	 * @throws NoSuchUserException
	 */
	protected List<String> getUserNotifications(int id) throws NoSuchUserException{
		User user = getUserById(id);
		List<String> notifications = user.getNotifications();
		return notifications;
	}

	/**
	 * 
	 * @param id User
	 * @return User with given Id
	 * @throws NoSuchUserException
	 */
	private User getUserById(int id) throws NoSuchUserException{
		if(id < 0 || id >= _nextUserId)
			throw new NoSuchUserException(id);
		for(User myUser:_users){
			if(myUser.getId()==id)
				return myUser;			
		}
		throw new NoSuchUserException(id);
	}

	/**
	 * 
	 * @param id Work
	 * @return Work with given Id
	 * @throws NoSuchWorkException
	 */
	private Work getWorkById(int id) throws NoSuchWorkException{
		if(id < 0 || id >= _nextWorkId)
			throw new NoSuchWorkException(id);
		for(Work myWork:_works){
			if(myWork.getId()==id)
				return myWork;			
		}
		throw new NoSuchWorkException(id);
	}

	/**
	 * Convert a list of Objects to a list of Strings
	 * @param myList
	 * @return List of Strings using toString() method
	 */
	private List<String> listToString(List<?> myList){
		List<String> res = new ArrayList<>();
		for(Object myObject:myList){
			res.add(myObject.toString());
		}
		return res;
	}

	/**
	 * Checks if a request can be made
	 * @param user
	 * @param work
	 * @throws RuleFailedException
	 */
	private void ruleChecker(User user, Work work) throws RuleFailedException{
		for(Rule regra: _rules){
			regra.checkRule(user, work);
		}
	}

	/**
	 * Make request 
	 * @param userId
	 * @param workId
	 * @return Deadline
	 * @throws NoSuchUserException
	 * @throws NoSuchWorkException
	 * @throws RuleFailedException
	 */
	protected int makeRequest(int userId, int workId) throws NoSuchUserException, NoSuchWorkException, RuleFailedException{
		return requestWork(this.getUserById(userId), this.getWorkById(workId));
	}

	/**
	 * Make request
	 * @param user
	 * @param work
	 * @return Deadline
	 * @throws RuleFailedException
	 */
	private int requestWork(User user, Work work) throws RuleFailedException{
		ruleChecker(user, work);
		Request request = new Request(work, user, _date.getCurrentDate());
		return request.getDeadline();
	}

	/**
	 * Return's a work to the library
	 * @param userId
	 * @param workId
	 * @return fine
	 * @throws NoSuchUserException
	 * @throws NoSuchWorkException
	 * @throws WorkNotBorrowedByUserException
	 */
	protected int returnWork(int userId, int workId) throws NoSuchUserException, NoSuchWorkException, WorkNotBorrowedByUserException{
		User user = getUserById(userId);
		Work work = getWorkById(workId);
		for(Request reqi : user.getRequests()){
			if(reqi.getWork().equals(work)){
				return returnWork(reqi);
			}
		}
		throw new WorkNotBorrowedByUserException(workId, userId);
	}

	/**
	 * Return's a work to the library
	 * @param reqi
	 * @return fine
	 */
	private int returnWork(Request reqi){
		reqi.getUser().addDivida(reqi.returnWork());
		return reqi.getUser().getDivida();
	}

	/**
	 * Pays user debt
	 * @param _userId
	 * @throws NoSuchUserException
	 * @throws UserIsActiveException
	 */
	protected void payFine(int _userId) throws NoSuchUserException, UserIsActiveException{
		User _myUser = this.getUserById(_userId);
		if(_myUser.isActive()){
			throw new UserIsActiveException(_userId);
		}
		_myUser.addDivida(0);
	}

	/**
	 * Asks to be notified if the work is available
	 * @param userId
	 * @param workId
	 */
	protected void notifyWorkAvailable(int userId, int workId) throws NoSuchUserException, NoSuchWorkException{
		getWorkById(workId).addObserver(this.getUserById(userId), NotiType.ENTREGA);
	}

	/**
	 * Asks to be notified when work is requested
	 * @param userId
	 * @param workId
	 */
	protected void showInterest(int userId, int workId)throws NoSuchUserException, NoSuchWorkException{
		getWorkById(workId).addObserver(this.getUserById(userId), NotiType.REQUISIÇÃO);
	}
}
