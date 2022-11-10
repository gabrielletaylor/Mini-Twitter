package model;

public class FindGroupVisitor extends Visitor {
	private UserGroup group;
	private String userGroupID;
	
	public FindGroupVisitor(String userGroupID) {
		this.userGroupID = userGroupID.toUpperCase();
	}
	
	public UserGroup getGroup() {
		return group;
	}

	@Override
	public void visitUser(User user) {}

	@Override
	public void visitGroup(UserGroup group) {
		if (group.getUniqueID().toUpperCase().equals(userGroupID)) {
			this.group = group;
		}
	}
}
