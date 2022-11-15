package model;

public class MessagesTotalVisitor extends NodeVisitor {
	
	private int totalMessages;
	
	public int getTotalMessages() {
		return totalMessages;
	}

	@Override
	public void visitUser(UserLeaf userLeaf) {
		totalMessages += userLeaf.getTweets().size();
	}

	@Override
	public void visitGroup(UserGroupComposite group) {}
}
