import javafx.scene.layout.Background;

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
    JPanel jp;
    Background bgp;
    public static void main(String[] args) {
        new Main_Test();
    }

    public Main_Test() {
        initComponents();
        add(new JLayeredPane());
        setTitle("稀疏矩阵运算器");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp=(JPanel)this.getContentPane();
        this.setLayout(null);
        //在这里随便找一张400*300的照片既可以看到测试结果。
        ImageIcon img=new ImageIcon("D:\\Java\\sparse matrix\\src_http___api.meisupic.com_getImg.php_imgurl_https___static9.depositphotos.com_1025323_1094_i_950_depositphotos_10949408-stock-photo-computing-backdrop.jpg&id_10949408&userid_1025323&imgfile_thumb_max&refer_http_.jpg");
        bgp= new Background(img.getImage());
        bgp.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
//创建按钮

        jp.add(bgp);
        jp.setOpaque(false);
        this.setBounds(400, 200, 500, 500);
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
        button1.setBounds(185, 190, 100, 50);

        contentPane.setPreferredSize(new Dimension(340, 295));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
