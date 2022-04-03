import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;
/*
 * Created by JFormDesigner on Sun Mar 27 17:35:32 CST 2022
 */



/**
 * @author unknown
 */
public class Help extends JFrame {
    public static void main(String[] args) {
        new Help();
    }
    public Help() {
        initComponents();
        setResizable(false);
        setTitle("帮助");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_5"));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));
        label1.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(label1);
        label1.setBounds(55, 30, 505, 25);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_3"));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        label2.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(label2);
        label2.setBounds(55, 65, 505, 25);

        //---- label3 ----
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        label3.setHorizontalAlignment(SwingConstants.LEFT);
        label3.setText(bundle.getString("label3.text_3"));
        contentPane.add(label3);
        label3.setBounds(55, 100, 505, 25);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_3"));
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        label4.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(label4);
        label4.setBounds(55, 135, 505, 25);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text_2"));
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
        label5.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(label5);
        label5.setBounds(55, 170, 505, 25);

        contentPane.setPreferredSize(new Dimension(620, 245));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
