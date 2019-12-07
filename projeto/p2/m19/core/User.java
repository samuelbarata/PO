package m19.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import m19.app.exception.UserRegistrationFailedException;
import java.io.Serializable;

public class User implements Comparable<User>, Serializable, Observer{
	private static final long serialVersionUID = 9081337929192883019L;
	private int _id;
	private boolean _isActive;
	private final String _name;
	private final String _email;
	private UserBehavior _behavior;
	private List<Notification> _notifications;
	private Set<Request> _requests;
	private int _divida;
	private int _behaviorCounter;

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
		_behaviorCounter=0;
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
		updateEstado();
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
	 * Compares if 2 works have the same name
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
	 * 
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
	 */
	@Override
	public void update(Notification noti){
		this.addNotification(noti);
	}

	@Override public void update(int novoDia){}

	protected void workRequested(Request reqi){
		_requests.add(reqi);
	}

	protected void workReturned(Request reqi){
		if(!reqi.isLate()){
			_behaviorCounter= _behaviorCounter>0 ? _behaviorCounter+1 : 1;
		}
		_requests.remove(reqi);
		updateEstado();
	}

	protected Set<Request> getRequests(){
		return _requests;
	}

	private void updateEstado(){
		switch(this.getBehaviour()){
			case FALTOSO:
				if(_behaviorCounter>=3){
					_behavior = UserBehavior.NORMAL;
				}
				break;
			case NORMAL:
				if(_behaviorCounter>=5){
					_behavior = UserBehavior.CUMPRIDOR;
				} else if(_behaviorCounter<=-3){
					_behavior = UserBehavior.FALTOSO;
				}
				break;
			case CUMPRIDOR:
				if(_behaviorCounter<=-3){
					_behavior = UserBehavior.FALTOSO;
				}
				break;
		}
		if(_divida > 0){
			_isActive = false;
			return;
		}
		if(!_isActive){
			boolean aux = true; //tudo bem
			for(Request reqi : _requests){	//requests em atraso
				if(reqi.isLate()){
					aux = false;
					break;
				}
			}
			if(aux){
				_isActive = true;
			}
		}
	}

	protected int getCounter(){
		return _behaviorCounter;
	}
	protected void setCounter(int counter){
		_behaviorCounter = counter;
		updateEstado();
	}
}