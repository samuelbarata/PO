package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.app.exception.RuleFailedException;

public class CheckRequestTwice extends Rule{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -7528087457364595492L;
	private static final int ruleIndex = 1;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		for(Request reqi :user.getRequests()){
			if(reqi.getWork().equals(work)){
				throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
			}
		}
	}

}