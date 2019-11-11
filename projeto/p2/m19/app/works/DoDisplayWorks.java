package m19.app.works;

import m19.core.LibraryManager;
import m19.core.Work;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
// FIXME import ui concepts

/**
 * 4.3.2. Display all works.
 */
public class DoDisplayWorks extends Command<LibraryManager> {

	private Display _display;

	/**
	 * @param receiver
	 */
	public DoDisplayWorks(LibraryManager receiver) {
		super(Label.SHOW_WORKS, receiver);
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		_display.clear();
		for(Work myWork : LibraryManager.getAllWorks()){
			_display.addLine(myWork.getDescription());
		}
		_display.display();
	}
}
