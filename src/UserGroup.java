import java.util.ArrayList;

public class UserGroup implements GroupComponent {
	private String uniqueID;
	private ArrayList<GroupComponent> users;
	
	public UserGroup(String uniqueID) {
		this.uniqueID = uniqueID.toUpperCase();
		users = new ArrayList<>();
	}

	@Override
	public String getUniqueID() {
		return uniqueID;
	}

	@Override
	public void add(GroupComponent group) {
		users.add(group);
	}

	@Override
	public GroupComponent getChild(int child) {
		return users.get(child);
	}

	@Override
	public int getIndexOfChild(GroupComponent group) {
		return users.indexOf(group);
	}

	@Override
	public int getChildCount() {
		return users.size();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitGroup(this);
		for (GroupComponent group : users) {
			group.accept(visitor);
		}
	}

	@Override
	public void openUserView() {
		for (GroupComponent group : users) {
			group.openUserView();
		}
	}
	
}
