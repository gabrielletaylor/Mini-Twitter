package view;

import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.User;

public class UserView extends FormatUI {
	private User user;
	private JLabel userIDLabel, tweetMessageLabel, currentFollowingLabel, newsFeedLabel;
	private JPanel userPanel, followingPanel, tweetPanel, newsFeedPanel;
	private JScrollPane followingScrollPane, newsFeedScrollPane;
	private JTextField userID, tweetMessage;
	private JButton followUser, postTweet;
	private JList<String> followingList, newsFeedList;
	private DefaultListModel<String> followingListModel, newsFeedListModel;
	
	public UserView(User user) {
		this.user = user;
	}
	
	// method that displays user view panel for specific user
	public void displayUserViewPanel() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Mini Twitter - @" + user.getUniqueID());
        setSize(500, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // follow user panel
        userPanel = new JPanel();
        stylePanel(userPanel, 10, 10, 480, 90);
        userIDLabel = new JLabel("User ID");
        userIDLabel.setBounds(10, 5, 240, 20);
        userPanel.add(userIDLabel);
        // text area for user ID
        userID = new JTextField();
        userID.setBounds(5, 25, 240, 60);
        userPanel.add(userID);
        // button to follow user
        followUser = new JButton("Follow User");
        styleButton(followUser, 250, 30, 225, 50);
        userPanel.add(followUser);
        
        // current following panel
        followingPanel = new JPanel();
        stylePanel(followingPanel, 10, 110, 480, 190);
        currentFollowingLabel = new JLabel("Current Following");
        currentFollowingLabel.setBounds(10, 5, 480, 20);
        followingPanel.add(currentFollowingLabel);
        // scrolling area list view for current following
        followingListModel = new DefaultListModel<String>();
        followingList = new JList<String>(followingListModel);
        followingScrollPane = new JScrollPane(followingList);
        followingScrollPane.setBounds(5, 30, 470, 155);
        followingScrollPane.setBorder(BorderFactory.createEmptyBorder());
        followingPanel.add(followingScrollPane);
        
        // post tweet panel
        tweetPanel = new JPanel();
        stylePanel(tweetPanel, 10, 310, 480, 90);
        tweetMessageLabel = new JLabel("Tweet Message");
        tweetMessageLabel.setBounds(10, 5, 240, 20);
        tweetPanel.add(tweetMessageLabel);
        // text area for tweet message
        tweetMessage = new JTextField();
        tweetMessage.setBounds(5, 25, 320, 60);
        tweetPanel.add(tweetMessage);
        // button to post tweet
        postTweet = new JButton("Post Tweet");
        styleButton(postTweet, 330, 30, 145, 50);
        tweetPanel.add(postTweet);
        
        // news feed panel
        newsFeedPanel = new JPanel();
        stylePanel(newsFeedPanel, 10, 410, 480, 250);
        newsFeedLabel = new JLabel("News Feed");
        newsFeedLabel.setBounds(10, 5, 480, 20);
        newsFeedPanel.add(newsFeedLabel);
        // scrolling area list view for news feed
        newsFeedListModel = new DefaultListModel<String>();
        newsFeedList = new JList<String>(newsFeedListModel);
        newsFeedScrollPane = new JScrollPane(newsFeedList);
        newsFeedScrollPane.setBounds(5, 30, 470, 215);
        newsFeedScrollPane.setBorder(BorderFactory.createEmptyBorder());
        newsFeedPanel.add(newsFeedScrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == followUser) {
			followUser();
		}
		if (e.getSource() == postTweet) {
			postTweet();
		}
	}

	// method to add tweet to news feed
	public void addTweetToNewsFeed(String tweet) {
		newsFeedListModel.add(0, " -  @" + tweet);
	}
	
	// method to follow user as long as user exists
	public void followUser() {
		String followUserID = userID.getText();
		if (followUserID != "") {
			if (user.followUser(followUserID)) {
				followingListModel.add(0, " -  @" + followUserID);
			}
			else {
				displayErrorMessage("Follow User Error", "Error: Could not follow user " + followUserID + ".");
			}
			userID.setText("");
		}
	}
	
	// method to post tweet
	public void postTweet() {
		String tweet = tweetMessage.getText();
		if (tweet != "") {
			user.postTweet(tweet);
			tweetMessage.setText("");
		}
	}
}
