package m19.app.users;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

/**
 * 4.2.3. Show notifications of a specific user.
 */
public class DoShowUserNotifications extends Command<LibraryManager> {

	private Input<Integer> _userId;
	private Display _display;

	/**
	 * @param receiver
	 */
	public DoShowUserNotifications(LibraryManager receiver) {
		super(Label.SHOW_USER_NOTIFICATIONS, receiver);
		_userId = _form.addIntegerInput(Message.requestUserId());
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		int userId;
		_form.parse();
		userId = _userId.value();
		_display.clear();
		for(String myNoti: _receiver.getUserNotifications(userId)){
			_display.addLine(myNoti);
		}
		_display.display();
	}

}
