package m19.core;

public class Notification{
	private final String _message;

	public Notification(String label, Work work){
		_message = label + ": " + work.getDescription();
	}

	protected String getMessage(){
		return _message;
	}
}