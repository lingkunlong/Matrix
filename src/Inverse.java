import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;
/*
 * Created by JFormDesigner on Thu Apr 07 21:58:43 CST 2022
 */

/**
 * @author unknown
 */
public class Inverse extends JFrame {
    public TripleMatrix M = new TripleMatrix();
    public TripleMatrix M1 = new TripleMatrix();
    public TripleMatrix M2 = new TripleMatrix();
    private Component addTest;
    public static double Det(double[][] Matrix,int N)//计算n阶行列式（N=n-1）
    {
        int T0;
        int T1;
        int T2;
        double Num;
        int Cha;
        double [][] B;
        if(N>0)
        {
            Cha=0;
            B=new double[N][N];
            Num=0;
            if(N==1)
            {
                return Matrix[0][0]*Matrix[1][1]-Matrix[0][1]*Matrix[1][0];
            }
            //T0循环
            for (T0=0;T0<=N;T0++)
            {
                //T1循环
                for (T1=1;T1<=N;T1++)
                {
                    //T2循环
                    for (T2=0;T2<=N-1;T2++)
                    {
                        if(T2==T0)
                        {
                            Cha=1;
                        }
                        B[T1-1][T2]=Matrix[T1][T2+Cha];
                    }
                    //T2循环
                    Cha=0;
                }
                //T1循环
                Num=Num+Matrix[0][T0]*Det(B,N-1)*Math.pow((-1),T0);
            }
            //T0循环
            return Num;
        } else if(N==0)
        {
            return Matrix[0][0];
        }
        return 0;
    }
    public static double Inverse(double[][]Matrix,int N,double[][]MatrixC){
        int T0;
        int T1;
        int T2;
        int T3;
        double [][]B;
        int Chay;
        int Chax;
        B=new double[N][N];
        double add;
        add=1/Det(Matrix,N);
        for ( T0=0;T0<=N;T0++)
        {
            for (T3=0;T3<=N;T3++)
            {
                for (T1=0;T1<=N-1;T1++)
                {
                    if(T1<T0)
                    {
                        Chax=0;
                    } else
                    {
                        Chax=1;
                    }
                    for (T2=0;T2<=N-1;T2++)
                    {
                        if(T2<T3)
                        {
                            Chay=0;
                        } else
                        {
                            Chay=1;
                        }
                        B[T1][T2]=Matrix[T1+Chax][T2+Chay];
                    }
                    //T2循环
                }//T1循环
                Det(B,N-1);
                MatrixC[T3][T0]=Det(B,N-1)*add*(Math.pow(-1, T0+T3));
            }
        }
        return 0;
    }
    public Inverse() {
        initComponents();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("求逆矩阵");
    }

    private void label3Clicked(MouseEvent e) throws Exception {
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
//求逆矩阵
    private void label4Clicked(MouseEvent e) {
        // TODO add your code here
        String s = "";
        int index;
        int jj,ii;
        double[][] Array = new double[M.m][M.n];

        for(index=0;index<M.num;index++){
        for(ii=0;ii<M.m;ii++){
        for(jj=0;jj<M.n;jj++){
        if(ii==M.data[index].x&&jj==M.data[index].y){
        Array[ii][jj]=M.data[index].weight;}}}}

        int p=0, q=0, k, h;
        if (M.m == M.n) {
            String ch = "";
            double[][]InMatrix=new double[3][3];
            Inverse(Array,2,InMatrix);
            String str=new String("");
            for (int i=0;i<3;i++)
            {
                for (int j=0;j<3;j++)
                {
                    String strr=String.valueOf(InMatrix[i][j]);
                    str+=strr;
                    str+=" ";
                }
                str+="\n";
            }
            textArea3.setText(str);
        }else {
            JOptionPane.showMessageDialog(addTest, "运算不合法，终止运算");
        }
    }
    //按行和列位置进行遍历
            /*for (int row = 0; row < M.m; row++) {
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
            }*/



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

        //======== this ========
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
        label2.setBounds(25, 60, 210, 30);
        contentPane.add(textField1);
        textField1.setBounds(295, 20, 185, 35);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 6f));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(40, 110, 195, 175);

        //======== scrollPane2 ========
        {

            //---- textArea2 ----
            textArea2.setFont(textArea2.getFont().deriveFont(textArea2.getFont().getSize() + 6f));
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(350, 110, 205, 175);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_6"));
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label3Clicked(e);
            }
        });
        contentPane.add(label3);
        label3.setBounds(267, 185, 50, 35);

        //======== scrollPane3 ========
        {

            //---- textArea3 ----
            textArea3.setFont(textArea3.getFont().deriveFont(textArea3.getFont().getSize() + 6f));
            scrollPane3.setViewportView(textArea3);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(80, 350, 445, 195);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text_4"));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
        label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label4Clicked(e);
            }
        });
        contentPane.add(label4);
        label4.setBounds(230, 305, 145, 35);

        contentPane.setPreferredSize(new Dimension(575, 595));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
