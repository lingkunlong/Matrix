import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
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
        add(new JLayeredPane());
        setTitle("稀疏矩阵运算器");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    static class Background extends JPanel {
        Image im;

        public Background(Image im) {
            this.im = im;
            this.setOpaque(true);
        }

        //Draw the back ground.
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
    private void Add(ActionEvent e) {
        new OperationUI().setVisible(true);
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

        //======== this ========
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
        button1.setBounds(245, 40, 100, 50);

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
        label1.setText(bundle.getString("label1.text_3"));
        label1.setIcon(new ImageIcon("D:\\\u5411\u65e5\u8475\\v2.jpg"));
        contentPane.add(label1);
        label1.setBounds(-605, -150, 995, 505);

        contentPane.setPreferredSize(new Dimension(370, 355));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JPanel panel1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
