package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.app.exception.RuleFailedException;

public class CheckUserSpace extends Rule{

	private static final int ruleIndex = 4;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		int i = 0;
		for(Request requi : user.getRequests()){
			i++;
		}
		if(i>=user.getBehaviour().getMaxRequests()){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}