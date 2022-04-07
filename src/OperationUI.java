import java.awt.*;
import java.awt.event.*;
import java.security.interfaces.RSAKey;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.plaf.*;

/*
 * Created by JFormDesigner on Tue Mar 22 19:10:17 CST 2022
 */
//定义三元组
class Triple{

    int x,y;//非零元的行下标和列下标
    int weight;//非零元的值
    public Triple(){}
    public Triple(int x,int y,int weight){

        this.x=x;
        this.y=y;
        this.weight=weight;
    }
}
class TripleMatrix {

    int m, n;//矩阵的行数和列数
    int num;//非零元个数
    Triple[] data = new Triple[100];//非零三元组表

    public TripleMatrix() {
    }
    public TripleMatrix(int m, int n, int num) {

        this.m = m;
        this.n = n;
        this.num = num;
    }
}
public class OperationUI extends JFrame {
        public TripleMatrix M = new TripleMatrix();
        public TripleMatrix M1 = new TripleMatrix();
        public TripleMatrix M2 = new TripleMatrix();
        private Component addTest;
        //构造方法
        public int Find(TripleMatrix M, int i, int j) {
            //查找三元组内的非零元
            for (int t = 0; t < M.num; t++) {
                if (M.data[t].x == i && M.data[t].y == j)
                    return M.data[t].weight;
            }
            return 0;
        }

