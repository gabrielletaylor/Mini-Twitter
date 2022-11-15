package model;
import java.util.ArrayList;
import view.UserView;

// composite class under component to follow Composite design pattern
// also implements Observer design pattern for updating news feed
public class UserLeaf extends Subject implements Observer, UserGroupComponent {
	private String uniqueID;
	private ArrayList<UserLeaf> following, followers;
	private ArrayList<String> tweets, newsFeed;
	private TreeView userGroupTree;
	private UserView userView;
	
	public UserLeaf(TreeView userGroupTree, String uniqueID) {
		this.userGroupTree = userGroupTree;
		this.uniqueID = uniqueID.toLowerCase();
		userView = new UserView(this);
		following = new ArrayList<>();
		followers = new ArrayList<>();
		tweets = new ArrayList<>();
		newsFeed = new ArrayList<>();
		userView.displayUserViewPanel();
		attach(this);
		following.add(this);
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
		UserLeaf userLeaf = (UserLeaf) userGroupTree.findUserByID((UserGroupComponent) userGroupTree.getRoot(), userID);
		if (userLeaf != null && !following.contains(userLeaf)) {
			userLeaf.attach(this);
			following.add(userLeaf);
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
	public void add(UserGroupComponent group) {
		userView.displayErrorMessage("User Error", "Error: Cannot add user to a user.");
	}
	
	@Override
	public UserGroupComponent getChild(int child) {
		return null;
	}
	
	@Override
	public int getIndexOfChild(UserGroupComponent group) {
		return -1;
	}
	
	@Override
	public int getChildCount() {
		return 0;
	}
	
	@Override
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visitUser(this);
	}
	
	@Override
	public void openUserView() {
		userView.setVisible(true);
	}
	
	@Override
	public void update(Subject subject) {
		if (subject instanceof UserLeaf) {
			postToNewsFeed(((UserLeaf) subject).getUniqueID() + ": " + ((UserLeaf) subject).getLastTweet());
		}
	}
}
