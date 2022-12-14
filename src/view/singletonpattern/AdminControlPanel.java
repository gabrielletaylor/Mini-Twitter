package view.singletonpattern;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;

import model.compositepattern.UserGroupComponent;
import model.compositepattern.UserGroupComposite;
import model.compositepattern.UserLeaf;
import model.visitorpattern.GroupTotalVisitor;
import model.visitorpattern.LastUpdatedUserVisitor;
import model.visitorpattern.MessagesTotalVisitor;
import model.visitorpattern.PositivePercentageVisitor;
import model.visitorpattern.UserTotalVisitor;
import model.visitorpattern.ValidUserVisitor;
import view.ui.FormatUI;
import view.ui.TreeView;
import view.ui.TreeViewRenderer;

public class AdminControlPanel extends FormatUI implements ActionListener {
    private JTextField userID, groupID;
    private JButton addUser, addGroup, openUserView, showUserTotal,
					showGroupTotal, showMessagesTotal, showPositivePercentage,
					validateUser, lastUpdatedUser;
    private JLabel userIDLabel, groupIDLabel;
    private JPanel treeViewPanel, userGroupPanel, informationPanel, openUserViewPanel;
    private JTree tree;
    private JScrollPane treeScrollPane;
    private UserGroupComponent root;
    private TreeView userGroupTree;
    private static final AdminControlPanel instance = new AdminControlPanel();
	
	private AdminControlPanel() {}
	
	public static AdminControlPanel getInstance() {
		return instance;
	}
	
	public void displayPanel() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mini Twitter - Admin Control Panel");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // tree view panel
        treeViewPanel = new JPanel();
        treeViewPanel.setBackground(Color.white);       
        stylePanel(treeViewPanel, 10, 10, 375, 550);
        // create new group with title Root
        root = new UserGroupComposite("Root");
        userGroupTree = new TreeView(root);
        tree = new JTree(userGroupTree);
        tree.setCellRenderer(new TreeViewRenderer());
        styleTree(tree, 10, 10, 375, 550);
        treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setBounds(5, 5, 365, 540);
        treeScrollPane.setBorder(BorderFactory.createEmptyBorder());
        treeViewPanel.add(treeScrollPane);
        
        // add user and add group panel
        userGroupPanel = new JPanel();
        stylePanel(userGroupPanel, 395, 10, 495, 200);
        userIDLabel = new JLabel("User ID");
        userIDLabel.setBounds(10, 5, 305, 20);
        userGroupPanel.add(userIDLabel);
        groupIDLabel = new JLabel("Group ID");
        groupIDLabel.setBounds(10, 115, 305, 20);
        userGroupPanel.add(groupIDLabel);
        userID = new JTextField();
        userID.setBounds(5, 25, 305, 60);
        userGroupPanel.add(userID);
        groupID = new JTextField();
        groupID.setBounds(5, 135, 305, 60);
        userGroupPanel.add(groupID);
        addUser = new JButton("Add User");
        styleButton(addUser, 315, 30, 175, 50);
        userGroupPanel.add(addUser);
        addGroup = new JButton("Add Group");
        styleButton(addGroup, 315, 140, 175, 50);
        userGroupPanel.add(addGroup);
        
        // open user view panel
        openUserViewPanel = new JPanel();
        stylePanel(openUserViewPanel, 395, 240, 495, 80);
        openUserView = new JButton("Open User View");
        styleButton(openUserView, 5, 15, 485, 50);
        openUserViewPanel.add(openUserView);
        
