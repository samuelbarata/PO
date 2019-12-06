package m19.core;

import m19.app.exception.RuleFailedException;
import m19.core.User;
import m19.core.Work;

public abstract class Rule{

	/**
	 * Checks if user violates a rule
	 * @param user
	 * @param work
	 * @throws RuleFailedException
	 */
	public abstract void checkRule(User user, Work work) throws RuleFailedException;

	public Rule(){}

}