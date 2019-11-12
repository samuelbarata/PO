package m19.core;

public class Request{
    private int _deadline;  //dia
    private Work _work;
    private User _user;

    public Request(int deadline, Work work, User user){
        _deadline=deadline;
        _work=work;
        _user=user;
        _user.addNotification(new Notification("REQUISIÇÃO", _work));
    }

    protected int getDeadline(){
        return _deadline;
    }

    protected void returnWork(){
        //TODO: verificar o resto das cenas
        _user.addNotification(new Notification("ENTREGA", _work));
    }
}