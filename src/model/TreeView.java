package model;
import java.util.ArrayList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class TreeView implements TreeModel {
	private UserGroupComponent root;                   
    private ArrayList<TreeModelListener> listeners;
    
    public TreeView(UserGroupComponent root) {
        this.root = root;
        listeners = new ArrayList<>();
    }
    
    public UserGroupComponent findUserByID(UserGroupComponent parent, String id) {
        FindUserVisitor visitor = new FindUserVisitor(id);
        parent.accept(visitor);
        return visitor.getUser();
    }
    
    public UserGroupComponent findGroupByID(UserGroupComponent parent, String id) {
        FindGroupVisitor visitor = new FindGroupVisitor(id);
        parent.accept(visitor);
        return visitor.getGroup();
    }
    
    public boolean findUserInTree(String id) {
    	FindUserVisitor visitor = new FindUserVisitor(id);
    	root.accept(visitor);
    	if (visitor.getUser() != null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    private void updateTree()
    {
        Object[] o = {root};
        TreeModelEvent e = new TreeModelEvent(this, o);
        for (TreeModelListener l : listeners){
            l.treeStructureChanged(e);
        }
    }
    
    public void addGroupComponent(UserGroupComponent parent, UserGroupComponent newComponent) {
        parent.add(newComponent);
        updateTree();
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        return (UserGroupComponent) ((UserGroupComponent) parent).getChild(index);
    }

    @Override
    public int getChildCount(Object parent) {
        return ((UserGroupComponent) parent).getChildCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((UserGroupComponent) node).getChildCount() == 0;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return ((UserGroupComponent) parent).getIndexOfChild((UserGroupComponent) child);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);
    }   
}
