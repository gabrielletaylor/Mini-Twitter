
public class FindUserVisitor implements Visitor {
	public User user;
	private String userID;
	
	public FindUserVisitor(String userID) {
		this.userID = userID.toLowerCase();
	}
	
	@Override
	public void visitUser(User user) {
		if (user.getUniqueID().toLowerCase().equals(userID)) {
			this.user = user;
		}
	}

	@Override
	public void visitGroup(UserGroup group) {
		
	}
}
