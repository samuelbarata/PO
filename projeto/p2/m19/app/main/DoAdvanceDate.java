package m19.app.main;

import m19.core.LibraryManager;
import m19.app.main.Message;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.DialogException;

// FIXME import iother core concepts
// FIXME import ui concepts

/**
 * 4.1.3. Advance the current date.
 */
public class DoAdvanceDate extends Command<LibraryManager>{

	private Input<Integer> _days;	//field of form

	/**
	 * @param receiver
	 */
	public DoAdvanceDate(LibraryManager receiver) {
		super(Label.ADVANCE_DATE, receiver);
		_days = _form.addIntegerInput(Message.requestDaysToAdvance());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException{
		int days;
		_form.parse();
		days = _days.value();
		_receiver.advanceDay(days);
		//TODO: verificar tudo com nova data
	}
  
}
