import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        panel1 = new JPanel();
        label1 = new JLabel();

        //======== this ========
        setAlwaysOnTop(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setBackground(new Color(204, 204, 204));
            textArea1.setFont(textArea1.getFont().deriveFont(textArea1.getFont().getSize() + 6f));
            textArea1.setForeground(Color.black);
            textArea1.setOpaque(false);
            textArea1.addCaretListener(e -> textArea1CaretUpdate(e));
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(50, 25, 285, 230);

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
        panel1.setBounds(new Rectangle(new Point(0, 260), panel1.getPreferredSize()));

        //---- label1 ----
        label1.setText(bundle.getString("label1.text_4"));
        label1.setIcon(new ImageIcon("D:\\\u5411\u65e5\u8475\\\u6781\u7b80\u80cc\u666f\u7684\u641c\u7d22\u7ed3\u679c_\u767e\u5ea6\u56fe\u7247\u641c\u7d22\\src_http___img9.51tietu.net_pic_2019-091121_cr4ljqssqgqcr4ljqssqgq.jpg&refer_http___img9.51tietu.jpg"));
        contentPane.add(label1);
        label1.setBounds(-440, 0, 940, 320);

        contentPane.setPreferredSize(new Dimension(390, 320));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JPanel panel1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
