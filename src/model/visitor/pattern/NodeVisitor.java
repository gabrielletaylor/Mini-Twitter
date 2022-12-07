package model.visitor.pattern;

import model.composite.pattern.UserGroupComposite;
import model.composite.pattern.UserLeaf;

// abstract class to implement Visitor design pattern
public abstract class NodeVisitor {
	public void visitUser(UserLeaf userLeaf) {};
	public void visitGroup(UserGroupComposite group) {};
}