        // analysis features panel
        informationPanel = new JPanel();
        stylePanel(informationPanel, 395, 350, 495, 210);
        validateUser = new JButton("Validate Users");
        styleButton(validateUser, 5, 15, 240, 50);
        informationPanel.add(validateUser);
        lastUpdatedUser = new JButton("Last Updated User");
        styleButton(lastUpdatedUser, 250, 15, 240, 50);
        informationPanel.add(lastUpdatedUser);
        showUserTotal = new JButton("Show User Total");
        styleButton(showUserTotal, 5, 80, 240, 50);
        informationPanel.add(showUserTotal);
        showGroupTotal = new JButton("Show Group Total");
        styleButton(showGroupTotal, 250, 80, 240, 50);
        informationPanel.add(showGroupTotal);
        showMessagesTotal = new JButton("Show Messages Total");
        styleButton(showMessagesTotal, 5, 145, 240, 50);
        informationPanel.add(showMessagesTotal);
        showPositivePercentage = new JButton("Show Positive Percentage");
        styleButton(showPositivePercentage, 250, 145, 240, 50);
        informationPanel.add(showPositivePercentage);
        
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addUser) {
			addUser();
		}
		else if (e.getSource() == addGroup) {
			addGroup();
		}
		else if (e.getSource() == openUserView) {
			openUserView();
		}
		else if (e.getSource() == validateUser) {
			validateUser();
		}
		else if (e.getSource() == lastUpdatedUser) {
			lastUpdatedUser();
		}
		else if (e.getSource() == showUserTotal) {
			showUserTotal();
		}
		else if (e.getSource() == showGroupTotal) {
			showGroupTotal();
		}
		else if (e.getSource() == showMessagesTotal) {
			showMessagesTotal();
		}
		else if (e.getSource() == showPositivePercentage) {
			showPositivePercentage();
		}
	}
	
	// method to add users to tree
	// only one user can exist with unique ID
	// a user can belong to only one group
	private void addUser() {
		String id = userID.getText();
		if (id != "") {
			UserGroupComponent user = getSelectedUser();
			if (userGroupTree.findUserByID(user, id) == null) {
				if (userGroupTree.findUserByID(root, id) == null) {
					userGroupTree.addGroupComponent(user, new UserLeaf(userGroupTree, id));
				}
				else {
					displayErrorMessage("User Error", "Error: User " + id + " can only belong in one group.");
				}
			}
			else {
				displayErrorMessage("User Error", "Error: User " + id + " is taken.");
			}
			userID.setText("");
			expandTree();
		}
	}
	
	// method to add user groups to tree
	// only one group can exist with unique id
	private void addGroup() {
		String id = groupID.getText();
		if (id != "") {
			UserGroupComponent user = getSelectedUser();
			if (userGroupTree.findGroupByID(user, id) == null) {
				userGroupTree.addGroupComponent(user, new UserGroupComposite(id));
			}
			else {
				displayErrorMessage("Group Error", "Error: Group " + id + " is taken.");
			}
			groupID.setText("");
			expandTree();
		}
	}
	
	// method to open user view for specified user
	// if no specified user, user view opens for all users
	private void openUserView() {
		UserGroupComponent user = getSelectedUser();
		user.openUserView();
	}
	
	// method to validate all the IDs used in users and groups based on:
	// all IDS must be unique and IDs should not contain spaces
	private void validateUser() {
		int invalidUsers = 0;
		UserGroupComponent user = getSelectedUser();
		ValidUserVisitor visitor = new ValidUserVisitor(user);
		user.accept(visitor);
		invalidUsers = visitor.getInvalidIDs();
		JOptionPane.showMessageDialog(this, "Total number of invalid users: " + invalidUsers, "Invalid User Total", JOptionPane.PLAIN_MESSAGE);
	}
	
	// method to output the ID of the user who made the last update
	private void lastUpdatedUser() {
		String lastUpdateUser;
		UserGroupComponent user = getSelectedUser();
		LastUpdatedUserVisitor visitor = new LastUpdatedUserVisitor();
		user.accept(visitor);
		lastUpdateUser = visitor.getLastUpdateUser();
		JOptionPane.showMessageDialog(this, "User who made the last update: " + lastUpdateUser, "Last Update User", JOptionPane.PLAIN_MESSAGE);
	}
	
	// method to display total number of users
	private void showUserTotal() {
		int totalUsers = 0;
		UserGroupComponent user = getSelectedUser();
		UserTotalVisitor visitor = new UserTotalVisitor();
		user.accept(visitor);
		totalUsers = visitor.getTotalUsers();
		JOptionPane.showMessageDialog(this, "Total number of users: " + totalUsers, "User Total", JOptionPane.PLAIN_MESSAGE);
	}
	
	// method to display total number of groups
	private void showGroupTotal() {
		int totalGroups = 0;
		UserGroupComponent user = getSelectedUser();
		GroupTotalVisitor visitor = new GroupTotalVisitor();
		user.accept(visitor);
		totalGroups = visitor.getTotalGroups();
		JOptionPane.showMessageDialog(this, "Total number of groups: " + totalGroups, "Group Total", JOptionPane.PLAIN_MESSAGE);
	}
	
	// method to display total number of messages
	private void showMessagesTotal() {
		int totalMessages = 0;
		UserGroupComponent user = getSelectedUser();
		MessagesTotalVisitor visitor = new MessagesTotalVisitor();
		user.accept(visitor);
		totalMessages = visitor.getTotalMessages();
		JOptionPane.showMessageDialog(this, "Total number of messages: " + totalMessages, "Messages Total", JOptionPane.PLAIN_MESSAGE);
	}
	
	// method to display the percentage of messages containing positive words
	private void showPositivePercentage() {
		final List<String> positiveWords = Arrays.asList("good", "great", "excellent", "amazing", "spectacular", "sensational");
		double percentage = 0;
		UserGroupComponent user = getSelectedUser();
		PositivePercentageVisitor visitor1 = new PositivePercentageVisitor(positiveWords);
		MessagesTotalVisitor visitor2 = new MessagesTotalVisitor();
		user.accept(visitor1);
		user.accept(visitor2);
		percentage = (double) visitor1.getPositiveMessages() / (double) visitor2.getTotalMessages() * 100.0;
		if (((Double) percentage).isNaN()) {
			percentage = 0;
		}
		String roundedPercent = String.format(".2f", percentage);
		JOptionPane.showMessageDialog(this, "Percentage of tweets containing positive words: " + roundedPercent + "%", 
				"Positive Percentage", JOptionPane.PLAIN_MESSAGE);
	}
	
	// method to get selected user or user group from tree
	private UserGroupComponent getSelectedUser() {
		UserGroupComponent user = (UserGroupComponent) tree.getLastSelectedPathComponent();
		if (user == null) {
			user = root;
		}
		return user;
	}
	
	// method to keep tree expanded in tree view
	private void expandTree() {
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}
}
