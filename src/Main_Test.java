import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import javax.swing.plaf.*;
/*
 * Created by JFormDesigner on Tue Mar 22 18:49:52 CST 2022
 */
/**
 * @author unknown
 */
public class Main_Test extends JFrame {//创建Main_Test类，使该类继承JFrame类

    public static void main(String[] args) {
        new Main_Test();
    }

    public Main_Test() {
        initComponents();
        add(new JLayeredPane());
        setTitle("稀疏矩阵运算器");
        setVisible(true);
        setResizable(true);
        label6.setFont(new Font("楷体",Font.BOLD,20));
        label7.setFont(new Font("楷体",Font.BOLD,19));
        label8.setFont(new Font("楷体",Font.BOLD,19));
        label9.setFont(new Font("楷体",Font.BOLD,19));
        label10.setFont(new Font("楷体",Font.BOLD,19));
        label11.setFont(new Font("楷体",Font.BOLD,19));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//结束窗口所在的程序，退出JVM
    }
   private void Add(ActionEvent e) {
      new OperationUI().setVisible(true);//下一个界面的监听事件，用作跳转
  }

    private void button1KeyPressed(KeyEvent e) {
        // TODO add your code her
        if(e.getKeyChar() == '\n'){ //判断输入的是否是回车键
            button1.doClick();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        button1 = new JButton();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        panel2 = new JPanel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();

        //======== this ========
        setIconImage(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\wizard\uff0c\u7b14\u8bb0\u672c\u7535\u8111.png").getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text"));
        button1.setContentAreaFilled(false);
        button1.setForeground(Color.black);
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 9f));
        button1.addActionListener(e -> Add(e));
        button1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                button1KeyPressed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(205, 260, 100, 50);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(5, 5, panel1.getPreferredSize().width, 0);

        //---- label1 ----
        label1.setIcon(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\Vertical symbol.png"));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(45, 15), label1.getPreferredSize()));

        //---- label2 ----
        label2.setIcon(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\Plus sign.png"));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(190, 15), label2.getPreferredSize()));

        //---- label3 ----
        label3.setIcon(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\minus sign.png"));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(330, 20), label3.getPreferredSize()));

        //---- label4 ----
        label4.setIcon(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\Multiplication.png"));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(455, 20), label4.getPreferredSize()));

        //======== panel2 ========
        {
            panel2.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel2);
        panel2.setBounds(new Rectangle(new Point(45, -25), panel2.getPreferredSize()));

        //---- label6 ----
        label6.setAlignmentX(1.0F);
        label6.setAlignmentY(0.0F);
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 4f));
        label6.setText(bundle.getString("label6.text"));
        contentPane.add(label6);
        label6.setBounds(30, 65, 285, 25);

        //---- label7 ----
        label7.setText(bundle.getString("label7.text"));
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 4f));
        contentPane.add(label7);
        label7.setBounds(30, 100, 495, 30);

        //---- label8 ----
        label8.setText(bundle.getString("label8.text"));
        contentPane.add(label8);
        label8.setBounds(325, 95, 135, 40);

        //---- label9 ----
        label9.setText(bundle.getString("label9.text"));
        contentPane.add(label9);
        label9.setBounds(210, 145, 125, 30);

        //---- label10 ----
        label10.setText(bundle.getString("label10.text"));
        contentPane.add(label10);
        label10.setBounds(325, 130, 135, 55);

        //---- label11 ----
        label11.setText(bundle.getString("label11.text"));
        contentPane.add(label11);
        label11.setBounds(210, 185, 110, 40);

        //---- label12 ----
        label12.setIcon(null);
        contentPane.add(label12);
        label12.setBounds(new Rectangle(new Point(10, 135), label12.getPreferredSize()));

        //---- label13 ----
        label13.setIcon(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\v2.jpg"));
        contentPane.add(label13);
        label13.setBounds(new Rectangle(new Point(-505, -375), label13.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(530, 380));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JPanel panel2;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
