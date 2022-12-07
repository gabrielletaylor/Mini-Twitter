package model.visitor.pattern;

import model.composite.pattern.UserGroupComponent;
import model.composite.pattern.UserGroupComposite;
import model.composite.pattern.UserLeaf;

public class ValidUserVisitor extends NodeVisitor {
	private int invalidIDs;
	private UserGroupComponent root;
	
	public ValidUserVisitor(UserGroupComponent root) {
		this.root = root;
	}
	
	public int getInvalidIDs() {
		return invalidIDs;
	}
	
	@Override
	public void visitUser(UserLeaf userLeaf) {
		FindGroupVisitor visitor = new FindGroupVisitor(userLeaf.getUniqueID());
		root.accept(visitor);
		if (userLeaf.getUniqueID().contains(" ") || visitor.getGroup() != null) {
			invalidIDs++;
		}
	}

	@Override
	public void visitGroup(UserGroupComposite group) {
		FindUserVisitor visitor = new FindUserVisitor(group.getUniqueID());
		root.accept(visitor);
		if (group.getUniqueID().contains(" ") || visitor.getUser() != null) {
			invalidIDs++;
		}
	}
	
}
