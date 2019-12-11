package m19.core;

import java.io.Serializable;
import m19.app.exception.RuleFailedException;

public abstract class Rule implements Serializable{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -5195846552106228044L;

	/**
	 * Checks if the user violates a rule
	 * 
	 * @param user
	 * @param work
	 * @throws RuleFailedException
	 */
	public abstract void checkRule(User user, Work work) throws RuleFailedException;

}