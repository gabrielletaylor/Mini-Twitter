
public class FindUserVisitor implements Visitor {
	private User user;
	private String userID;
	
	public FindUserVisitor(String userID) {
		this.userID = userID.toLowerCase();
	}
	
	public User getUser() {
		return user;
	}
	
	@Override
	public void visitUser(User user) {
		if (user.getUniqueID().toLowerCase().equals(userID)) {
			this.user = user;
		}
	}

	@Override
	public void visitGroup(UserGroup group) {}
}
