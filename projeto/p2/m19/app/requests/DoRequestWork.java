package m19.app.requests;

import m19.app.exception.RuleFailedException;
import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;

/**
 * 4.4.1. Request work.
 */
public class DoRequestWork extends Command<LibraryManager> {

	private Display _display;

	/**
	 * @param receiver
	 */
	public DoRequestWork(LibraryManager receiver) {
		super(Label.REQUEST_WORK, receiver);
		_display = new Display();
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		int _userId, _workId, returnDate;
		Input<Integer> _userIdForm;
		Input<Integer> _workIdForm;
		Input<String> _notiPref;

		_form.clear();
		_userIdForm = _form.addIntegerInput(Message.requestUserId());
		_workIdForm = _form.addIntegerInput(Message.requestWorkId());
		_form.parse();
		_userId = _userIdForm.value();
		_workId = _workIdForm.value();
		_display.clear();
		try{
			returnDate = _receiver.makeRequest(_userId, _workId);
			_display.addLine(Message.workReturnDay(_workId, returnDate));
			_display.display();
		} catch(RuleFailedException e) {
			if(e.getRuleIndex() == 3){
				_form.clear();
				_notiPref = _form.addStringInput(Message.requestReturnNotificationPreference());
				_form.parse();
				if(_notiPref.value().equals("s")){
					_receiver.notifyWorkAvailable(_userId, _workId);
				}
			}else{
				throw e;
			}
		}
	}

}
