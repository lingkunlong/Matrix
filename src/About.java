import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;
/*
 * Created by JFormDesigner on Wed Mar 30 21:25:46 CST 2022
 */

/**
 * @author unknown
 */
public class About extends JFrame {
    public About() {
        initComponents();
        setVisible(true);
        setTitle("关于");
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//关闭窗体时，释放窗体资源，窗体会消失但是程序不停止
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
        label1.setText(bundle.getString("label1.text_7"));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(100, 35, 315, 30);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_5"));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 5f));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2);
        label2.setBounds(100, 80, 315, 30);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_5"));
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(100, 130, 315, 30);

        contentPane.setPreferredSize(new Dimension(525, 225));
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
