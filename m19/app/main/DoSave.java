package m19.app.main;

import java.io.IOException;

import m19.core.LibraryManager;
import m19.core.exception.MissingFileAssociationException;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager>{
  
	private Input<String> _inputForm;

	/**
	 * @param receiver
	 */
	public DoSave(LibraryManager receiver) {
		super(Label.SAVE, receiver);
		_inputForm = _form.addStringInput(Message.newSaveAs());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException{
		try{
			_receiver.save();
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch(MissingFileAssociationException e){
			_form.parse();
			try{
				_receiver.saveAs(_inputForm.value());
			} catch(MissingFileAssociationException | IOException ex){
				ex.printStackTrace();
			}
		}
	}
}
