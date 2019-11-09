package m19.core;

public enum UserBehavior{
	NORMAL("Normal"), CUMPRIDOR("Cumpridor"), FALTOSO("Faltoso");

	//TODO: preceber esta cena

	private String _behavior;


	private UserBehavior(String behavior){
		_behavior=behavior;
	}

	public String toString(){
		return _behavior;
	}
}