package m19.app.works;

import m19.core.LibraryManager;
import m19.app.works.Message;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.3.3. Perform search according to miscellaneous criteria.
 */
public class DoPerformSearch extends Command<LibraryManager> {

	private Display _display;
	private Input<String> _searchQuery;

	/**
	 * @param m
	 */
	public DoPerformSearch(LibraryManager m) {
		super(Label.PERFORM_SEARCH, m);
		_display = new Display();
		_searchQuery = _form.addStringInput(Message.requestSearchTerm());
	}

	/** @see pt.tecnico.po.ui.Command#execute() */
	@Override
	public final void execute() throws DialogException{
		String searchQuery;
		_display.clear();
		_form.parse(true);
		searchQuery = _searchQuery.value();
		_display.clear();
		for(String myString : _receiver.searchWork(searchQuery)){
			_display.addLine(myString);
		}
		_display.display();
	}
}
