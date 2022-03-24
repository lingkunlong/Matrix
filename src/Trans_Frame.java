import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue Mar 22 19:12:20 CST 2022
 */



/**
 * @author unknown
 */
class Triple1{

    int x,y;
    int weight;
    public Triple1(){}
    public Triple1(int x,int y,int weight){

        this.x=x;
        this.y=y;
        this.weight=weight;
    }
}
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
        setTitle("转置运算");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        String[] Array = textField1.getText().split(" ");
        int a0 = Integer.parseInt(Array[0]);
        int a1 = Integer.parseInt(Array[1]);
        int a2 = Integer.parseInt(Array[2]);
        M = new TripleMatrix1(a0,a1,a2);
        JOptionPane.showMessageDialog(addTest,"输入成功");
    }

    private void button2(ActionEvent e) {

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
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

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_2"));
        contentPane.add(label1);
        label1.setBounds(15, 20, 160, 30);
        contentPane.add(textField1);
        textField1.setBounds(20, 50, 190, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_3"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(225, 50, button1.getPreferredSize().width, 35);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text_2"));
        contentPane.add(label2);
        label2.setBounds(20, 85, 135, 25);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 115, 185, 145);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(285, 115, 185, 145);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(220, 150, 60, 50);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text_2"));
        contentPane.add(label3);
        label3.setBounds(35, 285, 80, 20);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(30, 310, 75, 45);

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(textArea3);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(150, 300, 280, 200);

        contentPane.setPreferredSize(new Dimension(490, 550));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
