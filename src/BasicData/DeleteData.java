/*
 * Created by JFormDesigner on Thu Nov 15 21:49:48 CST 2018
 */

package BasicData;

import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author Meredith
 */
public class DeleteData extends JFrame {
    SQL db = new SQL();

    public DeleteData() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        /**
         * @description: 删除船只资料
         * @param [e]
         * @return void
         * @date: 2018/11/15 21:58
         */
        db.sqlLines = "delete  from 船舶所有权登记证书 where 船名=?";
        db.pre();
        try
        {
            db.preparedStatement.setString(1, textField1.getText());
        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }
        db.exeSql();
        if (db.effectedLines > 0)
        {
            JOptionPane.showMessageDialog(null, "删除成功", "", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showMessageDialog(null, "删除失败", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {55, 141, 76, 86, 53, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 93, 0, 36, 40, 31, 52, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("               \u5220\u9664\u8239\u53ea\u8d44\u6599");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label3 ----
        label3.setText("        \u8239\u53ea\u540d\u79f0");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField1, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label3;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
