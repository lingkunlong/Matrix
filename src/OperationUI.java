
import java.awt.*;
import java.awt.event.*;
import java.security.interfaces.RSAKey;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.plaf.*;

//import com.jgoodies.forms.factories.*;
/*
 * Created by JFormDesigner on Tue Mar 22 19:10:17 CST 2022
 */

class Triple{

    int x,y;
    int weight;
    public Triple(){}
    public Triple(int x,int y,int weight){

        this.x=x;
        this.y=y;
        this.weight=weight;
    }
}
class TripleMatrix {

    int m, n;
    int num;

    Triple data[] = new Triple[100];

    public TripleMatrix() {
    }

    public TripleMatrix(int m, int n, int num) {

        this.m = m;
        this.n = n;
        this.num = num;
    }
}

public class OperationUI extends JFrame {

    public TripleMatrix M=new TripleMatrix();
    public TripleMatrix M1=new TripleMatrix();
    private Component addTest;
    public OperationUI() {

        initComponents();
        setTitle("稀疏矩阵运算");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    private void button2(ActionEvent e) {
        // TODO add your code here

        String[] Array = textField1.getText().split(" ");
        int a0 = Integer.parseInt(Array[0]);
        int a1 = Integer.parseInt(Array[1]);
        int a2 = Integer.parseInt(Array[2]);
        M = new TripleMatrix(a0,a1,a2);
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
        JOptionPane.showMessageDialog(addTest,"创建成功");

    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        String[] Array = textField4.getText().split(" ");
        int a0 = Integer.parseInt(Array[0]);
        int a1 = Integer.parseInt(Array[1]);
        int a2 = Integer.parseInt(Array[2]);
        M1 = new TripleMatrix(a0,a1,a2);
        int i=0;
        String[] Array1 = textArea3.getText().split("\n");

        String[] Array2 ;
        for(i=0;i<M1.num;i++){
            Array2=Array1[i].split(" ");
            int aa0 = Integer.parseInt(Array2[0]);
            int aa1 = Integer.parseInt(Array2[1]);
            int aa2 = Integer.parseInt(Array2[2]);

            M1.data[i] = new Triple(aa0,aa1,aa2);}
        int ii, jj;
        int index, index1;
        String s = "";
        int[][] a = new int[M1.m][M1.n];

        for (index = 0; index < M1.num; index++) {
            for (ii = 0; ii < M1.m; ii++) {
                for (jj = 0; jj < M.n; jj++) {
                    if (ii == M1.data[index].x && jj == M1.data[index].y) {
                        a[ii][jj] = M1.data[index].weight;
                    }
                }
            }
        }
        for (ii = 0; ii < M1.m; ii++) {
            for (jj = 0; jj < M1.n; jj++) {
                s = s + Integer.toString(a[ii][jj]) + " ";
            }
            s=s+"\n";
        }
        textArea4.setText(s);
        JOptionPane.showMessageDialog(addTest,"创建成功");
    }
    //执行加法操作
    private void button5(ActionEvent e) {
        // TODO add your code here
        int ii, jj;
        int index, index1;
        String s = "";
        int[][] Array = new int[M.m][M.n];
        int[][] Array1 = new int[M.m][M.n];
        int[][] Array2 = new int[M.m][M.n];
        for (index = 0; index < M.num; index++) {
            for (ii = 0; ii < M.m; ii++) {
                for (jj = 0; jj < M.n; jj++) {
                    if (ii == M.data[index].x && jj == M.data[index].y) {
                        Array[ii][jj] = M.data[index].weight;
                    }
                }
            }
        }
        for (index1 = 0; index1 < M1.num; index1++) {
            for (ii = 0; ii < M1.m; ii++) {
                for (jj = 0; jj < M1.n; jj++) {
                    if (ii == M1.data[index1].x && jj == M1.data[index1].y) {
                        Array1[ii][jj] = M1.data[index1].weight;
                    }
                }
            }
        }
        if (M.m == M1.m && M.n == M1.n) {
            for (ii = 0; ii < M.m; ii++)
                for (jj = 0; jj < M.n; jj++)
                    Array2[ii][jj] = Array[ii][jj] + Array1[ii][jj];
            for (ii = 0; ii < M.m; ii++) {
                for (jj = 0; jj < M.n; jj++) {
                    s = s + Integer.toString(Array2[ii][jj]) + " ";
                }
                s=s+"\n";
                textArea5.setText(s);
            }

        }else {
            JOptionPane.showMessageDialog(addTest,"运算不合法，终止运算");
        }

    }
//执行减法操作
    private void button6(ActionEvent e) {
        // TODO add your code here
        int ii, jj;
        int index, index1;
        String s = "";
        int[][] Array = new int[M.m][M.n];
        int[][] Array1 = new int[M.m][M.n];
        int[][] Array2 = new int[M.m][M.n];
        for (index = 0; index < M.num; index++) {
            for (ii = 0; ii < M.m; ii++) {
                for (jj = 0; jj < M.n; jj++) {
                    if (ii == M.data[index].x && jj == M.data[index].y) {
                        Array[ii][jj] = M.data[index].weight;
                    }
                }
            }
        }
        for (index1 = 0; index1 < M1.num; index1++) {
            for (ii = 0; ii < M1.m; ii++) {
                for (jj = 0; jj < M1.n; jj++) {
                    if (ii == M1.data[index1].x && jj == M1.data[index1].y) {
                        Array1[ii][jj] = M1.data[index1].weight;
                    }
                }
            }
        }
        //两个矩阵的行数和列数要相同才能进行操作
        if (M.m == M1.m && M.n == M1.n) {
            for (ii = 0; ii < M.m; ii++)
                for (jj = 0; jj < M.n; jj++)
                    Array2[ii][jj] = Array[ii][jj] - Array1[ii][jj];
            for (ii = 0; ii < M.m; ii++) {
                for (jj = 0; jj < M.n; jj++) {
                    s = s + Integer.toString(Array2[ii][jj]) + " ";
                }
                s=s+"\n";
                textArea5.setText(s);
            }
        }else{
            JOptionPane.showMessageDialog(addTest,"运算不合法，终止运算");
        }
    }
//执行乘法操作
    private void button7(ActionEvent e) {
        // TODO add your code here
        int ii, jj;
        int index, index1;
        String s = "";
        int[][] Array = new int[M.m][M.n];
        int[][] Array1 = new int[M.m][M.n];
        int[][] Array2 = new int[M.m][M.n];
        for (index = 0; index < M.num; index++) {
            for (ii = 0; ii < M.m; ii++) {
                for (jj = 0; jj < M.n; jj++) {
                    if (ii == M.data[index].x && jj == M.data[index].y) {
                        Array[ii][jj] = M.data[index].weight;
                    }
                }
            }
        }
        for (index1 = 0; index1 < M1.num; index1++) {
            for (ii = 0; ii < M1.m; ii++) {
                for (jj = 0; jj < M1.n; jj++) {
                    if (ii == M1.data[index1].x && jj == M1.data[index1].y) {
                        Array1[ii][jj] = M1.data[index1].weight;
                    }
                }
            }
        }
        if(M.n==M1.m){
            for(ii=0;ii<M.m;ii++)
            {
                for(jj=0;jj<M1.n;jj++)
                {
                    int sum=0;
                    for(int k=0;k<M.n;k++){
                        sum+=Array[ii][k]*Array1[k][jj];}
                        Array2[ii][jj]=sum;
                }
            }
            for(ii=0;ii<M.m;ii++)
            {
                for(jj=0;jj<M1.n;jj++){
                    s=s+Integer.toString(Array2[ii][jj])+" ";}
                s=s+"\n";
                textArea5.setText(s);
            }
        }else{
            JOptionPane.showMessageDialog(addTest,"运算不合法，终止运算");
        }
    }
//转置窗口
    private void button8(ActionEvent e) {
        // TODO add your code here
        new Trans_Frame().setVisible(true);
    }

    private void menu1MouseClicked(MouseEvent e) {
        // TODO add your code here
        new Help().setVisible(true);
    }

    private void menu1(ActionEvent e) {
        // TODO add your code here
    }

    private void menu2MouseClicked(MouseEvent e) {
        // TODO add your code here
        new About().setVisible(true);
    }

    private void textField1(ActionEvent e) {
        // TODO add your code here
    }

    private void ResultA(ActionEvent e) {
        // TODO add your code here
    }

    private void textArea1CaretUpdate(CaretEvent e) {
        // TODO add your code here
    }


//界面
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button2 = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        textField4 = new JTextField();
        button4 = new JButton();
        button5 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();
        textArea4 = new JTextArea();
        textArea5 = new JTextArea();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        label5 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {
            menuBar1.setOpaque(false);

            //======== menu1 ========
            {
                menu1.setText(bundle.getString("menu1.text"));
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

            //======== menu2 ========
            {
                menu2.setText(bundle.getString("menu2.text"));
                menu2.setOpaque(false);
                menu2.setFont(menu2.getFont().deriveFont(menu2.getFont().getSize() + 3f));
                menu2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        menu2MouseClicked(e);
                    }
                });
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setLayout(null);
        }
        contentPane.add(panel1);
        panel1.setBounds(new Rectangle(new Point(0, 675), panel1.getPreferredSize()));

