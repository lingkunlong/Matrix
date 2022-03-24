import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Tue Mar 22 20:23:38 CST 2022
 */



/**
 * @author unknown
 */
public class ResultA extends JFrame {
    public TripleMatrix M=new TripleMatrix();
    public TripleMatrix M1=new TripleMatrix();
    public String str = "";
    public ResultA(String jText) {
        initComponents();
        this.str=jText;
        this.textArea1.setText(str);
    }

    private void setTextArea1(ActionEvent e) {
        // TODO add your code here

    }

    private void textArea1CaretUpdate(CaretEvent e) {
        // TODO add your code here

    }

    private void button1(ActionEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setAlwaysOnTop(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.addCaretListener(e -> textArea1CaretUpdate(e));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 25, 285, 230);

        contentPane.setPreferredSize(new Dimension(390, 335));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
