package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.app.exception.RuleFailedException;

public class CheckUserSpace extends Rule{
	/** Serial number for serialization. */
	private static final long serialVersionUID = 4022831768861609022L;
	private static final int ruleIndex = 4;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		if(user.getRequests().size()>=user.getBehaviour().getMaxRequests()){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}