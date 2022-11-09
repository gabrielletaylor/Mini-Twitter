import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class AdminControlPanel extends FormatUI implements ActionListener {
	private static final AdminControlPanel instance = new AdminControlPanel();
	
    private JTextField userID, groupID;
    private JButton addUser, addGroup, openUserView, showUserTotal,
					showGroupTotal, showMessagesTotal, showPositivePercentage;
    private JLabel userIDLabel, groupIDLabel, treeViewLabel;
    private JPanel treeViewPanel, userGroupPanel, informationPanel, openUserViewPanel;
    private JTree tree;
    private JScrollPane treeScrollPane;
    
    private GroupComponent root;
    private GroupComponentTree userGroupTree;
	
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
        
        treeViewPanel = new JPanel();
        treeViewPanel.setBackground(Color.white);       
        stylePanel(treeViewPanel, 10, 10, 375, 550);
        
        root = new UserGroup(userGroupTree, "Root");
        userGroupTree = new GroupComponentTree(root);
        tree = new JTree(userGroupTree);
        tree.setCellRenderer(new GroupComponentTreeCellRenderer());
        
        styleTree(tree, 10, 10, 375, 550);

        treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setBounds(0, 0, 375, 550);
        treeViewPanel.add(treeScrollPane);
        
        
        
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
        
        
        
        openUserViewPanel = new JPanel();
        stylePanel(openUserViewPanel, 395, 260, 495, 100);
        
        openUserView = new JButton("Open User View");
        styleButton(openUserView, 5, 25, 485, 50);
        openUserViewPanel.add(openUserView);
        
        
        
        informationPanel = new JPanel();
        stylePanel(informationPanel, 395, 360, 495, 200);
       
        showUserTotal = new JButton("Show User Total");
        styleButton(showUserTotal, 5, 50, 240, 50);
        informationPanel.add(showUserTotal);
        showGroupTotal = new JButton("Show Group Total");
        styleButton(showGroupTotal, 250, 50, 240, 50);
        informationPanel.add(showGroupTotal);
        showMessagesTotal = new JButton("Show Messages Total");
        styleButton(showMessagesTotal, 5, 115, 240, 50);
        informationPanel.add(showMessagesTotal);
        showPositivePercentage = new JButton("Show Positive Percentage");
        styleButton(showPositivePercentage, 250, 115, 240, 50);
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
	
	private void addUser() {
		String id = userID.getText();
		if (id != "") {
			GroupComponent user = getSelecedUser();
			if (userGroupTree.findUserByID(user, id) == null) {
				userGroupTree.addGroupComponent(user, new User(userGroupTree, id));
				userID.setText("");
			}
			else {
				displayErrorMessage("User Already Exists", "Error: User " + id + " is taken.");
			}
		}
	}
	
	private void addGroup() {
		String id = groupID.getText();
		if (id != "") {
			GroupComponent user = getSelecedUser();
			if (userGroupTree.findGroupByID(user, id) == null) {
				userGroupTree.addGroupComponent(user, new UserGroup(userGroupTree, id));
				groupID.setText("");
			}
			else {
				displayErrorMessage("Group Already Exists", "Error: Group " + id + " is taken.");
			}
		}
	}
	
	private void openUserView() {
		
	}
	
	private void showUserTotal() {
		
	}
	
	private void showGroupTotal() {
		
	}
	
	private void showMessagesTotal() {
		
	}
	
	private void showPositivePercentage() {
		
	}
	
	private GroupComponent getSelecedUser() {
		GroupComponent user = (GroupComponent) tree.getLastSelectedPathComponent();
		if (user == null) {
			user = root;
		}
		return user;
	}
}
