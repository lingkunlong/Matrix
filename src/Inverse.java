import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.util.ResourceBundle;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Thu Apr 07 21:58:43 CST 2022
 */

/**
 * @author unknown
 */
public class Inverse extends JFrame {
    public Matrix M = new Matrix();
    public Matrix M1 = new Matrix();
    public Matrix M2 = new Matrix();
    private Component addTest;
    public int Fvalues(Matrix M, int i, int j) {
        //查找三元组内的非零元
        for (int t = 0; t < M.vnum; t++) {
            if (M.data[t].rows == i && M.data[t].line == j)
                return M.data[t].value;
        }
        return 0;
    }
    public long[][] mut(int k, int n, long[][] A) {
        long[][] res = new long[n][n];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (i == j) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }
        while (k != 0) {
            if ((k & 1) == 1) res = f(res, A);
            k >>= 1;
            A = f(A, A);
        }
        return res;
    }

    public long[][] f(long[][] A, long[][] B) {
        long res[][] = new long[A.length][B.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Inverse();
    }

    public Inverse() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("求矩阵幂");
        label1.setFont(new Font("楷体",Font.BOLD,15));
        button1.setFont(new Font("楷体",Font.BOLD,25));
        button2.setFont(new Font("楷体",Font.BOLD,25));
        label2.setFont(new Font("楷体",Font.BOLD,15));
        label5.setFont(new Font("楷体",Font.BOLD,15));
        label3.setFont(new Font("楷体",Font.BOLD,30));
        label4.setFont(new Font("楷体",Font.BOLD,30));
    }

    private void label3Clicked(MouseEvent e) {
        //输入非零元位置
        int i = 0;
        String[] Array1 = textArea1.getText().split("\n");
        String[] Array2;
        for (i = 0; i < M.vnum; i++) {
            //按照空格来拆分此字符串
            Array2 = Array1[i].split(" ");
            //将字符串参数解析返回十进制
            int aa0 = Integer.parseInt(Array2[0]);
            int aa1 = Integer.parseInt(Array2[1]);
            int aa2 = Integer.parseInt(Array2[2]);
            if((aa0>M.rnum-1||aa0<0)||(aa1>M.lnum-1||aa1<0)){
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
        /*for (int row = 0; row < M.rnum; row++) {
            for (int line = 0; line < M.lnum; line++) {
                for (k = 0, h = 0; k < M.vnum; k++) {
                    if (M.data[k].rows == row && M.data[k].line == line) {
                        p = M.data[k].value;
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
        }*/
        int ii, jj;
        int index, index1;
        String str = "";
        int[][] a = new int[M.rnum][M.lnum];

        for (index = 0; index < M.vnum; index++) {
            for (ii = 0; ii < M.rnum; ii++) {
                for (jj = 0; jj < M.lnum; jj++) {
                    if (ii == M.data[index].rows && jj == M.data[index].line) {
                        a[ii][jj] = M.data[index].value;
                    }
                }
            }
        }
        for (ii = 0; ii < M.rnum; ii++) {
            for (jj = 0; jj < M.lnum; jj++) {
                s = s + Integer.toString(a[ii][jj]) + " ";
            }
            s = s + "\n";

        }
        textArea2.setText(s);
        JOptionPane.showMessageDialog(addTest, "创建成功");
    }

    private void label4Clicked(MouseEvent e) {
        // TODO add your code here
//        String str = "";
//        if (sum == 1) {
//            textArea3.setText(str);
//        }
//        else {
//            for (int low = 0; low < sum; low++) {
//                for (int row = 0; row < M.rnum; row++) {
//                    for (int line = 0; line < M1.lnum; line++) {
//                        int L = 0;
//                        String str1 = "";
//                        for (int k = 0; k < M.lnum; k++) {
//
//                            int p = Fvalues(M, row, k);
//                            int q = Fvalues(M1, k, line);
//                            L = L + p * q;
//                            str1 = Integer.toString(L);
//                        }
//
//                        //if(ch==""){ch="0";}
//                        str = str + str1 + " ";
//                    }
//                    str = str + "\n";
//                }

        int a0 = 0;
        try {
            String[] Array = textField2.getText().split(" ");
            a0 = Integer.parseInt(Array[0]);
            if (a0 <= 0) {
                textField1.setText("");
                JOptionPane.showMessageDialog(addTest, "幂数必须为正数,请重新输入");
                //throw new Exception("输入非法，行数和列数必须为正数,请重新输入");
            } else {
                JOptionPane.showMessageDialog(addTest, "输入成功");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        int index;
        int ii, jj;
        String s = "";
        long[][] Array;
        long[][] a = new long[M.rnum][M.lnum];

        for (index = 0; index < M.vnum; index++) {
            for (ii = 0; ii < M.rnum; ii++) {
                for (jj = 0; jj < M.vnum; jj++) {
                    if (ii == M.data[index].rows && jj == M.data[index].line) {
                        a[ii][jj] = M.data[index].value;
                    }
                }
            }
        }
        mut(a0, M.rnum, a);
        for (int i = 0; i < M.rnum; i++) {
            for (int j = 0; i < M.lnum; j++) {
                s = s + a[i][j] + " ";
            }
            s = s + "\n";
        }
        textArea3.setText((s));
    }
    private void button1(ActionEvent e) {
        try {
            String[] Array = textField1.getText().split(" ");
            int a0 = Integer.parseInt(Array[0]);
            int a1 = Integer.parseInt(Array[1]);
            int a2 = Integer.parseInt(Array[2]);

            if(a0<=0||a1<=0){
                textField1.setText("");
                JOptionPane.showMessageDialog(addTest, "输入非法，行数和列数必须为正数,请重新输入");
                //throw new Exception("输入非法，行数和列数必须为正数,请重新输入");
            }
            else if (a0!=a1)
            {
                textField1.setText("");
                JOptionPane.showMessageDialog(addTest, "输入非法，行数和列数必须相同,请重新输入");
            }
            else if(a2 == 0)
            {
                textField1.setText("");
                JOptionPane.showMessageDialog(addTest, "输入非法,非零元个数需为正数,请重新输入");
            }
            else {
                M = new Matrix(a0, a1, a2);
                JOptionPane.showMessageDialog(addTest, "输入成功");
            }
        }
        catch (Exception e1){
            e1.printStackTrace();
        }

    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        int sum;
        try {
            String[] Array = textField2.getText().split(" ");
            int a0 = Integer.parseInt(Array[0]);
            sum = a0;
            if(sum<=0)
            {
                textField1.setText("");
                JOptionPane.showMessageDialog(addTest, "幂数必须为正数,请重新输入");
                //throw new Exception("输入非法，行数和列数必须为正数,请重新输入");
            }
            else {
                JOptionPane.showMessageDialog(addTest, "输入成功");
            }
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
        

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JTextArea textArea2;
    private JLabel label3;
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    private JLabel label4;
    private JButton button1;
    private JLabel label5;
    private JTextField textField2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        textArea2 = new JTextArea();
        label3 = new JLabel();
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        label4 = new JLabel();
        button1 = new JButton();
        label5 = new JLabel();
        textField2 = new JTextField();
        button2 = new JButton();

        //======== this ========
        setIconImage(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\wizard\uff0c\u7b14\u8bb0\u672c\u7535\u8111.png").getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_8"));
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(25, 20, 250, 30);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_6"));
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(30, 65, 210, 30);
        contentPane.add(textField1);
        textField1.setBounds(225, 20, 185, 35);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 6f));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(40, 110, 195, 155);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setFont(textArea2.getFont().deriveFont(textArea2.getFont().getSize() + 6f));
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(350, 110, 195, 155);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_6"));
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setBorder(new EtchedBorder());
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label3Clicked(e);
            }
        });
        contentPane.add(label3);
        label3.setBounds(255, 185, 78, 40);

        //======== scrollPane3 ========
        {

            //---- textArea3 ----
            textArea3.setFont(textArea3.getFont().deriveFont(textArea3.getFont().getSize() + 6f));
            scrollPane3.setViewportView(textArea3);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(80, 370, 445, 175);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_4"));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
        label4.setBorder(new EtchedBorder());
        label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label4Clicked(e);
            }
        });
        contentPane.add(label4);
        label4.setBounds(255, 320, 78, 40);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_3"));
        button1.setBorder(new EtchedBorder());
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(435, 15, 78, 40);

        //---- label5 ----
        label5.setText(bundle.getString("label5.text"));
        contentPane.add(label5);
        label5.setBounds(30, 280, 210, 30);
        contentPane.add(textField2);
        textField2.setBounds(230, 275, 180, 40);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_3"));
        button2.setBackground(new Color(153, 153, 153));
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(445, 275, 105, 45);

        contentPane.setPreferredSize(new Dimension(575, 595));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
