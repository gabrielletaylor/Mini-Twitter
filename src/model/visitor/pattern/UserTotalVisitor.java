package model.visitor.pattern;

import model.composite.pattern.UserGroupComposite;
import model.composite.pattern.UserLeaf;

public class UserTotalVisitor extends NodeVisitor {
	
	private int totalUsers;
	
	public int getTotalUsers() {
		return totalUsers;
	}

	@Override
	public void visitUser(UserLeaf userLeaf) {
		totalUsers++;
	}

	@Override
	public void visitGroup(UserGroupComposite group) {}
}
