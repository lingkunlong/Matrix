import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;
//import com.jgoodies.forms.factories.*;
/*
 * Created by JFormDesigner on Tue Mar 22 19:12:20 CST 2022
 */



/**
 * @author unknown
 */

class TripleMatrix1 {

    int m, n;
    int num;

    Triple data[] = new Triple[100];

    public TripleMatrix1() {
    }

    public TripleMatrix1(int m, int n, int num) {

        this.m = m;
        this.n = n;
        this.num = num;
    }
}
/**
 * @author 86188
 */
public class Trans_Frame extends JFrame {
    public TripleMatrix1 M=new TripleMatrix1();
    public TripleMatrix1 M1=new TripleMatrix1();
    private Component addTest;
    public Trans_Frame() {
        initComponents();
        setVisible(true);
        setResizable(false);
        setTitle("稀疏矩阵转置运算");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void button2(ActionEvent e) {

        String[] Array = textField1.getText().split(" ");
        int a0 = Integer.parseInt(Array[0]);
        int a1 = Integer.parseInt(Array[1]);
        int a2 = Integer.parseInt(Array[2]);
        M = new TripleMatrix1(a0,a1,a2);
        int i=0;
        String[] Array1 = textArea1.getText().split("\n");
        String[] Array2;
        for(i=0;i<M.num;i++){
            Array2=Array1[i].split(" ");
            int aa0 = Integer.parseInt(Array2[0]);
            int aa1 = Integer.parseInt(Array2[1]);
            int aa2 = Integer.parseInt(Array2[2]);

            M.data[i] = new Triple(aa0,aa1,aa2);}
        int ii, jj;
        int index, index1;
        String s = "";
        int[][] a = new int[M.m][M.n];
        int[][] b = new int[M.m][M.n];
        int[][] c = new int[M.m][M.n];
        for (index = 0; index < M.num; index++) {
            for (ii = 0; ii < M.m; ii++) {
                for (jj = 0; jj < M.n; jj++) {
                    if (ii == M.data[index].x && jj == M.data[index].y) {
                        a[ii][jj] = M.data[index].weight;
                    }
                }
            }
        }
        for (ii = 0; ii < M.m; ii++) {
            for (jj = 0; jj < M.n; jj++) {
                s = s + Integer.toString(a[ii][jj]) + " ";
            }
            s=s+"\n";
        }
        textArea2.setText(s);
        JOptionPane.showMessageDialog(addTest,"输入成功");
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        int ii,jj;
        int index,index1;
        String s = "";
        int[][] Array = new int[M.m][M.n];
        int[][] Array1=new int[M.n][M.m];

        for(index=0;index<M.num;index++){
            for(ii=0;ii<M.m;ii++){
                for(jj=0;jj<M.n;jj++){
                    if(ii==M.data[index].x&&jj==M.data[index].y){
                        Array[ii][jj]=M.data[index].weight;}}}}

        ii=0;
        while (ii<M.n) {
            for(jj=0;jj<M.m;jj++) {
                Array1[ii][jj]=Array[jj][ii];
            }
            ii++;
        }

        for(ii=0;ii<M.n;ii++){
            for(jj=0;jj<M.m;jj++){
                s=s+Integer.toString(Array1[ii][jj])+" ";}

            s=s+"\n";}

        textArea3.setText(s);
    }

    private void menu1(ActionEvent e) {
        // TODO add your code here
        new Help1().setVisible(true);
    }

    private void menu1MouseClicked(MouseEvent e) {
        // TODO add your code here
        new Help1().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        button2 = new JButton();
        label3 = new JLabel();
        button3 = new JButton();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        panel1 = new JPanel();
        label4 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.setOpaque(false);

            //======== menu1 ========
            {
                menu1.setText(bundle.getString("menu1.text_2"));
                menu1.setOpaque(false);
                menu1.setFont(menu1.getFont().deriveFont(menu1.getFont().getSize() + 3f));
                menu1.addActionListener(e -> menu1(e));
                menu1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menu1MouseClicked(e);
                    }
                });
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_2"));
        label1.setForeground(Color.black);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1);
        label1.setBounds(15, 15, 215, 30);

        //---- textField1 ----
        textField1.setBackground(new Color(204, 204, 204));
        textField1.setOpaque(false);
        textField1.setForeground(Color.black);
        contentPane.add(textField1);
        textField1.setBounds(20, 45, 190, 40);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_2"));
        label2.setForeground(Color.black);
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(20, 85, 135, 25);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setOpaque(false);
            textArea1.setForeground(Color.black);
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 6f));
            textArea1.setBorder(new EtchedBorder());
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 115, 185, 145);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setOpaque(false);
            textArea2.setFont(textArea2.getFont().deriveFont(textArea2.getFont().getSize() + 6f));
            textArea2.setBorder(new EtchedBorder());
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(285, 115, 185, 145);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text"));
        button2.setOpaque(false);
        button2.setBorder(null);
        button2.setContentAreaFilled(false);
        button2.setBackground(Color.black);
        button2.setForeground(Color.black);
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(217, 155, 60, 50);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_2"));
        label3.setForeground(Color.black);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(35, 285, 80, 20);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text"));
        button3.setOpaque(false);
        button3.setBorder(null);
        button3.setContentAreaFilled(false);
        button3.setForeground(Color.black);
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(30, 310, 75, 45);

        //======== scrollPane3 ========
        {

            //---- textArea3 ----
            textArea3.setOpaque(false);
            textArea3.setFont(textArea3.getFont().deriveFont(textArea3.getFont().getSize() + 6f));
            textArea3.setBackground(new Color(204, 204, 204));
            textArea3.setBorder(new EtchedBorder());
            scrollPane3.setViewportView(textArea3);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(150, 300, 280, 200);

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
        panel1.setBounds(new Rectangle(new Point(0, 505), panel1.getPreferredSize()));

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_2"));
        label4.setIcon(new ImageIcon("D:\\\u5411\u65e5\u8475\\\u6781\u7b80\u80cc\u666f\u7684\u641c\u7d22\u7ed3\u679c_\u767e\u5ea6\u56fe\u7247\u641c\u7d22\\src_http___img9.51tietu.net_pic_2019-091121_cr4ljqssqgqcr4ljqssqgq.jpg&refer_http___img9.51tietu.jpg"));
        contentPane.add(label4);
        label4.setBounds(-115, -10, 620, 565);

        contentPane.setPreferredSize(new Dimension(490, 550));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JButton button2;
    private JLabel label3;
    private JButton button3;
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    private JPanel panel1;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
