package m19.app.works;

import m19.core.LibraryManager;
import m19.app.works.Message;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

// FIXME import other core concepts
// FIXME import ui concepts

/**
 * 4.3.1. Display work.
 */
public class DoDisplayWork extends Command<LibraryManager> {

	private Input<Integer> _workId;
	private Display _display;

	/**
	 * @param receiver
	 */
	public DoDisplayWork(LibraryManager receiver) {
		super(Label.SHOW_WORK, receiver);
		_workId = _form.addIntegerInput(Message.requestWorkId());
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		int workId;
		_form.parse();
		workId = _workId.value();
		_display.clear();
		_display.add(_receiver.getWorkDescription(workId));
		_display.display();
	}
}
