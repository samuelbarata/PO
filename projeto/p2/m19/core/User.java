package m19.core;

public class User{
    private static int _nextId = 0;
    private final int _id;
    private boolean _isActive;
    private final String _name;
    private final String _email;

    public User(String name, String email){
        _id = _nextId++;
        _isActive = true;
        _name = name;
        _email = email;
    }

    protected boolean isActive(){
        return _isActive;
    }
    public String getDescription(){
        //TODO
    }
    
}