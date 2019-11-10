package m19.app.main;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.2. Display the current date.
 */
public class DoDisplayDate extends Command<LibraryManager> implements Message {

	private Display _display;

	/**
	 * @param receiver
	 */
	public DoDisplayDate(LibraryManager receiver) {
		super(Label.DISPLAY_DATE, receiver);
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_display.add(Message.currentDate(LibraryManager.getCurrentDate()));
		_display.display();
	}
  
}
