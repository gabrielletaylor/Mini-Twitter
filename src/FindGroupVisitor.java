
public class FindGroupVisitor implements Visitor {
	public UserGroup group;
	private String userGroupID;
	
	public FindGroupVisitor(String userGroupID) {
		this.userGroupID = userGroupID.toUpperCase();
	}

	@Override
	public void visitUser(User user) {
		
	}

	@Override
	public void visitGroup(UserGroup group) {
		if (group.getUniqueID().toUpperCase().equals(userGroupID)) {
			this.group = group;
		}
	}

}
