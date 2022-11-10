package model;

public class UserTotalVisitor implements Visitor {
	
	private int totalUsers;
	
	public int getTotalUsers() {
		return totalUsers;
	}

	@Override
	public void visitUser(User user) {
		totalUsers++;
	}

	@Override
	public void visitGroup(UserGroup group) {}
}
