package model;

// abstract class to implement Visitor design pattern
public abstract class Visitor {
	public void visitUser(User user) {};
	public void visitGroup(UserGroup group) {};
}