        //---- label1 ----
        label1.setText(bundle.getString("label1.text"));
        label1.setBorder(null);
        label1.setForeground(Color.black);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(25, 45, 205, 30);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text"));
        label2.setBorder(null);
        label2.setForeground(Color.black);
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(25, 90, 105, 30);

        //---- textField1 ----
        textField1.setBorder(new EtchedBorder());
        textField1.setBackground(new Color(204, 204, 204));
        textField1.setForeground(Color.black);
        textField1.setFont(textField1.getFont().deriveFont(textField1.getFont().getSize() + 1f));
        textField1.setOpaque(false);
        textField1.addActionListener(e -> textField1(e));
        contentPane.add(textField1);
        textField1.setBounds(245, 45, 100, 35);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_2"));
        button2.setContentAreaFilled(false);
        button2.setBorder(new EtchedBorder());
        button2.setForeground(Color.black);
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 2f));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(215, 215, 78, 40);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text"));
        label3.setForeground(Color.black);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(25, 345, 210, 30);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text"));
        label4.setForeground(Color.black);
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
        contentPane.add(label4);
        label4.setBounds(25, 385, 105, 30);

        //---- textField4 ----
        textField4.setBorder(new EtchedBorder());
        textField4.setBackground(new Color(204, 204, 204));
        textField4.setForeground(Color.black);
        textField4.setFont(textField4.getFont().deriveFont(textField4.getFont().getSize() + 1f));
        textField4.setOpaque(false);
        contentPane.add(textField4);
        textField4.setBounds(245, 340, 100, 35);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_2"));
        button4.setContentAreaFilled(false);
        button4.setBorder(new EtchedBorder());
        button4.setForeground(Color.black);
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 2f));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(215, 505, 78, 40);

        //---- button5 ----
        button5.setText(bundle.getString("button5.text"));
        button5.setContentAreaFilled(false);
        button5.setBorder(new EtchedBorder());
        button5.setForeground(Color.black);
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 2f));
        button5.addActionListener(e -> {
			ResultA(e);
			button5(e);
		});
        contentPane.add(button5);
        button5.setBounds(60, 630, 75, 40);

        //======== scrollPane1 ========
        {
            scrollPane1.setOpaque(false);

            //---- textArea1 ----
            textArea1.setBorder(new EtchedBorder());
            textArea1.setBackground(Color.white);
            textArea1.setForeground(Color.black);
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 6f));
            textArea1.setOpaque(false);
            textArea1.addCaretListener(e -> textArea1CaretUpdate(e));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 135, 170, 195);

        //---- textArea2 ----
        textArea2.setBorder(new EtchedBorder());
        textArea2.setBackground(new Color(204, 204, 204));
        textArea2.setForeground(Color.black);
        textArea2.setFont(textArea2.getFont().deriveFont(textArea2.getFont().getSize() + 6f));
        textArea2.setOpaque(false);
        contentPane.add(textArea2);
        textArea2.setBounds(315, 135, 170, 195);

        //---- textArea3 ----
        textArea3.setBorder(new EtchedBorder());
        textArea3.setBackground(new Color(204, 204, 204));
        textArea3.setForeground(Color.black);
        textArea3.setFont(textArea3.getFont().deriveFont(textArea3.getFont().getSize() + 6f));
        textArea3.setOpaque(false);
        contentPane.add(textArea3);
        textArea3.setBounds(25, 420, 170, 195);

        //---- textArea4 ----
        textArea4.setBorder(new EtchedBorder());
        textArea4.setBackground(new Color(204, 204, 204));
        textArea4.setForeground(Color.black);
        textArea4.setFont(textArea4.getFont().deriveFont(textArea4.getFont().getSize() + 6f));
        textArea4.setOpaque(false);
        contentPane.add(textArea4);
        textArea4.setBounds(315, 420, 170, 195);

        //---- textArea5 ----
        textArea5.setBorder(new EtchedBorder());
        textArea5.setForeground(Color.black);
        textArea5.setBackground(new Color(204, 204, 204));
        textArea5.setFont(textArea5.getFont().deriveFont(textArea5.getFont().getSize() + 6f));
        textArea5.setOpaque(false);
        contentPane.add(textArea5);
        textArea5.setBounds(520, 135, 218, 478);

        //---- button6 ----
        button6.setText(bundle.getString("button6.text"));
        button6.setContentAreaFilled(false);
        button6.setBorder(new EtchedBorder());
        button6.setForeground(Color.black);
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getSize() + 2f));
        button6.addActionListener(e -> button6(e));
        contentPane.add(button6);
        button6.setBounds(245, 630, 75, 40);

        //---- button7 ----
        button7.setText(bundle.getString("button7.text"));
        button7.setContentAreaFilled(false);
        button7.setBorder(new EtchedBorder());
        button7.setForeground(Color.black);
        button7.setFont(button7.getFont().deriveFont(button7.getFont().getSize() + 2f));
        button7.addActionListener(e -> button7(e));
        contentPane.add(button7);
        button7.setBounds(440, 630, 75, 40);

        //---- button8 ----
        button8.setText(bundle.getString("button8.text"));
        button8.setContentAreaFilled(false);
        button8.setBorder(new EtchedBorder());
        button8.setForeground(Color.black);
        button8.setFont(button8.getFont().deriveFont(button8.getFont().getSize() + 2f));
        button8.addActionListener(e -> button8(e));
        contentPane.add(button8);
        button8.setBounds(615, 630, 75, 40);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text"));
        label5.setIcon(new ImageIcon("D:\\\u5411\u65e5\u8475\\\u6781\u7b80\u80cc\u666f\u7684\u641c\u7d22\u7ed3\u679c_\u767e\u5ea6\u56fe\u7247\u641c\u7d22\\src_http___img9.51tietu.net_pic_2019-091121_cr4ljqssqgqcr4ljqssqgq.jpg&refer_http___img9.51tietu.jpg"));
        label5.setForeground(new Color(153, 153, 153));
        contentPane.add(label5);
        label5.setBounds(-440, -25, 1220, 725);

        contentPane.setPreferredSize(new Dimension(780, 755));
        setSize(780, 755);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField4;
    private JButton button4;
    private JButton button5;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
