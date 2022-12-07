package model.visitorpattern;

import model.compositepattern.UserGroupComposite;
import model.compositepattern.UserLeaf;

public class FindUserVisitor extends NodeVisitor {
	private UserLeaf userLeaf;
	private String userID;
	
	public FindUserVisitor(String userID) {
		this.userID = userID.toLowerCase();
	}
	
	public UserLeaf getUser() {
		return userLeaf;
	}
	
	@Override
	public void visitUser(UserLeaf userLeaf) {
		if (userLeaf.getUniqueID().toLowerCase().equals(userID)) {
			this.userLeaf = userLeaf;
		}
	}

	@Override
	public void visitGroup(UserGroupComposite group) {}
}
