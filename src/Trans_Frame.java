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

/*class TripleMatrix1 {

    int m, n;
    int num;

    Triple[] data = new Triple[100];

    public TripleMatrix1() {
    }

    public TripleMatrix1(int m, int n, int num) {

        this.m = m;
        this.n = n;
        this.num = num;
    }
}*/
/**
 * @author 86188
 */
public class Trans_Frame extends JFrame {
    public TripleMatrix M=new TripleMatrix();
    public TripleMatrix M1=new TripleMatrix();
    private Component addTest;

    public static void main(String[] args) {
        new Trans_Frame();
    }
    public Trans_Frame() {
        initComponents();
        setVisible(true);
        setResizable(false);
        setTitle("稀疏矩阵转置运算");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        label1.setFont(new Font("楷体",Font.BOLD,15));
        label2.setFont(new Font("楷体",Font.BOLD,15));
        label3.setFont(new Font("楷体",Font.BOLD,15));
        button2.setFont(new Font("楷体",Font.BOLD,25));
        button3.setFont(new Font("楷体",Font.BOLD,30));
        menu1.setFont(new Font("楷体",Font.BOLD,20));
    }
//创建矩阵并显示
    private void button2(ActionEvent e){
        try {
            String[] Array = textField1.getText().split(" ");
            int a0 = Integer.parseInt(Array[0]);
            int a1 = Integer.parseInt(Array[1]);
            int a2 = Integer.parseInt(Array[2]);
            if(a0<=0||a1<=0){
                textField1.setText("");
                throw new Exception("输入非法，行数和列数必须为正数,请重新输入");
            }else {
                M = new TripleMatrix(a0, a1, a2);
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
        //int i=0;
        String[] Array1 = textArea1.getText().split("\n");
        String[] Array2;
        for(int i=0;i<M.num;i++){
            Array2 = Array1[i].split(" ");
            int aa0 = Integer.parseInt(Array2[0]);
            int aa1 = Integer.parseInt(Array2[1]);
            int aa2 = Integer.parseInt(Array2[2]);
            if((aa0>M.m-1||aa0<0)||(aa1>M.n-1||aa1<0)){
                JOptionPane.showMessageDialog(addTest, "输入非法，行数和列数不能越界,请重新输入");
                textArea1.setText("");
                break;
            }
            else if (aa2 ==0){
                JOptionPane.showMessageDialog(addTest, "输入非法，非零元不能为零,请重新输入");
                textArea1.setText("");
                break;
            }
            else{
                M.data[i] = new Triple(aa0, aa1, aa2);}
        }
        String s = "";
        String ch = "";
        int p = 0,k,h;
        for (int row = 0; row < M.m; row++) {
            for (int line = 0; line < M.n; line++) {
                for (k = 0, h = 0; k < M.num; k++) {
                    if (M.data[k].x == row && M.data[k].y == line) {
                        p = M.data[k].weight;
                        h = 1;
                        break;
                    }
                }
                if (h == 0) {
                    p = 0;}
                ch = Integer.toString(p);
                if (ch == "") {
                    ch = "0";
                }
                s = s + ch + " ";
            }
            s = s + "\n";
        }
        textArea2.setText(s);
        JOptionPane.showMessageDialog(addTest, "创建成功");
    }

    private void button3(ActionEvent e) {
        String s = "";
        M1 = new TripleMatrix(M.n,M.m,M.num);
        for (int i = 0;i<M.num;i++){
            M1.data[i] =  new Triple(M.data[i].y,M.data[i].x,M.data[i].weight);
        }
        for(int ii=0;ii<M1.m;ii++){
            for(int jj=0;jj<M1.n;jj++){
                String p="";
                for(int index1=0;index1<M1.num;index1++) {
                    if(ii==M1.data[index1].x&&jj==M1.data[index1].y)
                    {
                        p=Integer.toString(M1.data[index1].weight);
                    }
                }
                if(p==""){p="0";}
                s=s+p+" ";
            }
            s=s+"\n";
        }
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
        textField1.setFont(textField1.getFont().deriveFont(textField1.getFont().getSize() + 3f));
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
        scrollPane1.setBounds(25, 115, 185, 165);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setOpaque(false);
            textArea2.setFont(textArea2.getFont().deriveFont(textArea2.getFont().getSize() + 6f));
            textArea2.setBorder(new EtchedBorder());
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(285, 115, 185, 165);

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
        label4.setBounds(-80, 0, 620, 565);

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
