/*
 * Created by JFormDesigner on Wed Nov 21 17:53:55 CST 2018
 */

package Login;

import javax.swing.*;
import java.awt.*;

/**
 * @author Meredith
 */
public class Config extends JFrame {

    public Config() {
        initComponents();
        setConfig();
    }

    private void setConfig() {
        textField2.setText("127.0.0.1");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label5 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{63, 28, 14, 0, 54, 79, 40, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 55, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        //---- label5 ----
        label5.setText("\u914d\u7f6e\u670d\u52a1\u5668\u4fe1\u606f");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 6f));
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label5, new GridBagConstraints(0, 1, 9, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        //---- label2 ----
        label2.setText("IP");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2, new GridBagConstraints(1, 3, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField2, new GridBagConstraints(4, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label5;
    private JLabel label2;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
