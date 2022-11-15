package view;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;
import model.UserGroupComponent;
import model.UserGroupComposite;
import model.UserLeaf;

public class TreeViewRenderer implements TreeCellRenderer {

	private JLabel label;
	
    public TreeViewRenderer() {
        label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        UserGroupComponent component = (UserGroupComponent) value;
        label.setText(component.getUniqueID() + " ");
        if (selected) {
            label.setOpaque(true);
        }
        else {
            label.setOpaque(false);
        }
        if (component instanceof UserGroupComposite) {
        	label.setFont(new Font("SANS_SERIF", Font.BOLD, 12));
        	
        }
        else if (component instanceof UserLeaf) {        	
        	label.setFont(new Font("SANS_SERIF", Font.PLAIN, 12));
        }

        return label;
    }
}
