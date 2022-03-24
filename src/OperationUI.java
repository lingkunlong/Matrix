import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
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
        setTitle("稀疏矩阵加法运算");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here

        String[] Array = textField1.getText().split(" ");
        int a0 = Integer.parseInt(Array[0]);
        int a1 = Integer.parseInt(Array[1]);
        int a2 = Integer.parseInt(Array[2]);
        M = new TripleMatrix(a0,a1,a2);
        JOptionPane.showMessageDialog(addTest,"输入成功");

    }

    private void textField1(ActionEvent e) {
        // TODO add your code here

    }

    private void button2(ActionEvent e) {
        // TODO add your code here

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

        String[] Array = textField4.getText().split(" ");
        int a0 = Integer.parseInt(Array[0]);
        int a1 = Integer.parseInt(Array[1]);
        int a2 = Integer.parseInt(Array[2]);
        M1 = new TripleMatrix(a0,a1,a2);

        JOptionPane.showMessageDialog(addTest,"输入成功");

    }

    private void button4(ActionEvent e) {
        // TODO add your code here

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
        textArea4.setText(s);

        JOptionPane.showMessageDialog(addTest,"输入成功");

    }

    private void ResultA(ActionEvent e) {
        // TODO add your code here

    }

    private void textArea1CaretUpdate(CaretEvent e) {
        // TODO add your code here

    }

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
        }
        for (ii = 0; ii < M.m; ii++) {
            for (jj = 0; jj < M.n; jj++) {
                s = s + Integer.toString(Array2[ii][jj]) + " ";
            }
            s=s+"\n";
        }
        textArea5.setText(s);
        new ResultA(this.textArea5.getText()).setVisible(true);
    }

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
        if (M.m == M1.m && M.n == M1.n) {
            for (ii = 0; ii < M.m; ii++)
                for (jj = 0; jj < M.n; jj++)
                    Array2[ii][jj] = Array[ii][jj] - Array1[ii][jj];
        }
        for (ii = 0; ii < M.m; ii++) {
            for (jj = 0; jj < M.n; jj++) {
                s = s + Integer.toString(Array2[ii][jj]) + " ";
            }
            s=s+"\n";
        }
        textArea5.setText(s);
    }

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
            for(ii=0;ii<M.m;ii++){
                for(jj=0;jj<M1.n;jj++){
                    int sum=0;
                    for(int k=0;k<M.n;k++){
                        sum+=Array[ii][k]*Array1[k][jj];}
                    Array2[ii][jj]=sum;}}

        }

        for(ii=0;ii<M.m;ii++){
            for(jj=0;jj<M1.n;jj++){
                s=s+Integer.toString(Array2[ii][jj])+" ";}

            s=s+"\n";}
        textArea5.setText(s);
    }

    private void button8(ActionEvent e) {
        // TODO add your code here
        /*int ii,jj;
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

        textArea5.setText(s);*/
        new Trans_Frame().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        textField4 = new JTextField();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();
        textArea4 = new JTextArea();
        scrollPane2 = new JScrollPane();
        textArea5 = new JTextArea();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(bundle.getString("label1.text"));
        contentPane.add(label1);
        label1.setBounds(25, 35, 165, 30);

        //---- label2 ----
        label2.setText(bundle.getString("label2.text"));
        contentPane.add(label2);
        label2.setBounds(25, 80, 105, 30);

        //---- textField1 ----
        textField1.addActionListener(e -> textField1(e));
        contentPane.add(textField1);
        textField1.setBounds(215, 30, 100, 35);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_2"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(350, 27, 78, 40);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_2"));
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(215, 215, 78, 40);

        //---- label3 ----
        label3.setText(bundle.getString("label3.text"));
        contentPane.add(label3);
        label3.setBounds(25, 345, 165, 25);

        //---- label4 ----
        label4.setText(bundle.getString("label4.text"));
        contentPane.add(label4);
        label4.setBounds(25, 385, 105, 17);
        contentPane.add(textField4);
        textField4.setBounds(215, 340, 100, 35);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_2"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(350, 335, 78, 40);

        //---- button4 ----
        button4.setText(bundle.getString("button4.text_2"));
        button4.addActionListener(e -> button4(e));
        contentPane.add(button4);
        button4.setBounds(215, 505, 78, 40);

        //---- button5 ----
        button5.setText(bundle.getString("button5.text"));
        button5.addActionListener(e -> {
			ResultA(e);
			button5(e);
		});
        contentPane.add(button5);
        button5.setBounds(60, 620, 75, 40);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.addCaretListener(e -> textArea1CaretUpdate(e));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 135, 170, 195);
        contentPane.add(textArea2);
        textArea2.setBounds(315, 135, 170, 195);
        contentPane.add(textArea3);
        textArea3.setBounds(25, 420, 170, 195);
        contentPane.add(textArea4);
        textArea4.setBounds(315, 420, 170, 195);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textArea5);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(550, 140, 185, 450);

        //---- button6 ----
        button6.setText(bundle.getString("button6.text"));
        button6.addActionListener(e -> button6(e));
        contentPane.add(button6);
        button6.setBounds(245, 620, 75, 40);

        //---- button7 ----
        button7.setText(bundle.getString("button7.text"));
        button7.addActionListener(e -> button7(e));
        contentPane.add(button7);
        button7.setBounds(440, 620, 75, 40);

        //---- button8 ----
        button8.setText(bundle.getString("button8.text"));
        button8.addActionListener(e -> button8(e));
        contentPane.add(button8);
        button8.setBounds(615, 620, 75, 40);

        contentPane.setPreferredSize(new Dimension(765, 715));
        setSize(765, 715);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField4;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JScrollPane scrollPane2;
    private JTextArea textArea5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
