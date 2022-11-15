package model;

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
