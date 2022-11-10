package model;

public class GroupTotalVisitor implements Visitor {
	
	private int totalGroups;
	
	public int getTotalGroups() {
		return totalGroups;
	}

	@Override
	public void visitUser(User user) {}

	@Override
	public void visitGroup(UserGroup group) {
		totalGroups++;
	}

}
