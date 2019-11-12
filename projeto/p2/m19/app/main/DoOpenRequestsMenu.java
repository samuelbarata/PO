package m19.app.main;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.1.4. Command to open the requests menu.
 */
public class DoOpenRequestsMenu extends Command<LibraryManager> {

	/**
	 * @param receiver
	 */
	public DoOpenRequestsMenu(LibraryManager receiver) {
		super(Label.OPEN_REQUESTS_MENU, receiver);
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		m19.app.requests.Menu menu = new m19.app.requests.Menu(_receiver);
		menu.open();
	}
}
