package model.visitor.pattern;

import model.composite.pattern.UserGroupComposite;
import model.composite.pattern.UserLeaf;

public class FindGroupVisitor extends NodeVisitor {
	private UserGroupComposite group;
	private String userGroupID;
	
	public FindGroupVisitor(String userGroupID) {
		this.userGroupID = userGroupID.toUpperCase();
	}
	
	public UserGroupComposite getGroup() {
		return group;
	}

	@Override
	public void visitUser(UserLeaf userLeaf) {}

	@Override
	public void visitGroup(UserGroupComposite group) {
		if (group.getUniqueID().toUpperCase().equals(userGroupID)) {
			this.group = group;
		}
	}
}
