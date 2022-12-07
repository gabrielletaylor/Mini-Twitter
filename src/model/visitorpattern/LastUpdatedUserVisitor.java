package model.visitorpattern;

import model.compositepattern.UserGroupComposite;
import model.compositepattern.UserLeaf;

public class LastUpdatedUserVisitor extends NodeVisitor {
	private long lastUpdateTime = 0;
	private UserLeaf userLeaf;
	
	public String getLastUpdateUser() {
		if (userLeaf != null) {
			return userLeaf.getUniqueID();
		}
		return "";
	}
	
	@Override
	public void visitUser(UserLeaf userLeaf) {
		if (lastUpdateTime < userLeaf.getLastUpdateTime()) {
			lastUpdateTime = userLeaf.getLastUpdateTime();
			this.userLeaf = userLeaf;
		}
	}

	@Override
	public void visitGroup(UserGroupComposite group) {}
	
}
