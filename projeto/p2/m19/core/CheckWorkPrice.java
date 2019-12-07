package m19.core;

import m19.core.User;
import m19.core.Work;
import m19.app.exception.RuleFailedException;

public class CheckWorkPrice extends Rule{

	private static final long serialVersionUID = 1L;
	private static final int ruleIndex = 6;
	private static final int PRICE_LIMIT = 25;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		if(user.getBehaviour() != UserBehavior.CUMPRIDOR && work.getPrice()>PRICE_LIMIT){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}