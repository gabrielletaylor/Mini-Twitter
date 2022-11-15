package model;

// interface to implement Composite design pattern
public interface UserGroupComponent {
	public String getUniqueID();
    
    public void add(UserGroupComponent group);
    
    public UserGroupComponent getChild(int child);

    public int getIndexOfChild(UserGroupComponent group);
    
    public int getChildCount();
 
    public void accept(NodeVisitor nodeVisitor);
        
    public void openUserView();
}
