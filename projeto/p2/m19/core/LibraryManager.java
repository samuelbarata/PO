package m19.core;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.io.*;

import m19.core.exception.MissingFileAssociationException;
import m19.app.exception.UserRegistrationFailedException;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.core.exception.BadEntrySpecificationException;
import m19.core.exception.ImportFileException;

/**
 * The façade class.
 */
public class LibraryManager {

	private Library _library;
	private String _filename;

	/**
	 * Initializes Library Manager with empty Library and empty FileName
	 */
	public LibraryManager(){
		_library = new Library();
		_filename = new String();	//defaults to ""
	}
	
	/**
	 * Serialize the persistent state of this application.
	 * 
	 * @throws MissingFileAssociationException if the name of the file to store the persistent
	 *         state has not been set yet.
	 * @throws IOException if some error happen during the serialization of the persistent state
	 * 
	*/
	public void save() throws MissingFileAssociationException, IOException {
		saveAs(_filename);
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
	public void saveAs(String filename) throws MissingFileAssociationException, IOException {
		_filename=filename;
		if(_filename.isEmpty() || _filename.isBlank()){
			throw new MissingFileAssociationException();
		}
		ObjectOutputStream obOut = null;
		try {
			FileOutputStream fpout = new FileOutputStream(_filename);
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
	 * 
	 * @see https://fenix.tecnico.ulisboa.pt/downloadFile/1689468335626781/11%20-%20Java%20IO.pdf slides 30;32
	 */
	public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
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

	/**
	 * @return Associated filename
	 */
	public String getFilename(){
		return _filename;
	}

	/**
	 * @return current date as int
	 */
	public int getCurrentDate(){
		return _library.getCurrentDate();
	}

	/**
	 * Recives the Number of days to advance and forwards it to the Library
	 * @param nDays
	 */
	public void advanceDay(int nDays){
		_library.advanceDay(nDays);
	}

	/**
	 * Recices a User and send's it to the library to be added
	 * @param user
	 * @return User's Id
	 * @throws UserRegistrationFailedException
	 */
	public int addUser(User user) throws UserRegistrationFailedException{
		return _library.addUser(user);
	}

	/**
	 * Finds the Work with a given Id and returns its Description
	 * @param id Work Id
	 * @return Work's Description
	 * @throws NoSuchWorkException
	 */
	public String getWorkDescription(int id) throws NoSuchWorkException{
		return _library.getWorkDescription(id);
	}

	/**
	 * Finds the User with a given Id and returns its Description
	 * @param id Work Id
	 * @return User's Description
	 * @throws NoSuchUserException
	 */
	public String getUserDescription(int id) throws NoSuchUserException{
		return _library.getUserDescription(id);
	}

	/**
	 * Get's all user's descriptions ordered by alphabetical order
	 * @return List of Strings
	 */
	public List<String> getAllUsers(){
		return _library.getAllUsers();
	}

	/**
	 * Get's all work's descriptions ordered by id
	 * @returnList of Strings
	 */
	public List<String> getAllWorks(){
		return _library.getAllWorks();
	}

	/**
	 * Get's all the works that match the given searchQuery
	 * @param searchQuery
	 * @return List of Strings
	 */
	public List<String> searchWork(String searchQuery){
		return _library.searchWork(searchQuery);
	}

	/**
	 * Get's User's notifications
	 * @param id User id
	 * @return List of Strings
	 * @throws NoSuchUserException
	 */
	public List<String> getUserNotifications(int id) throws NoSuchUserException{
		return _library.getUserNotifications(id);
	}
}
