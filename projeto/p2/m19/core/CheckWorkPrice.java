package m19.core;

import m19.app.exception.RuleFailedException;

/**
 * Rule 6
 */
public class CheckWorkPrice extends Rule{
	/** Serial number for serialization. */
	private static final long serialVersionUID = -769425412110510035L;
	private static final int ruleIndex = 6;
	/** price limit para quem não é CUMPRIDOR*/
	private static final int PRICE_LIMIT = 25;

	@Override
	public void checkRule(User user, Work work) throws RuleFailedException{
		if(user.getBehaviour() != UserBehavior.CUMPRIDOR && work.getPrice()>PRICE_LIMIT){
			throw new RuleFailedException(user.getId(), work.getId(), ruleIndex);
		}
	}
}