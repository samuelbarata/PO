package m19.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import m19.app.exception.UserRegistrationFailedException;
import java.io.Serializable;

public class User implements Comparable<User>, Serializable, Observer{
	/** Serial number for serialization. */
	private static final long serialVersionUID = 9081337929192883019L;
	private int _id;
	private boolean _isActive;
	private final String _name;
	private final String _email;
	private UserBehavior _behavior;
	private List<Notification> _notifications;
	private Set<Request> _requests;
	private int _divida;

	public User(String name, String email) throws UserRegistrationFailedException{
		if(name.isEmpty() || email.isEmpty())
			throw new UserRegistrationFailedException(name, email);
		_isActive = true;
		_name = name;
		_email = email;
		_behavior = UserBehavior.NORMAL;
		_notifications = new ArrayList<>();
		_id = -1;
		_divida = 0;
		_requests = new HashSet<>();
	}

	public int hashCode(){
		return _id;
	}

	/**
	 * 
	 * @return if user is active
	 */
	protected boolean isActive(){
		return _isActive;
	}

	/**
	 * @return User's debt
	 */
	protected int getDivida(){
		return _divida;
	}

	/**
	 * Adds User Debt
	 * @param payment
	 */
	protected void addDivida(int payment){
		if(payment==0)//pagar tudo
			_divida=0;
		_divida = (_divida+payment <= 0) ? 0 : _divida+payment;
		updateActive();
	}

	/**
	 * Gets the User status message
	 * @return status as String
	 */
	private String statusMessage(){
		if(this.isActive()){
			return "ACTIVO";
		}
		return "SUSPENSO - EUR " + _divida;
	}

	/**
	 * 
	 * @return User's Description
	 */
	public String getDescription(){
		return _id + " - " + _name + " - " + _email + " - " + _behavior + " - " + this.statusMessage();
	}

	/**
	 * 
	 * @return name
	 */
	protected String getName(){
		return _name;
	}

	/**
	 * 
	 * @return email
	 */
	protected String getEmail(){
		return _email;
	}

	/**
	 * 
	 * @return user behavior
	 */
	protected UserBehavior getBehaviour(){
		return _behavior;
	}

	/**
	 * Compares if 2 works have the same name and email
	 * @param work
	 * @return boolean
	 */
	@Override
	public boolean equals(Object other){
		if(!(other instanceof User)) return false;
		User otherUser = (User)other;
		return this.getName().equals(otherUser.getName()) && this.getEmail().equals(otherUser.getEmail());
	}

	/**
	 * Set User's Id
	 * @param id
	 */
	protected void setId(int id){
		_id=id;
	}

	/**
	 * @return User's Id
	 */
	protected int getId(){
		return _id;
	}

	/**
	 * Adds a Notification to the user
	 * @param noti
	 */
	protected void addNotification(Notification noti){
		_notifications.add(noti);
	}

	/**
	 * Compares User to User b by name then ID
	 * @see https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
	 */
	@Override
	public int compareTo(User b){
		int res = this.getName().compareTo(b.getName());
		if(res==0)
			return Integer.compare(this.getId(), b.getId());
		return res;
	} 

	/**
	 * Retrieve User's Notification and sort
	 * @return User's Notification as List String
	 */
	protected List<String> getNotifications(){
		List<String> res = new ArrayList<>(); 
		for(Notification myNoti : _notifications){
			res.add(myNoti.getMessage());
		}
		return res;
	}

	/**
	 * @return User's Description
	 */
	@Override
	public String toString(){
		return this.getDescription();
	}

	/**
	 * Recives a Notification when a work that hasn't available was returned
	 * by another user
	 * @frequency When work returned
	 */
	@Override
	public void update(Notification noti){
		this.addNotification(noti);
	}

	/**
	 * Updates the user Status
	 * @frequency Daily
	 */
	@Override public void update(int novoDia){
		for(Request reqi: _requests){
			reqi.update(novoDia);
		}
		updateActive();
	}

	protected void resetNotifications(){
		_notifications.clear();
	}

	protected void workRequested(Request reqi){
		_requests.add(reqi);
	}

	/**
	 * Return a work
	 * @param reqi Request
	 */
	protected void workReturned(Request reqi){
		_behavior = reqi.isLate() ? _behavior.badReturn() : _behavior.goodReturn();
		_requests.remove(reqi);
		updateActive();
	}

	/**
	 * @return Current requests of the current user
	 */
	protected Set<Request> getRequests(){
		return _requests;
	}

	/**
	 * Updates if user is Active or not
	 */
	private void updateActive(){
		if(_divida > 0){
			_isActive = false;
			return;
		}
		for(Request reqi : _requests){	//requests em atraso
			if(reqi.isLate()){
				_isActive = false;
				return;
			}
		}
		_isActive = true;
	}

}