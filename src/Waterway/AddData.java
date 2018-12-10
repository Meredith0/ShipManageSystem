/*
 * Created by JFormDesigner on Mon Dec 10 16:58:49 CST 2018
 */

package Waterway;

import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author Meredith
 */
public class AddData extends JFrame {

    SQL db = new SQL();
    public AddData() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        /**
         * @description: 录入数据到表 [水运费纪录表]
         * @param [e]
         * @return void
         * @date: 2018/11/17 10:42
         */
        db.sqlLines = "insert into 航道费纪录表(船名,船检登记号,航道费用,航道费合计,填表日期,签注记录) values(?,?,?,?,?,?)";
        db.pre();
        try
        {
            db.preparedStatement.setString(1, textField11.getText());
            db.preparedStatement.setString(2, textField12.getText());
            db.preparedStatement.setString(3, textField1.getText());
            db.preparedStatement.setString(4, textField2.getText());
            db.preparedStatement.setString(5, textField5.getText());
            db.preparedStatement.setString(6, textField3.getText());
        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }
        db.exeSql();
        if (db.effectedLines > 0)
        {
            JOptionPane.showMessageDialog(null, "录入数据成功", "", JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showMessageDialog(null, "录入数据失败", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this2 = new JFrame();
        label2 = new JLabel();
        label15 = new JLabel();
        textField11 = new JTextField();
        label17 = new JLabel();
        label16 = new JLabel();
        textField12 = new JTextField();
        label3 = new JLabel();
        textField1 = new JTextField();
        label9 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField5 = new JTextField();
        label10 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();

        //======== this2 ========
        {
            this2.setVisible(true);
            Container this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)this2ContentPane.getLayout()).columnWidths = new int[] {66, 116, 157, 71, 115, 171, 41, 0};
            ((GridBagLayout)this2ContentPane.getLayout()).rowHeights = new int[] {29, 0, 38, 37, 35, 13, 35, 35, 35, 44, 14, 14, 14, 14, 13, 14, 13, 0};
            ((GridBagLayout)this2ContentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)this2ContentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label2 ----
            label2.setText("\u7f34\u7eb3\u822a\u9053\u8d39\u7684\u57fa\u672c\u60c5\u51b5");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 13f));
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            this2ContentPane.add(label2, new GridBagConstraints(1, 1, 5, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label15 ----
            label15.setText("\u8239\u540d");
            label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 4f));
            this2ContentPane.add(label15, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2ContentPane.add(textField11, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label17 ----
            label17.setText("\u2190\u5173\u8054\u2192");
            label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 6f));
            this2ContentPane.add(label17, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label16 ----
            label16.setText("\u8239\u68c0\u767b\u8bb0\u53f7");
            label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 4f));
            this2ContentPane.add(label16, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2ContentPane.add(textField12, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label3 ----
            label3.setText("\u822a\u9053\u8d39\u7528");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
            this2ContentPane.add(label3, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2ContentPane.add(textField1, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label9 ----
            label9.setText("\u822a\u9053\u8d39\u5408\u8ba1");
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 4f));
            this2ContentPane.add(label9, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2ContentPane.add(textField2, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label4 ----
            label4.setText("\u586b\u8868\u65e5\u671f");
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
            this2ContentPane.add(label4, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2ContentPane.add(textField5, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label10 ----
            label10.setText("\u7b7e\u6ce8\u8bb0\u5f55");
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 4f));
            this2ContentPane.add(label10, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2ContentPane.add(textField3, new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- button1 ----
            button1.setText("\u786e\u8ba4");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 7f));
            button1.addActionListener(e -> button1ActionPerformed(e));
            this2ContentPane.add(button1, new GridBagConstraints(5, 9, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            this2.pack();
            this2.setLocationRelativeTo(this2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame this2;
    private JLabel label2;
    private JLabel label15;
    private JTextField textField11;
    private JLabel label17;
    private JLabel label16;
    private JTextField textField12;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label9;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField5;
    private JLabel label10;
    private JTextField textField3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
