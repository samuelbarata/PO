package m19.app.requests;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

/**
 * 4.4.2. Return a work.
 */
public class DoReturnWork extends Command<LibraryManager> {

	private Input<Integer> _userIdForm;
	private Input<Integer> _workIdForm;
	private Input<String> _payment;
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
		int _userId, _workId, divida;
		_form.clear();
		_userIdForm = _form.addIntegerInput(Message.requestUserId());
		_workIdForm = _form.addIntegerInput(Message.requestWorkId());
		_form.parse();
		_userId = _userIdForm.value();
		_workId = _workIdForm.value();
		divida = _receiver.returnWork(_userId, _workId);
		if(divida > 0){
			_display.clear();
			_display.addLine(Message.showFine(_userId, divida));
			_display.display();
			_form.clear();
			_payment = _form.addStringInput(Message.requestFinePaymentChoice());
			_form.parse();
			if(_payment.value().equals("s")){
				_receiver.payFine(_userId);
			}
		}
	}
}
