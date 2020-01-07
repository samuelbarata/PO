package m19.app.works;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.3.2. Display all works.
 */
public class DoEstatistica extends Command<LibraryManager> {

	private Display _display;

	/**
	 * @param receiver
	 */
	public DoEstatistica(LibraryManager receiver) {
		super(Label.SHOW_WORKS, receiver);
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException{
		_display.clear();
		
		_display.addLine(_receiver.getNumberWorks());
		
		_display.addLine(_receiver.getNumberAWorks());

		_display.addLine(_receiver.getMostAv().getDescription());

		_display.display();
	}
}
