import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FormatUI extends JFrame implements ActionListener {

	protected void stylePanel(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setOpaque(true);
//        panel.setBorder(BorderFactory.createBevelBorder(1));
        add(panel);
    }
	
	protected void styleButton(JButton button, int x, int y, int width, int height) {
        button.setBounds(x, y, width, height);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
//        button.setMargin(new Insets(0, 0, 0, 0));
//        button.setBackground(new Color(98, 190, 253));
//        button.setForeground(Color.WHITE);
//        button.setBorderPainted(true);
//        button.setFocusPainted(false);
//        button.setContentAreaFilled(false);
//        button.setOpaque(true);
//        button.setFont(new Font("SANS_SERIF", Font.BOLD, 12));
        addButtonMouseListener(button);
        button.addActionListener(this);
    }
	
	private void addButtonMouseListener(JButton button){
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(button, new Color(79, 184, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(button, new Color(98, 190, 253));
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setBackground(button, new Color(251, 150, 82));
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                setBackground(button, new Color(251, 150, 82));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                setBackground(button, new Color(98, 190, 253));
            }

            void setBackground(JButton button, Color color) {
                if (button.isEnabled()) {
                    button.setBackground(color);
                }
            }
        });
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
