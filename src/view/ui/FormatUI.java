package view.ui;
import java.awt.event.ActionListener;
import javax.swing.*;

// abstract class for other classes to implement with similar UI
public abstract class FormatUI extends JFrame implements ActionListener {

	// method to style panel
	protected void stylePanel(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        panel.setOpaque(true);
        add(panel);
    }
	
	// method to style button
	protected void styleButton(JButton button, int x, int y, int width, int height) {
        button.setBounds(x, y, width, height);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.addActionListener(this);
    }
	
	// method to style tree
	protected void styleTree(JTree tree, int x, int y, int width, int height) {
        tree.setBounds(x, y, width, height);
        tree.setLayout(null);
        tree.setOpaque(true);
    }
	
	// method to display error message
	public void displayErrorMessage(String title, String text) {
		JOptionPane.showMessageDialog(this, text, title, JOptionPane.ERROR_MESSAGE);
	}

}
