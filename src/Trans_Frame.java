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

/*
/**
 * @author 86188
 */
public class Trans_Frame extends JFrame {
    public Matrix M=new Matrix();
    public Matrix M1=new Matrix();
    private Component addTest;

    public static void main(String[] args) {
        new Trans_Frame();
    }
    public Trans_Frame() {
        initComponents();
        setVisible(true);
        setResizable(true);
        setTitle("稀疏矩阵转置运算");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        label1.setFont(new Font("楷体",Font.BOLD,15));
        label2.setFont(new Font("楷体",Font.BOLD,15));
        label3.setFont(new Font("楷体",Font.BOLD,15));
        button2.setFont(new Font("楷体",Font.BOLD,25));
        button1.setFont(new Font("楷体",Font.BOLD,25));
        button3.setFont(new Font("楷体",Font.BOLD,25));

        menu1.setFont(new Font("楷体",Font.BOLD,20));
    }
//创建矩阵并显示
    private void button2(ActionEvent e){

        String[] Array1 = textArea1.getText().split("\n");
        String[] Array2;
        for(int i=0;i<M.vnum;i++){
            Array2 = Array1[i].split(" ");
            int b0 = Integer.parseInt(Array2[0]);
            int b1 = Integer.parseInt(Array2[1]);
            int b2 = Integer.parseInt(Array2[2]);
            if((b0>M.rnum-1||b0<0)||(b1>M.lnum-1||b1<0)){
                JOptionPane.showMessageDialog(addTest, "输入非法，行数和列数不能越界,请重新输入");
                textArea1.setText("");
                break;
            }
            else if (b2 ==0){
                JOptionPane.showMessageDialog(addTest, "输入非法，非零元不能为零,请重新输入");
                textArea1.setText("");
                break;
            }
            else{
                M.data[i] = new Triple(b0, b1, b2);}
        }
        String str = "";
        String str1 = "";
        int p = 0,k,h;
        for (int row = 0; row < M.rnum; row++) {
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
                str1 = Integer.toString(p);
                str = str + str1 + " ";
            }
            str = str + "\n";
        }
        textArea2.setText(str);
        JOptionPane.showMessageDialog(addTest, "创建成功");
    }

    private void button3(ActionEvent e) {
        String str = "";
        //将转置值放入转置矩阵
        M1 = new Matrix(M.lnum,M.rnum,M.vnum);
        for (int i = 0;i<M.vnum;i++)
        {
            M1.data[i] =  new Triple(M.data[i].line,M.data[i].rows,M.data[i].value);
        }

        for(int ii=0;ii<M1.rnum;ii++){
            for(int jj=0;jj<M1.lnum;jj++){
                String p="";
                for(int index1=0;index1<M1.vnum;index1++)
                {
                    if(ii==M1.data[index1].rows&&jj==M1.data[index1].line)
                    {
                        p=Integer.toString(M1.data[index1].value);
                    }
                }
                if(p=="")
                {
                    p="0";
                }
                str = str+p+" ";
            }
            str=str+"\n";
        }
        textArea3.setText(str);
    }

    private void menu1(ActionEvent e) {
        // TODO add your code here
        new Help1().setVisible(true);
    }

    private void menu1MouseClicked(MouseEvent e) {
        // TODO add your code here
        new Help1().setVisible(true);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        try {
            String[] Array = textField1.getText().split(" ");//split用于分割
            int a0 = Integer.parseInt(Array[0]);
            int a1 = Integer.parseInt(Array[1]);
            int a2 = Integer.parseInt(Array[2]);

            if(a0<=0||a1<=0||a2<=0){
                textField1.setText("");
                JOptionPane.showMessageDialog(addTest, "输入非法，行数、列数、非零元个数必须为正数,请重新输入");
                //throw new Exception("输入非法，行数和列数必须为正数,请重新输入");
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
        scrollPane3 = new JScrollPane();
        textArea3 = new JTextArea();
        panel1 = new JPanel();
        button1 = new JButton();
        button3 = new JButton();

        //======== this ========
        setIconImage(new ImageIcon("C:\\Users\\lyjyyy\\Desktop\\wizard\uff0c\u7b14\u8bb0\u672c\u7535\u8111.png").getImage());
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

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_4"));
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(290, 40, 90, 50);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_2"));
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(35, 325, 90, 45);

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
    private JScrollPane scrollPane3;
    private JTextArea textArea3;
    private JPanel panel1;
    private JButton button1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
