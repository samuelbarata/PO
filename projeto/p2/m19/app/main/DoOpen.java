package m19.app.main;

import java.io.IOException;
import java.io.FileNotFoundException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

import m19.core.LibraryManager;
import m19.app.exception.FileOpenFailedException;

/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager>{

	private Input<String> _inputForm;

	/**
	 * @param receiver
	 */
	public DoOpen(LibraryManager receiver) {
		super(Label.OPEN, receiver);
		_inputForm = _form.addStringInput(Message.openFile());
	
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		String _filename;
		_form.parse();					//pede ao utilizador o form construido acima
		_filename=_inputForm.value();	//devolve o primeiro valor lido pelo form

		try {
			_receiver.load(_filename);
		} catch (FileNotFoundException fnfe) {
			throw new FileOpenFailedException(_filename);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
