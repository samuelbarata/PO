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
		int userId, workId, returnDate;
		Input<Integer> userIdForm;
		Input<Integer> workIdForm;
		Input<String> notiPref;
		_display.clear();
		_form.clear();
		userIdForm = _form.addIntegerInput(Message.requestUserId());
		workIdForm = _form.addIntegerInput(Message.requestWorkId());
		_form.parse();
		userId = userIdForm.value();
		workId = workIdForm.value();
		try{
			returnDate = _receiver.makeRequest(userId, workId);
			_display.popup(Message.workReturnDay(workId, returnDate));
		} catch(RuleFailedException e) {
			if(e.getRuleIndex() == 3){
				_form.clear();
				notiPref = _form.addStringInput(Message.requestReturnNotificationPreference());
				_form.parse();
				if(notiPref.value().equals("s")){
					_receiver.notifyWorkAvailable(userId, workId);
				}
			}else{
				throw e;
			}
		}
	}

}
