package m19.core;

import java.util.Set;

public class User{
    private final int _id;
    private boolean _isActive;
    private final String _name;
    private final String _email;
    private Set<Notification> _notifications;

    protected User(String name, String email){
        _id = Library.getNextUId();
        _isActive = true;
        _name = name;
        _email = email;
    }

    protected boolean isActive(){
        return _isActive;
    }
    
}