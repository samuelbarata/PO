package m19.core;

import java.io.Serializable;

public class Notification implements Serializable{
	/** Serial number for serialization. */
	private static final long serialVersionUID = 7464590430015610640L;
	private final String _message;
	private final NotiType _type;
	private final Work _work;

	public Notification(NotiType label, Work work){
		_type = label;
		_work = work;
		_message = label + ": " + work.getDescription();
	}

	/**
	 * @return Notification Message
	 */
	protected String getMessage(){
		return _message;
	}

	@Override
	public String toString(){
		return this.getMessage();
	}

	/**
	 * @return Notification type
	 */
	protected NotiType getType(){
		return _type;
	}

	/**
	 * @return The Work associated with this notification
	 */
	protected Work getWork(){
		return _work;
	}
}