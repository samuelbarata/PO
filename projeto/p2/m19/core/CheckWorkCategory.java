package m19.core;

import m19.app.exception.RuleFailedException;

/**
 * Rule 5
 */
public class CheckWorkCategory extends Rule{
	/** Serial number for serialization. */
	private static final long serialVersionUID = 7527408906572355191L;
	private static final int ruleIndex = 5;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		if(work.getCategory()==Category.REFERENCE){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}