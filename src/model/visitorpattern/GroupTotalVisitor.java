package model.visitorpattern;

import model.compositepattern.UserGroupComposite;
import model.compositepattern.UserLeaf;

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
