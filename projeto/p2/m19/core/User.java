package m19.core;

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
    private ArrayList<Notification> _notifications;

    public User(String name, String email) throws UserRegistrationFailedException{
        if(name.isEmpty() || email.isEmpty())
            throw new UserRegistrationFailedException(name, email);
        _isActive = true;
        _name = name;
        _email = email;
        _behavior = UserBehavior.valueOf("NORMAL");
        _notifications = new ArrayList<>();
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
            return "ACTIVO";
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
     * Adds a Notification to the user
     * @param noti
     */
    protected void addNotification(Notification noti){
        _notifications.add(noti);
    }

    /**
     * Compares User a to User b by name then ID
     * @see https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
     */
    @Override
    public int compareTo(User b){
        int res = this.getName().compareTo(b.getName());;
        if(res==0)
            return Integer.compare(this.getId(), b.getId());
        return res;
    } 

    /**
     * Retrieve User's Notification and sort
     * @return User's Notification as ArrayList String
     */
    protected ArrayList<String> getNotifications(){
		ArrayList<String> res = new ArrayList<>(); 
        for(Notification myNoti : _notifications){
            res.add(myNoti.getMessage());
        }
		return res;
    }
    
    @Override
    public String toString(){
        return this.getDescription();
    }
}