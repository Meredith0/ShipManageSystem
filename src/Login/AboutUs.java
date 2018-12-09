/*
 * Created by JFormDesigner on Wed Nov 21 17:01:20 CST 2018
 */

package Login;

import javax.swing.*;
import java.awt.*;

/**
 * @author Meredith
 */
public class AboutUs extends JFrame {

    public AboutUs() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        textArea1 = new JTextArea();
        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        //---- label1 ----
        label1.setText("\u6570\u636e\u5e93\u8bfe\u7a0b\u8bbe\u8ba1");
        label1.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 35));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(0, 0, 455, 75);
        //---- label2 ----
        label2.setText("\u8239\u53ea\u8d44\u6599\u7ba1\u7406\u7cfb\u7edf");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 9f));
        contentPane.add(label2);
        label2.setBounds(5, 65, 450, 60);
        //---- label3 ----
        label3.setText("\u66fe\u950b\u6977  \u5f20\u8fdc\u4eae");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 7f));
        contentPane.add(label3);
        label3.setBounds(0, 130, 455, 35);
        //---- label4 ----
        label4.setText("\u6307\u5bfc\u8001\u5e08: \u767d\u4f1f\u534e");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 5f));
        contentPane.add(label4);
        label4.setBounds(0, 170, 455, 35);
        //---- label5 ----
        label5.setText("\u6e90\u4ee3\u7801:");
        contentPane.add(label5);
        label5.setBounds(210, 220, label5.getPreferredSize().width, 17);
        //---- textArea1 ----
        textArea1.setText("https://github.com/Meredith0/ShipManageSystem");
        textArea1.setEditable(false);
        textArea1.setFont(new Font("Monaco", Font.PLAIN, 12));
        contentPane.add(textArea1);
        textArea1.setBounds(60, 240, 350, 24);
        contentPane.setPreferredSize(new Dimension(460, 320));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
