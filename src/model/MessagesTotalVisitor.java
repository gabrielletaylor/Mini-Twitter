package model;

public class MessagesTotalVisitor implements Visitor {
	
	private int totalMessages;
	
	public int getTotalMessages() {
		return totalMessages;
	}

	@Override
	public void visitUser(User user) {
		totalMessages += user.getTweets().size();
	}

	@Override
	public void visitGroup(UserGroup group) {}
}
