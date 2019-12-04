package m19.core;

import java.io.Serializable;

public class Notification implements Serializable{
	private final String _message;

	public Notification(String label, Work work){
		_message = label + ": " + work.getDescription();
	}

	protected String getMessage(){
		return _message;
	}
}