package m19.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import pt.tecnico.po.ui.DialogException;

import m19.core.exception.BadEntrySpecificationException;
import m19.app.exception.UserRegistrationFailedException;

public class Parser{

	private Library _library;

	/**
	 * Populates a given Library
	 * @param lib Library
	 */
	Parser(Library lib) {
		_library = lib;
	}

	/**
	 * Receives initial state textual representation and populates the library
	 * @param filename textual input
	 * @throws IOException
	 * @throws BadEntrySpecificationException
	 */
	public void parseFile(String filename) throws IOException, BadEntrySpecificationException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = reader.readLine()) != null)
				parseLine(line);
		}
	}

	/**
	 * split line into arguments and call respective functions
	 * @param line
	 * @throws BadEntrySpecificationException
	 */
	private void parseLine(String line) throws BadEntrySpecificationException {
		String[] components = line.split(":");

		switch(components[0]) {
			case "DVD":
				parseDVD(components, line);
				break;
			case "BOOK":
				parseBook(components, line);
				break;
			case "USER":
				parseUser(components, line);
				break;
				
			default:
				throw new BadEntrySpecificationException("Invalid type " + components[0] + " in line " + line);
		}
	}

	/**
	 * Creates and adds Dvd to library
	 * @param components
	 * @param line
	 * @throws BadEntrySpecificationException
	 */
	private void parseDVD(String[] components, String line) throws BadEntrySpecificationException {
		if (components.length != 7)
			throw new BadEntrySpecificationException("Wrong number of fields (6) in " + line);
		
		Dvd dvd = new Dvd(components[1], components[2], Integer.parseInt(components[3]),
						Category.valueOf(components[4]), Integer.parseInt(components[5]),
						Integer.parseInt(components[6]));
		
		_library.addWork(dvd);
	}

	/**
	 * Creates and adds Book to library 
	 * @param components
	 * @param line
	 * @throws BadEntrySpecificationException
	 */
	private void parseBook(String[] components, String line) throws BadEntrySpecificationException {
    	if (components.length != 7)
      		throw new BadEntrySpecificationException("Wrong number of fields (6) in " + line);

    	Book book = new Book(components[1], components[2], Integer.parseInt(components[3]),
							Category.valueOf(components[4]), Integer.parseInt(components[5]),
							Integer.parseInt(components[6]));
    
		_library.addWork(book);
	}

	/**
	 * Creates and adds User to library
	 * @param components
	 * @param line
	 * @throws BadEntrySpecificationException
	 */
	private void parseUser(String[] components, String line) throws BadEntrySpecificationException {
		if (components.length != 3)
			throw new BadEntrySpecificationException("Wrong number of fields (2) in " + line);
		try {
			User user = new User(components[1], components[2]);
			_library.addUser(user);
		} catch (UserRegistrationFailedException e) {
			throw new BadEntrySpecificationException("Cant create/add user: " + line);
		}
	}

}