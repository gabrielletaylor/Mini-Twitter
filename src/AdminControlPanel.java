import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class AdminControlPanel extends AdminControlPanelUI implements ActionListener {
	private static final AdminControlPanel instance = new AdminControlPanel();
	
//	  private JTree tree;
//    private JScrollPane treeScrollPane;
    private JTextField userID, groupID;
    private JButton addUser, addGroup, openUserView, showUserTotal,
					showGroupTotal, showMessagesTotal, showPositivePercentage;
    private JLabel userIDLabel, groupIDLabel, treeViewLabel;
    private JPanel treeViewPanel, userGroupPanel, informationPanel, openUserViewPanel;

	
	private AdminControlPanel() {
		System.out.println("Admin Panel created");
	}
	
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
        setVisible(true);
        
        treeViewPanel = new JPanel();
        stylePanel(treeViewPanel, 10, 10, 375, 550);
        
        userGroupPanel = new JPanel();
        stylePanel(userGroupPanel, 395, 10, 495, 200);
        
        openUserViewPanel = new JPanel();
        stylePanel(openUserViewPanel, 395, 230, 495, 100);
        
        informationPanel = new JPanel();
        stylePanel(informationPanel, 395, 360, 495, 200);
        
        userIDLabel = new JLabel("User ID:");
        userIDLabel.setBounds(10, 5, 305, 20);
        userGroupPanel.add(userIDLabel);
        
        groupIDLabel = new JLabel("Group ID:");
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
        
        
        openUserView = new JButton("Open User View");
        styleButton(openUserView, 5, 25, 485, 50);
        openUserViewPanel.add(openUserView);
        
       
        showUserTotal = new JButton("Show User Total");
        styleButton(showUserTotal, 5, 10, 175, 50);
        informationPanel.add(showUserTotal);
        showGroupTotal = new JButton("Show Group Total");
        styleButton(showGroupTotal, 315, 10, 175, 50);
        informationPanel.add(showGroupTotal);
        showMessagesTotal = new JButton("Show Messages Total");
        styleButton(showMessagesTotal, 5, 145, 175, 50);
        informationPanel.add(showMessagesTotal);
        showPositivePercentage = new JButton("Show Positive Percentage");
        styleButton(showPositivePercentage, 315, 145, 175, 50);
        informationPanel.add(showPositivePercentage);
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
		
	}
	
	private void addGroup() {
		
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
}
