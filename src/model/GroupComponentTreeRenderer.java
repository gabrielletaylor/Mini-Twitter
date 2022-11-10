package model;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;

public class GroupComponentTreeRenderer implements TreeCellRenderer {

	private JLabel label;
	
    public GroupComponentTreeRenderer() {
        label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        GroupComponent component = (GroupComponent) value;
        label.setText(component.getUniqueID() + " ");
        if (selected) {
            label.setOpaque(true);
        }
        else {
            label.setOpaque(false);
        }
        if (component instanceof UserGroup) {
        	label.setFont(new Font("SANS_SERIF", Font.BOLD, 12));
        	
        }
        else if (component instanceof User) {        	
        	label.setFont(new Font("SANS_SERIF", Font.PLAIN, 12));
        }

        return label;
    }
}
