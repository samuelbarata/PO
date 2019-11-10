package m19.app.main;

import java.io.IOException;

import m19.core.LibraryManager;
import m19.core.exception.MissingFileAssociationException;

import pt.tecnico.po.ui.Command;

// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> implements Message{
  
	// FIXME define input fields

	/**
	 * @param receiver
	 */
	public DoSave(LibraryManager receiver) {
		super(Label.SAVE, receiver);
		// FIXME initialize input fields
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() {
		//TODO ask for filename Message.saveAs(); copiar do DoOpen.java depois de feito

		/*try{
			if(name)
				LibraryManager.saveAs(name);
			else
				//TODO warn: Message.newSaveAs();
				LibraryManager.save();
		} catch(MissingFileAssociationException | IOException ex) {

		}*/
	}
}
