package model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class GroupComponentTree implements TreeModel {
	private GroupComponent root;                   
    private List<TreeModelListener> listeners;
    
    public GroupComponentTree(GroupComponent root) {
        this.root = root;
        listeners = new ArrayList<>();
    }
    
    public GroupComponent findUserByID(GroupComponent parent, String id) {
        FindUserVisitor visitor = new FindUserVisitor(id);
        parent.accept(visitor);
        return visitor.getUser();
    }
    
    public GroupComponent findGroupByID(GroupComponent parent, String id) {
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
    
    public void addGroupComponent(GroupComponent parent, GroupComponent newComponent) {
        parent.add(newComponent);
        updateTree();
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        return (GroupComponent) ((GroupComponent) parent).getChild(index);
    }

    @Override
    public int getChildCount(Object parent) {
        return ((GroupComponent) parent).getChildCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((GroupComponent) node).getChildCount() == 0;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return ((GroupComponent) parent).getIndexOfChild((GroupComponent) child);
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
