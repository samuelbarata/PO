package m19.app.requests;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;

/**
 * 4.4.2. Return a work.
 */
public class DoReturnWork extends Command<LibraryManager> {

	private Display _display;

	/**
	 * @param receiver
	 */
	public DoReturnWork(LibraryManager receiver) {
		super(Label.RETURN_WORK, receiver);
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		int userId, workId, divida;
		Input<Integer> userIdForm;
		Input<Integer> workIdForm;
		Input<String> payment;

		_form.clear();
		userIdForm = _form.addIntegerInput(Message.requestUserId());
		workIdForm = _form.addIntegerInput(Message.requestWorkId());
		_form.parse();
		userId = userIdForm.value();
		workId = workIdForm.value();
		divida = _receiver.returnWork(userId, workId);
		if(divida > 0){
			_form.clear();
			_display.clear();
			_display.popup(Message.showFine(userId, divida));
			payment = _form.addStringInput(Message.requestFinePaymentChoice());
			_form.parse();
			if(payment.value().equals("s")){
				_receiver.payFine(userId);
			}
		}
	}
}
