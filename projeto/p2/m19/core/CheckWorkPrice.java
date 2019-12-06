package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.core.Request;
import m19.app.exception.RuleFailedException;

public class CheckWorkPrice extends Rule{

	private static final int ruleIndex = 6;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		
	}
}