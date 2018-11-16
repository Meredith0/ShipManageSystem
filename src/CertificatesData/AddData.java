/*
 * Created by JFormDesigner on Thu Nov 15 22:26:34 CST 2018
 */

package CertificatesData;

import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author Meredith
 */
public class AddData extends JFrame
{
    SQL db = new SQL();
    public AddData()
    {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e)
    {
        /**
         * @description: 录入数据
         * @param [e]
         * @return void
         * @date: 2018/11/15 22:43
         */
         //将船只的检验证书基本信息录入到表 [船只检验证书]
         db.sqlLines="insert into 船只检验证书(船名,船检登记号,检验证编号,船舶所有人,船舶登记号,船舶检验类型,下次检验时间,通知时间,检验机关,检验证使用有效期至,发证日期,船只检验情况记录) " +
                 "values(?,?,?,?,?,?,?,?,?,?,?,?)";
         db.pre();
        try
        {
            db.preparedStatement.setString(1, textField11.getText());
            db.preparedStatement.setString(2, textField12.getText());
            db.preparedStatement.setString(3, textField1.getText());
            db.preparedStatement.setString(4, textField5.getText());
            db.preparedStatement.setString(5, textField6.getText());
            db.preparedStatement.setString(6, textField7.getText());
            db.preparedStatement.setString(7, textField8.getText());
            db.preparedStatement.setString(8, textField2.getText());
            db.preparedStatement.setString(9, textField3.getText());
            db.preparedStatement.setString(10, textField4.getText());
            db.preparedStatement.setString(11, textField9.getText());
            db.preparedStatement.setString(12, textField10.getText());
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

        //将证书有效期录入到表 [各证书有效期]
        db.sqlLines = "insert into 各证书有效期(证书名,证书有效期至) values(?,?)";
        db.pre();
        try
        {
            db.preparedStatement.setString(1,"船只检验证书");
            db.preparedStatement.setString(2,textField4.getText());
        } catch (SQLException e1)
        {
            e1.printStackTrace();
        }
        db.exeSql();
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
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
        label5 = new JLabel();
        textField6 = new JTextField();
        label11 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        textField7 = new JTextField();
        label12 = new JLabel();
        textField9 = new JTextField();
        label7 = new JLabel();
        textField8 = new JTextField();
        label13 = new JLabel();
        textField10 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {66, 116, 157, 71, 115, 171, 41, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 38, 37, 35, 13, 35, 35, 35, 35, 35, 35, 41, 36, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label2 ----
        label2.setText("             \u68c0\u9a8c\u8bc1\u4e66\u57fa\u672c\u8d44\u6599");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 13f));
        contentPane.add(label2, new GridBagConstraints(2, 0, 3, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label15 ----
        label15.setText("\u8239\u53ea\u540d\u79f0");
        label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 4f));
        contentPane.add(label15, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField11, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label17 ----
        label17.setText("\u2190\u5173\u8054\u2192");
        label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 6f));
        contentPane.add(label17, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label16 ----
        label16.setText("\u8239\u68c0\u767b\u8bb0\u53f7");
        label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 4f));
        contentPane.add(label16, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField12, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label3 ----
        label3.setText("\u68c0\u9a8c\u8bc1\u7f16\u53f7");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField1, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label9 ----
        label9.setText("\u901a\u77e5\u65f6\u95f4");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 4f));
        contentPane.add(label9, new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField2, new GridBagConstraints(5, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label4 ----
        label4.setText("\u8239\u8236\u6240\u6709\u4eba");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField5, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label10 ----
        label10.setText("\u68c0\u9a8c\u673a\u5173");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 4f));
        contentPane.add(label10, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField3, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label5 ----
        label5.setText("\u8239\u8236\u767b\u8bb0\u53f7");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
        contentPane.add(label5, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField6, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label11 ----
        label11.setText("\u68c0\u9a8c\u8bc1\u4f7f\u7528\u6709\u6548\u671f\u81f3");
        label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 4f));
        contentPane.add(label11, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField4, new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label6 ----
        label6.setText("\u8239\u8236\u68c0\u9a8c\u7c7b\u578b");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 4f));
        contentPane.add(label6, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField7, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label12 ----
        label12.setText("\u53d1\u8bc1\u65e5\u671f");
        label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 4f));
        contentPane.add(label12, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField9, new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label7 ----
        label7.setText("\u4e0b\u6b21\u68c0\u9a8c\u65f6\u95f4");
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 4f));
        contentPane.add(label7, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField8, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label13 ----
        label13.setText("\u8239\u53ea\u68c0\u9a8c\u60c5\u51b5\u8bb0\u5f55");
        label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 4f));
        contentPane.add(label13, new GridBagConstraints(4, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField10, new GridBagConstraints(5, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(3, 11, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
    private JLabel label5;
    private JTextField textField6;
    private JLabel label11;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField7;
    private JLabel label12;
    private JTextField textField9;
    private JLabel label7;
    private JTextField textField8;
    private JLabel label13;
    private JTextField textField10;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
