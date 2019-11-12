package m19.app.main;

import java.io.IOException;

import m19.core.LibraryManager;
import m19.core.exception.MissingFileAssociationException;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> implements Message{
  
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
	public final void execute() {
		String _filename;
		_form.parse(false);
		//TODO: ha outra mensagem pra usar quando o form ja tem valor?? idk mas algo aqui ainda n ta certo
		_filename=_inputForm.value();

		try{
			LibraryManager.saveAs(_filename);
		} catch(MissingFileAssociationException | IOException ex) {

		}
	}
}
