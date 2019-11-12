package m19.core;

import m19.app.exception.WorkNotBorrowedByUserException;;

public class Request{
    private int _deadline;  //dia
    private Work _work;
    private User _user;

    public Request(int deadline, Work work, User user) throws WorkNotBorrowedByUserException{
        _deadline=deadline;
        _work=work;
        _user=user;
        //TODO: verificar cenas e mandar exceção abaixo se n passar

        if(_work.requestWork()){
            _user.addNotification(new Notification("REQUISIÇÃO", _work));
        } throw new WorkNotBorrowedByUserException(work.getId(), user.getId());
    }

    protected int getDeadline(){
        return _deadline;
    }

    protected void returnWork(){
        //TODO: verificar o resto das cenas
        _user.addNotification(new Notification("ENTREGA", _work));
    }
}