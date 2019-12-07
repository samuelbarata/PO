package m19.core;

public enum UserBehavior{
	NORMAL("NORMAL", 3, 3, 8, 15){
		@Override
		protected UserBehavior updateState(int behaviourCounter){
			if(behaviourCounter>=5){
				return CUMPRIDOR;
			}
			if(behaviourCounter<=-3){
				return FALTOSO;
			}
			return this;
		}
	}, CUMPRIDOR("CUMPRIDOR", 5, 8, 15, 30){
		@Override
		protected UserBehavior updateState(int behaviourCounter){
			if(behaviourCounter<0){
				return NORMAL;
			}
			return this;
		}

	}, FALTOSO("FALTOSO", 1, 2, 2, 2){
		@Override
		protected UserBehavior updateState(int behaviourCounter){
			if(behaviourCounter>=3){
				return NORMAL;
			}
			return this;
		}
	};

	private final String _behavior;
	private final int _copies;
	private final int _um;		//deadline 1 exemplar
	private final int _umCinco;	//deadline 1-5 exemplares
	private final int _cincoMais;	//deadline 5+ exemplares
	private int _behaviorCounter;

	/**
	 * 
	 * @param behavior Textual representation of the state
	 * @param maxRequests Maximum Requests User can have at a given time
	 * @param a	Deadline 1 copy
	 * @param b Deadline 1-5 copies
	 * @param c Deadline 5+ copies
	 */
	private UserBehavior(String behavior, int maxRequests, int a, int b, int c){
		_behavior=behavior;
		_copies = maxRequests;
		_um = a;
		_umCinco = b;
		_cincoMais = c;
		_behaviorCounter=0;
	}

	public String toString(){
		return _behavior;
	}

	/**
	 * @return maximum requests this user can have at a given time
	 */
	public int getMaxRequests(){
		return _copies;
	}

	/**
	 * @param numeroExemplares
	 * @return deadline acording to user behaviour and number of work's copies
	 */
	public int getDeadline(int numeroExemplares){
		if(numeroExemplares==1){
			return _um;
		}
		if(numeroExemplares > 5){
			return _cincoMais;
		}
		return _umCinco;
	}

	/**
	 * changes the behaviour counter
	 * @return new user behaviour
	 */
	protected UserBehavior goodReturn(){
		_behaviorCounter= _behaviorCounter>0 ? _behaviorCounter+1 : 1;
		return updateState(_behaviorCounter);
	}

	/**
	 * changes the behaviour counter
	 * @return new user behaviour
	 */
	protected UserBehavior badReturn(){
		_behaviorCounter= _behaviorCounter > 0 ? -1 : _behaviorCounter-1;
		return updateState(_behaviorCounter);
	}

	/**
	 * Updates the User's Behavior
	 * @param behaviourCounter
	 * @return new User's Behaviour
	 * 
	 * @see https://www.baeldung.com/java-enum-simple-state-machine
	 */
	protected abstract UserBehavior updateState(int behaviourCounter);
}