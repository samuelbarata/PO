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

	protected String getMessage(){
		return _message;
	}

	protected NotiType getType(){
		return _type;
	}

	protected Work getWork(){
		return _work;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof Notification){
			Notification other = (Notification) o;
			return this.getType().equals(other.getType()) && this.getWork().equals(other.getWork());
		}
		return false;
	}
}