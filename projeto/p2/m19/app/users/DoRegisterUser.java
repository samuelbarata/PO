package m19.app.users;

import m19.core.LibraryManager;
import m19.core.User;
import m19.app.users.Message;
import m19.app.exception.UserRegistrationFailedException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

/**
 * 4.2.1. Register new user.
 */
public class DoRegisterUser extends Command<LibraryManager> implements Message{

	private Input<String> _name, _email;


	/**
	 * @param receiver
	 */
	public DoRegisterUser(LibraryManager receiver) {
		super(Label.REGISTER_USER, receiver);
		_name = _form.addStringInput(Message.requestUserName());
		_email = _form.addStringInput(Message.requestUserEMail());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException, UserRegistrationFailedException{
		String _name, _email;
		_form.parse();
		_name=this._name.value();
		_email=this._email.value();
		LibraryManager.addUser(new User(_name, _email));
	}

}
