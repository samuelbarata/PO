package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.app.exception.RuleFailedException;

/**
 * Rule 3
 */
public class CheckWorkAvailable extends Rule{
	/** Serial number for serialization. */
	private static final long serialVersionUID = 8662012092706950258L;
	private static final int ruleIndex = 3;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		if(work.getAvailable()<=0){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}