package m19.core;

public class Request{
    private int _deadline;  //dia 
    private Work _work;
    private User _user;

    public Request(int deadline, Work work, User user){
        _deadline=deadline;
        _work=work;
        _user=user;
    }
    protected int getDeadline(){
        return _deadline;
    }
}