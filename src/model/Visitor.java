package model;

public abstract class Visitor {
	public void visitUser(User user) {};
	public void visitGroup(UserGroup group) {};
}
