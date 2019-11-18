package m19.app.main;

import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;

/** 4.1. Main menu. */
public class Menu extends pt.tecnico.po.ui.Menu {

	/**
	 * @param receiver
	 */
	public Menu(LibraryManager receiver) {
		super(Label.TITLE, new Command<?>[] {	//4.1
			new DoOpen(receiver),				//1	open from file
			new DoSave(receiver),               //2	save to file
			new DoDisplayDate(receiver),        //3	Shows current date
			new DoAdvanceDate(receiver),        //4	advances date
			new DoOpenUsersMenu(receiver),      //5	Shows User's Menu
			new DoOpenWorksMenu(receiver),      //6	Shows Work's Menu
			new DoOpenRequestsMenu(receiver),   //7	Shows Requests Menu
		});
	}

}
