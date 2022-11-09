import java.util.ArrayList;

public class User extends Subject implements Observer, GroupComponent {
	private String uniqueID;
	private ArrayList<User> following, followers;
	private ArrayList<String> tweets, newsFeed;
	private GroupComponentTree userGroupTree;
	private UserView userView;
	
	public User(GroupComponentTree userGroupTree, String uniqueID) {
		this.userGroupTree = userGroupTree;
		this.uniqueID = uniqueID.toLowerCase();
		userView = new UserView(this);
		
		
	}
	
	public ArrayList<String> getTweets() {
		return tweets;
	}
	
	public String getLastTweet() {
		return tweets.get(tweets.size() - 1);
	}
	
	public void postTweet(String tweet) {
		tweets.add(tweet);
		notifyObservers();
	}
	
	public void postToNewsFeed(String tweet) {
		newsFeed.add(tweet);
		userView.addTweetToNewsFeed(tweet);
	}
	
	public boolean followUser(String userID) {
		User user = (User) userGroupTree.findUserByID((GroupComponent) userGroupTree.getRoot(), userID);
		if (user != null && !following.contains(user)) {
			user.attach(this);
			following.add(user);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String getUniqueID() {
		return uniqueID;
	}
	
	@Override
	public void add(GroupComponent group) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public GroupComponent getChild(int child) {
		return null;
	}
	
	@Override
	public int getIndexOfChild(GroupComponent group) {
		return -1;
	}
	
	@Override
	public int getChildCount() {
		return 0;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitUser(this);
	}
	
	@Override
	public void openUserView() {
		userView.setVisible(true);
	}
	
//	@Override
//	public void update() {
//		// TODO Auto-generated method stub
//		
//	}
	
	@Override
	public void update(Subject subject) {
		if (subject instanceof User) {
			postToNewsFeed(((User) subject).getUniqueID() + ": " + ((User) subject).getLastTweet());
		}
	}
	
	
}
