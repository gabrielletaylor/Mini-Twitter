package model.compositepattern;
import java.util.ArrayList;

import model.visitorpattern.NodeVisitor;

//composite class under component to follow Composite design pattern
public class UserGroupComposite implements UserGroupComponent {
	private String uniqueID;
	private ArrayList<UserGroupComponent> users;
	private long creationTime;
	
	public UserGroupComposite(String uniqueID) {
		this.uniqueID = uniqueID.toUpperCase();
		users = new ArrayList<>();
		creationTime = System.currentTimeMillis();
	}
	
	@Override
	public long getCreationTime() {
		return creationTime;
	}

	@Override
	public void setCreationTime() {
		this.creationTime = System.currentTimeMillis();
	}
	
	@Override
	public String getUniqueID() {
		return uniqueID;
	}

	@Override
	public void add(UserGroupComponent group) {
		users.add(group);
	}

	@Override
	public UserGroupComponent getChild(int child) {
		return users.get(child);
	}

	@Override
	public int getIndexOfChild(UserGroupComponent group) {
		return users.indexOf(group);
	}

	@Override
	public int getChildCount() {
		return users.size();
	}

	@Override
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visitGroup(this);
		for (UserGroupComponent group : users) {
			group.accept(nodeVisitor);
		}
	}

	@Override
	public void openUserView() {
		for (UserGroupComponent group : users) {
			group.openUserView();
		}
	}
	
}