        //public Triple triple = new Triple();
        public OperationUI() {
            initComponents();
            setTitle("稀疏矩阵运算");
            setResizable(false);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
//创建第一个矩阵
        private void button2(ActionEvent e) throws Exception {
            //输入矩阵行数和列数和非零元个数
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

            //输入非零元位置
            int i = 0;
            String[] Array1 = textArea1.getText().split("\n");
            String[] Array2;
            for (i = 0; i < M.num; i++) {
                //按照空格来拆分此字符串
                Array2 = Array1[i].split(" ");
                //将字符串参数解析返回十进制
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
//创建第二个矩阵
        private void button4(ActionEvent e) throws Exception {
            String[] Array = textField4.getText().split(" ");
            int a0 = Integer.parseInt(Array[0]);
            int a1 = Integer.parseInt(Array[1]);
            int a2 = Integer.parseInt(Array[2]);
            if(a0<=0||a1<=0){
                textField4.setText("");
                throw new Exception("输入非法，行数和列数必须为正数,请重新输入");
            }else {
                M1 = new TripleMatrix(a0, a1, a2);
            }

            int i = 0;
            String[] Array1 = textArea3.getText().split("\n");

            String[] Array2;
            for (i = 0; i < M1.num; i++) {
                Array2 = Array1[i].split(" ");
                int aa0 = Integer.parseInt(Array2[0]);
                int aa1 = Integer.parseInt(Array2[1]);
                int aa2 = Integer.parseInt(Array2[2]);
                if((aa0>M1.m-1||aa0<0)||(aa1>M1.n-1||aa1<0)){
                    JOptionPane.showMessageDialog(addTest, "输入非法，行数和列数不能越界,请重新输入");
                    textArea3.setText("");
                    break;
                }
                else if (aa2 ==0){
                    JOptionPane.showMessageDialog(addTest, "输入非法，非零元不能为零,请重新输入");
                    textArea3.setText("");
                    break;
                }
                else{
                    M1.data[i] = new Triple(aa0, aa1, aa2);}
            }
            String s = "";
            String ch = "";
            int p = 0,k,h;
            for (int row = 0; row < M1.m; row++) {
                for (int line = 0; line < M1.n; line++) {
                    for (k = 0, h = 0; k < M1.num; k++) {
                        if (M1.data[k].x == row && M1.data[k].y == line) {
                            p = M1.data[k].weight;
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
            textArea4.setText(s);
            JOptionPane.showMessageDialog(addTest, "创建成功");
        }
        //废弃的二维数组存储
            /*int ii, jj;
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
                s = s + "\n";
            }
            textArea4.setText(s);
            JOptionPane.showMessageDialog(addTest, "创建成功");
        }*/
        //执行加法操作
        private void button5(ActionEvent e) {
            String s = "";
            int p=0, q=0, k, h;
            if (M.m == M1.m && M.n == M1.n) {

                String ch = "";
                //按行和列位置进行遍历
                for (int row = 0; row < M.m; row++) {
                    for (int line = 0; line < M.n; line++) {
                        //遍历第一个矩阵
                        for (k = 0, h = 0; k < M.num; k++) {

                            if (M.data[k].x == row && M.data[k].y == line) {
                                p = M.data[k].weight;
                                h = 1;
                                break;
                            }
                        }
                        if (h == 0) {
                            p = 0;}
                        //遍历第二个矩阵
                        for (k = 0, h = 0; k < M1.num; k++) {
                            if (M1.data[k].x == row && M1.data[k].y == line) {
                                q = M1.data[k].weight;
                                h = 1;
                                break;
                            }
                        }
                        if (h == 0) {
                            q = 0;}
                        //将结果返回并用字符串拼接起来
                        ch = Integer.toString(p + q);
                        if (ch == "") {
                            ch = "0";
                        }
                        s = s + ch + " ";
                    }
                    s = s + "\n";
                }
                textArea5.setText(s);
            }else {
                JOptionPane.showMessageDialog(addTest, "运算不合法，终止运算");
            }
        }
        //执行减法操作
        private void button6(ActionEvent e) {
            int p=0, q=0, k, h;
            String s = "";
            //两个矩阵的行数和列数要相同才能进行操作
            if (M.m == M1.m && M.n == M1.n) {

                String ch = "";
                //行和列
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

                        for (k = 0, h = 0; k < M1.num; k++) {
                            if (M1.data[k].x == row && M1.data[k].y == line) {
                                q = M1.data[k].weight;
                                h = 1;
                                break;
                            }
                        }
                        if (h == 0) {q = 0;}
                        ch = Integer.toString(p - q);
                        if (ch == "") {
                            ch = "0";
                        }
                        s = s + ch + " ";
                    }
                    s = s + "\n";
                }
                textArea5.setText(s);
            } else {
                JOptionPane.showMessageDialog(addTest, "运算不合法，终止运算");
            }
        }
        //执行乘法操作
        private void button7(ActionEvent e) {
            String s = "";
            if (M.n == M1.m) {
                for(int row=0;row<M.m;row++){
                    for(int line=0;line<M1.n;line++){
                        int L=0;
                        String ch="";

                        for(int k=0;k<M.n;k++){

                            int p=Find(M,row,k);
                            int q=Find(M1,k,line);
                            L=L+p*q;
                            ch=Integer.toString(L);}

                        if(ch==""){ch="0";}
                        s=s+ch+" ";
                    }
                    s=s+"\n";
                }
                textArea5.setText(s);
            }
            else {
                JOptionPane.showMessageDialog(addTest, "运算不合法，终止运算");
            }
        }
        //转置窗口
        private void button8(ActionEvent e) {
            new Trans_Frame().setVisible(true);
        }

        private void menu1MouseClicked(MouseEvent e) {
            new Help().setVisible(true);
        }

        private void menu2MouseClicked(MouseEvent e) {
            new About().setVisible(true);
        }

        private void menu1(ActionEvent e) {
            // TODO add your code here
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

        private void menu3MouseClicked(MouseEvent e) {
            // TODO add your code here
            new Inverse().setVisible(true);
        }


        //界面
        private void initComponents() {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            ResourceBundle bundle = ResourceBundle.getBundle("form");
            menuBar1 = new JMenuBar();
            menu1 = new JMenu();
            menu2 = new JMenu();
            menu3 = new JMenu();
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
            button6 = new JButton();
            button7 = new JButton();
            button8 = new JButton();
            scrollPane2 = new JScrollPane();
            textArea2 = new JTextArea();
            scrollPane3 = new JScrollPane();
            textArea3 = new JTextArea();
            scrollPane4 = new JScrollPane();
            textArea4 = new JTextArea();
            scrollPane5 = new JScrollPane();
            textArea5 = new JTextArea();
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

                //======== menu3 ========
                {
                    menu3.setText(bundle.getString("menu3.text"));
                    menu3.setFont(menu3.getFont().deriveFont(menu3.getFont().getSize() + 3f));
                    menu3.setOpaque(false);
                    menu3.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            menu3MouseClicked(e);
                        }
                    });
                }
                menuBar1.add(menu3);
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
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 4f));
            button2.addActionListener(e -> {
                try {
                    button2(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
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
            button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 4f));
            button4.addActionListener(e -> {
                try {
                    button4(e);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            contentPane.add(button4);
            button4.setBounds(215, 505, 78, 40);

            //---- button5 ----
            button5.setText(bundle.getString("button5.text"));
            button5.setContentAreaFilled(false);
            button5.setBorder(new EtchedBorder());
            button5.setForeground(Color.black);
            button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 4f));
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

            //---- button6 ----
            button6.setText(bundle.getString("button6.text"));
            button6.setContentAreaFilled(false);
            button6.setBorder(new EtchedBorder());
            button6.setForeground(Color.black);
            button6.setFont(button6.getFont().deriveFont(button6.getFont().getSize() + 4f));
            button6.addActionListener(e -> button6(e));
            contentPane.add(button6);
            button6.setBounds(245, 630, 75, 40);

            //---- button7 ----
            button7.setText(bundle.getString("button7.text"));
            button7.setContentAreaFilled(false);
            button7.setBorder(new EtchedBorder());
            button7.setForeground(Color.black);
            button7.setFont(button7.getFont().deriveFont(button7.getFont().getSize() + 4f));
            button7.addActionListener(e -> button7(e));
            contentPane.add(button7);
            button7.setBounds(440, 630, 75, 40);

            //---- button8 ----
            button8.setText(bundle.getString("button8.text"));
            button8.setContentAreaFilled(false);
            button8.setBorder(new EtchedBorder());
            button8.setForeground(Color.black);
            button8.setFont(button8.getFont().deriveFont(button8.getFont().getSize() + 4f));
            button8.addActionListener(e -> button8(e));
            contentPane.add(button8);
            button8.setBounds(615, 630, 75, 40);

            //======== scrollPane2 ========
            {

                //---- textArea2 ----
                textArea2.setBorder(new EtchedBorder());
                textArea2.setBackground(new Color(204, 204, 204));
                textArea2.setForeground(Color.black);
                textArea2.setFont(textArea2.getFont().deriveFont(textArea2.getFont().getSize() + 6f));
                textArea2.setOpaque(false);
                scrollPane2.setViewportView(textArea2);
            }
            contentPane.add(scrollPane2);
            scrollPane2.setBounds(315, 135, 170, 195);

            //======== scrollPane3 ========
            {

                //---- textArea3 ----
                textArea3.setBorder(new EtchedBorder());
                textArea3.setBackground(new Color(204, 204, 204));
                textArea3.setForeground(Color.black);
                textArea3.setFont(textArea3.getFont().deriveFont(textArea3.getFont().getSize() + 6f));
                textArea3.setOpaque(false);
                scrollPane3.setViewportView(textArea3);
            }
            contentPane.add(scrollPane3);
            scrollPane3.setBounds(25, 420, 170, 195);

            //======== scrollPane4 ========
            {

                //---- textArea4 ----
                textArea4.setBorder(new EtchedBorder());
                textArea4.setBackground(new Color(204, 204, 204));
                textArea4.setForeground(Color.black);
                textArea4.setFont(textArea4.getFont().deriveFont(textArea4.getFont().getSize() + 6f));
                textArea4.setOpaque(false);
                scrollPane4.setViewportView(textArea4);
            }
            contentPane.add(scrollPane4);
            scrollPane4.setBounds(315, 420, 170, 195);

            //======== scrollPane5 ========
            {

                //---- textArea5 ----
                textArea5.setBorder(new EtchedBorder());
                textArea5.setForeground(Color.black);
                textArea5.setBackground(new Color(204, 204, 204));
                textArea5.setFont(textArea5.getFont().deriveFont(textArea5.getFont().getSize() + 6f));
                textArea5.setOpaque(false);
                scrollPane5.setViewportView(textArea5);
            }
            contentPane.add(scrollPane5);
            scrollPane5.setBounds(520, 135, 218, 478);

            //---- label5 ----
            label5.setText(bundle.getString("label5.text"));
            label5.setIcon(new ImageIcon("D:\\\u5411\u65e5\u8475\\v2.jpg"));
            label5.setForeground(new Color(153, 153, 153));
            contentPane.add(label5);
            label5.setBounds(-460, 0, 1255, 865);

            contentPane.setPreferredSize(new Dimension(780, 755));
            setSize(780, 755);
            setLocationRelativeTo(null);
            // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        private JMenuBar menuBar1;
        private JMenu menu1;
        private JMenu menu2;
        private JMenu menu3;
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
        private JButton button6;
        private JButton button7;
        private JButton button8;
        private JScrollPane scrollPane2;
        private JTextArea textArea2;
        private JScrollPane scrollPane3;
        private JTextArea textArea3;
        private JScrollPane scrollPane4;
        private JTextArea textArea4;
        private JScrollPane scrollPane5;
        private JTextArea textArea5;
        private JLabel label5;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

