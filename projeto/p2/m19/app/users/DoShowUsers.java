package m19.app.users;

import m19.core.LibraryManager;
import m19.core.User;
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
	public final void execute() {
		_display.clear();
		for(User myUser : LibraryManager.getAllUsers()){
			_display.addLine(myUser.getDescription());
		}
		_display.display();
	}
}
