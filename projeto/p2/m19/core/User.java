package m19.core;

import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import m19.app.exception.UserRegistrationFailedException;
import java.lang.Integer;

public class User implements Comparable<User>{
    private int _id;
    private boolean _isActive;
    private final String _name;
    private final String _email;
    private UserBehavior _behavior;
    private Set<Notification> _notifications;

    public User(String name, String email) throws UserRegistrationFailedException{
        if(name.isEmpty() || email.isEmpty())
            throw new UserRegistrationFailedException(name, email);
        _isActive = true;
        _name = name;
        _email = email;
        _behavior = UserBehavior.valueOf("NORMAL");
        _id = -1;
    }

    //@Override
    public int hashCode(){
        return _id;
    }

    protected boolean isActive(){
        //TODO: javadoc funcao
        return _isActive;
    }

    private String statusMessage(){
        if(this.isActive())
            return "ATIVO";
        return "SUSPENSO - EUR ";//TODO: incert divida 
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
     * @return
     */
    @Override
    public boolean equals(Object other){
        if(!(other instanceof User)) return false;
        User otherUser = (User)other;
        return this.getName().equals(otherUser.getName());
    }

    protected void setId(int id){
        _id=id;
    }

    protected int getId(){
        return _id;
    }

    /**
     * Compares User a to User b by name then ID
     */
    @Override
    public int compareTo(User b){
        int res = this.getName().compareTo(b.getName());;
        if(res==0)
            return Integer.compare(this.getId(), b.getId());
        return res;
    } 

    protected ArrayList<String> getNotifications(){
		ArrayList<String> myNoti = new ArrayList<>(); 
        //TODO: get and sort notifications @see Library.getAllUsers
		return myNoti;
	}
}