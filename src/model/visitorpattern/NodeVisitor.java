package model.visitorpattern;

import model.compositepattern.UserGroupComposite;
import model.compositepattern.UserLeaf;

// abstract class to implement Visitor design pattern
public abstract class NodeVisitor {
	public void visitUser(UserLeaf userLeaf) {};
	public void visitGroup(UserGroupComposite group) {};
}
