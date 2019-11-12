package m19.core;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.*;

import m19.core.exception.MissingFileAssociationException;
import m19.app.exception.UserRegistrationFailedException;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.core.exception.BadEntrySpecificationException;
import m19.core.exception.ImportFileException;

// FIXME import other system types
// FIXME import other project (core) types

/**
 * The façade class.
 */
public class LibraryManager {

	private static Library _library;

	// FIXME define other attributes

	public LibraryManager(){
		_library = new Library();
	}
	
	// FIXME define methods

	/**
	 * Serialize the persistent state of this application.
	 * 
	 * @throws MissingFileAssociationException if the name of the file to store the persistent
	 *         state has not been set yet.
	 * @throws IOException if some error happen during the serialization of the persistent state
	 * 
	*/
	public static void save() throws MissingFileAssociationException, IOException {
		//TODO: gravar por cima do nome anterior
	}

	/**
	 * Serialize the persistent state of this application into the specified file.
	 * 
	 * @param filename the name of the target file
	 *
	 * @throws MissingFileAssociationException if the name of the file to store the persistent
	 *         is not a valid one.
	 * @throws IOException if some error happen during the serialization of the persistent state
	 * 
	 * @see https://fenix.tecnico.ulisboa.pt/downloadFile/1689468335626781/11%20-%20Java%20IO.pdf slides 29;31
	 */
	public static void saveAs(String filename) throws MissingFileAssociationException, IOException {
		ObjectOutputStream obOut = null;
		try {
			FileOutputStream fpout = new FileOutputStream(filename);
			obOut = new ObjectOutputStream(fpout);
			obOut.writeObject(_library);
		} finally {
			if (obOut != null)
				obOut.close();
		}
	}

	/**
	 * Recover the previously serialized persitent state of this application.
	 * 
	 * @param filename the name of the file containing the perssitente state to recover
	 *
	 * @throws IOException if there is a reading error while processing the file
	 * @throws FileNotFoundException if the file does not exist
	 * @throws ClassNotFoundException 
	 */
	public static void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream obIn = null;
		try {
			FileInputStream fpin = new FileInputStream(filename);
			obIn = new ObjectInputStream(fpin);
			Object in = obIn.readObject();
			_library = (Library)in;
		} finally {
			if (obIn != null)
				obIn.close();
		}
	}

	/**
	 * Set the state of this application from a textual representation stored into a file.
	 * 
	 * @param datafile the filename of the file with the textual represntation of the state of this application.
	 * @throws ImportFileException if it happens some error during the parsing of the textual representation.
	 */
	public void importFile(String datafile) throws ImportFileException {
		try {
			_library.importFile(datafile);
		} catch (IOException | BadEntrySpecificationException e) {
			throw new ImportFileException(e);
		}
	}

	public static int getCurrentDate(){
		return _library.getCurrentDate();
	}

	public static void advanceDay(int nDays){
		_library.advanceDay(nDays);
	}

	public static void addUser(User user) throws UserRegistrationFailedException{
		_library.addUser(user);
	}

	public static String getWorkDescription(int id) throws NoSuchWorkException{
		return _library.getWorkDescription(id);
	}

	public static String getUserDescription(int id) throws NoSuchUserException{
		return _library.getUserDescription(id);
	}

	public static ArrayList<User> getAllUsers(){
		return _library.getAllUsers();
	}

	public static ArrayList<Work> getAllWorks(){
		return _library.getAllWorks();
	}

	public static ArrayList<Work> searchWork(String searchQuery){
		return _library.searchWork(searchQuery);
	}

	public static ArrayList<String> getUserNotifications(int id) throws NoSuchUserException{
		return _library.getUserNotifications(id);
	}
}
