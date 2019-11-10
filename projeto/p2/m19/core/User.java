package m19.core;

import java.util.Set;

public class User{
    private final int _id;
    private boolean _isActive;
    private final String _name;
    private final String _email;
    private UserBehavior _behavior;
    private Set<Notification> _notifications;

    protected User(String name, String email){
        _id = Library.getNextUId();
        _isActive = true;
        _name = name;
        _email = email;
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
    
    //TODO: getters

}