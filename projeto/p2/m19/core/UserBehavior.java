package m19.core;

public enum UserBehavior{
	NORMAL("NORMAL", 3, 3, 8, 15), CUMPRIDOR("CUMPRIDOR", 5, 8, 15, 30), FALTOSO("FALTOSO", 1, 2, 2, 2);

	private String _behavior;
	private int _copies;
	private int _um;		//deadline 1 exemplar
	private int _umCinco;	//deadline 1-5 exemplares
	private int _cincoMais;	//deadline 5+ exemplares


	private UserBehavior(String behavior, int maxRequests, int a, int b, int c){
		_behavior=behavior;
		_copies = maxRequests;
		_um = a;
		_umCinco = b;
		_cincoMais = c;
	}

	public String toString(){
		return _behavior;
	}

	public int getMaxRequests(){
		return _copies;
	}

	public int getDeadline(int numeroExemplares){
		if(numeroExemplares==1){
			return _um;
		}
		if(numeroExemplares > 5){
			return _cincoMais;
		}
		return _umCinco;
	}
}