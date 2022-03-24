import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Mar 22 18:49:52 CST 2022
 */



/**
 * @author unknown
 */
public class Main_Test extends JFrame {

    public static void main(String[] args) {
        new Main_Test();
    }
    public Main_Test() {
        initComponents();
        setTitle("稀疏矩阵运算器");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void Add(ActionEvent e) {
        new OperationUI().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text"));
        button1.addActionListener(e -> Add(e));
        contentPane.add(button1);
        button1.setBounds(80, 80, 100, 50);

        contentPane.setPreferredSize(new Dimension(265, 245));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
