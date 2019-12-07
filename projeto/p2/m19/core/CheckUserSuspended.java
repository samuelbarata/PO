package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.app.exception.RuleFailedException;

public class CheckUserSuspended extends Rule{
	/** Serial number for serialization. */
	private static final long serialVersionUID = 2724256104974790168L;
	private static final int ruleIndex = 2;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		if(!user.isActive()){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}