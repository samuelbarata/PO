package m19.app.users;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Display;

/**
 * 4.2.4. Show all users.
 */
public class DoShowValue extends Command<LibraryManager> {

	private Display _display;

	/**
	 * @param receiver
	 */
	public DoShowValue(LibraryManager receiver) {
		super(Label.SHOW_USERS, receiver);
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException{
		_display.clear();
		if (_receiver.getMostValue() != null){
			_display.addLine(_receiver.getMostValue().toString());
			_display.display();
		}
	}
}
