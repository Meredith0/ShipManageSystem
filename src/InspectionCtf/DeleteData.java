/*
 * Created by JFormDesigner on Fri Nov 16 15:29:42 CST 2018
 */

package InspectionCtf;

import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author Meredith
 */
public class DeleteData extends JFrame
{
    SQL db = new SQL();
    public DeleteData()
    {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e)
    {
        /**
         * @description: 删除船只检验证资料
         * @param [e]
         * @return void
         * @date: 2018/11/16 15:33
         */
        db.sqlLines = "delete from 船只检验证书 where 船名=? and 船检登记号=?";
        db.pre();
        try
        {
            db.preparedStatement.setString(1, textField1.getText());
            db.preparedStatement.setString(2, textField2.getText());
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

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this2 = new JFrame();
        label1 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();

        //======== this2 ========
        {
            this2.setVisible(true);
            Container this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)this2ContentPane.getLayout()).columnWidths = new int[] {55, 141, 76, 86, 68, 0};
            ((GridBagLayout)this2ContentPane.getLayout()).rowHeights = new int[] {0, 93, 0, 36, 36, 38, 38, 40, 0};
            ((GridBagLayout)this2ContentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)this2ContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label1 ----
            label1.setText("             \u5220\u9664\u8239\u53ea\u68c0\u9a8c\u8bc1\u4fe1\u606f");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
            this2ContentPane.add(label1, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label3 ----
            label3.setText("        \u8239\u53ea\u540d\u79f0");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
            this2ContentPane.add(label3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2ContentPane.add(textField1, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label2 ----
            label2.setText("    \u8239\u68c0\u767b\u8bb0\u53f7");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
            this2ContentPane.add(label2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2ContentPane.add(textField2, new GridBagConstraints(2, 4, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.addActionListener(e -> button1ActionPerformed(e));
            this2ContentPane.add(button1, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2.pack();
            this2.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame this2;
    private JLabel label1;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
