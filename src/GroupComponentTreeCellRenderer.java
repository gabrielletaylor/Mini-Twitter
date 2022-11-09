import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;

public class GroupComponentTreeCellRenderer implements TreeCellRenderer {

	private JLabel label;

    public GroupComponentTreeCellRenderer() {
        label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        GroupComponent userElem = (GroupComponent) value;

        label.setText(userElem.getUniqueID() + " ");
        
        if (selected) {
            label.setOpaque(true);
        }
        else {
            label.setOpaque(false);
        }
//        if (userElem instanceof UserGroup){
//            label.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
//        }
//        else {
//            label.setFont(font.deriveFont(font.getStyle() | Font.PLAIN));
//        }

        return label;
    }
}
