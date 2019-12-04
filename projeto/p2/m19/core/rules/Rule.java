package m19.core.rules;

import java.io.Serializable;

public abstract class Rule implements Serializable{
	private int _id;

	public Rule(){

	}

	protected int getId(){
		return _id;
	}
}