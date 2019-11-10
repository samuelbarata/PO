package m19.app.main;

import pt.tecnico.po.ui.Form;

import java.io.IOException;
import java.io.FileNotFoundException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;


import m19.core.LibraryManager;
import m19.app.exception.FileOpenFailedException;

/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager> implements Message{

	// FIXME define input fields if needed

	/**
	 * @param receiver
	 */
	public DoOpen(LibraryManager receiver) {
		super(Label.OPEN, receiver);
		// FIXME initialize input fields if needed
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException {
		//FIXME: n sei receber input do utilizador com a Class Form; https://stackoverflow.com/questions/58785543/how-to-read-a-string-using-class-form-in-java
		String filename;

		Form form = new Form();
		form.addStringInput(Message.openFile());

		filename = form.entry(0);

		try {
			LibraryManager.load(filename);
		} catch (FileNotFoundException fnfe) {
			throw new FileOpenFailedException(filename);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}
