package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.app.exception.RuleFailedException;

public class CheckUserSuspended extends Rule{

	private static final int ruleIndex = 2;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		if(!user.isActive()){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}