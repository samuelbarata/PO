package m19.app.main;

import java.io.IOException;

import m19.core.LibraryManager;
import m19.core.exception.MissingFileAssociationException;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> implements Message{
  
	private Input<String> _inputForm;
	private Display _display;

	/**
	 * @param receiver
	 */
	public DoSave(LibraryManager receiver) {
		super(Label.SAVE, receiver);
		_display = new Display();
		_inputForm = _form.addStringInput(Message.saveAs());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		String _filename;
		_display.clear();
		_form.parse();					//pede ao utilizador o form construido acima
		_filename=_inputForm.value();	//devolve o primeiro valor lido pelo form

		try{
			if(_filename.equals(null)){
				_display.add(Message.newSaveAs());
			} else {
				LibraryManager.saveAs(_filename);
			}
		} catch(MissingFileAssociationException | IOException ex) {

		}
	}
}
