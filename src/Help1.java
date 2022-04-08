import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;
/*
 * Created by JFormDesigner on Sun Mar 27 17:35:46 CST 2022
 */



/**
 * @author unknown
 */
public class Help1 extends JFrame {
    public Help1() {
        initComponents();
        setVisible(true);
        label1.setFont(new Font("楷体",Font.BOLD,20));
        label2.setFont(new Font("楷体",Font.BOLD,20));
        label3.setFont(new Font("楷体",Font.BOLD,20));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_6"));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));
        contentPane.add(label1);
        label1.setBounds(65, 40, 480, 30);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_4"));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2);
        label2.setBounds(65, 85, 480, 30);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_4"));
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3);
        label3.setBounds(65, 130, 480, 30);

        contentPane.setPreferredSize(new Dimension(610, 225));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
