package model.visitor.pattern;

import model.composite.pattern.UserGroupComposite;
import model.composite.pattern.UserLeaf;

public class GroupTotalVisitor extends NodeVisitor {
	
	private int totalGroups;
	
	public int getTotalGroups() {
		return totalGroups;
	}

	@Override
	public void visitUser(UserLeaf userLeaf) {}

	@Override
	public void visitGroup(UserGroupComposite group) {
		totalGroups++;
	}

}
