package m19.core;

public enum UserBehavior{
	NORMAL("NORMAL", 3), CUMPRIDOR("CUMPRIDOR", 5), FALTOSO("FALTOSO", 1);

	private String _behavior;
	private int _copies;

	private UserBehavior(String behavior, int maxRequests){
		_behavior=behavior;
		_copies = maxRequests;
	}

	public String toString(){
		return _behavior;
	}

	public int getMaxRequests(){
		return _copies;
	}
}