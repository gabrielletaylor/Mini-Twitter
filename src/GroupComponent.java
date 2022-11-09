

public interface GroupComponent {
	public String getUniqueID();
    
    public void add(GroupComponent group);
    
    public GroupComponent getChild(int child);

    public int getIndexOfChild(GroupComponent group);
    
    public int getChildCount();
 
    public void accept(Visitor visitor);
        
    public void openUserView();
}
