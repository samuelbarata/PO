package m19.app.users;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

/**
 * 4.2.5. Settle a fine.
 */
public class DoPayFine extends Command<LibraryManager> {

	private Input<Integer> _inputForm;


	/**
	 * @param receiver
	 */
	public DoPayFine(LibraryManager receiver) {
		super(Label.PAY_FINE, receiver);
		_inputForm = _form.addIntegerInput(Message.requestUserId());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		int userId;
		_form.parse();
		userId = _inputForm.value();
		_receiver.payFine(userId);
	}
}
