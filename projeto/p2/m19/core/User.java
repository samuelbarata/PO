package m19.core;

import java.util.Set;
import m19.app.exception.UserRegistrationFailedException;;

public class User{
    private final int _id;
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
        _id = Library.getNextUId();
    }

    protected boolean isActive(){
        //TODO: javadoc funcao
        return _isActive;
    }

    public String getDescription(){
        //FIXME: mudar _behaviour;_isActive para as Strings correspondentes
        //TODO: javadoc funcao
        return _id + " - " + _name + " - " + _email + " - " + _behavior + " - " + _isActive;
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
    public boolean equals(User user){
        return this.getName().equals(user.getName());
    }
}