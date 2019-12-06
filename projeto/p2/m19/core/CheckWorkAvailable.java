package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.app.exception.RuleFailedException;

public class CheckWorkAvailable extends Rule{

	private static final int ruleIndex = 3;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		if(work.getAvailable()<=0){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}