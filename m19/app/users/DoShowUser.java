package m19.app.users;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

/**
 * 4.2.2. Show specific user.
 */
public class DoShowUser extends Command<LibraryManager> {

	private Input<Integer> _userId;
	private Display _display;

	/**
	 * @param receiver
	 */
	public DoShowUser(LibraryManager receiver) {
		super(Label.SHOW_USER, receiver);
		_userId = _form.addIntegerInput(Message.requestUserId());
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		int userId;
		_form.parse(true);
		userId = _userId.value();
		_display.clear();
		_display.popup(_receiver.getUserDescription(userId));
	}
}
