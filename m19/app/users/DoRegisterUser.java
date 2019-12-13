package m19.app.users;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;

/**
 * 4.2.1. Register new user.
 */
public class DoRegisterUser extends Command<LibraryManager> implements Message{

	private Input<String> _name, _email;
	private Display _display;


	/**
	 * @param receiver
	 */
	public DoRegisterUser(LibraryManager receiver) {
		super(Label.REGISTER_USER, receiver);
		_display = new Display();
		_name = _form.addStringInput(Message.requestUserName());
		_email = _form.addStringInput(Message.requestUserEMail());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException{
		String name, email;
		int uId;
		_display.clear();
		_form.parse();
		name=_name.value();
		email=_email.value();
		uId = _receiver.addUser(name, email);
		_display.popup(Message.userRegistrationSuccessful(uId));
	}

}
