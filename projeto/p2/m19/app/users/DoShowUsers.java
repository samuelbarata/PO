package m19.app.users;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Display;

/**
 * 4.2.4. Show all users.
 */
public class DoShowUsers extends Command<LibraryManager> {

	private Display _display;

	/**
	 * @param receiver
	 */
	public DoShowUsers(LibraryManager receiver) {
		super(Label.SHOW_USERS, receiver);
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException{
		_display.clear();
		for(String myString : _receiver.getAllUsers()){
			_display.addLine(myString);
		}
		_display.display();
	}
}
