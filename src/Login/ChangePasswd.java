/*
 * Created by JFormDesigner on Wed Nov 21 15:21:24 CST 2018
 */

package Login;

import com.MD5;
import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author Meredith
 */
public class ChangePasswd extends LoginPanel
{
    public ChangePasswd()
    {
        initComponents();
    }

    private void button2ActionPerformed(ActionEvent e)
    {
        SQL db = new SQL();
        /**
         * @description: 修改密码
         * @param [e]
         * @return void
         * @date: 2018/11/21 15:26
         */
        //判断两次密码是否相同
        if (!passwordField2.getText().equals(passwordField3.getText()))
        {
            JOptionPane.showMessageDialog(null, "两次密码不相同,请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
        }
        //相同则修改密码
        else
        {
            //加密
            MD5 md5 = new MD5();
            String newPasswd = md5.MD5WithoutSalt(passwordField3.getText());
            String oldPasswd = md5.MD5WithoutSalt(passwordField1.getText());

            System.out.println(newPasswd + "    " + oldPasswd);
            db.sqlLines = "update 系统用户表 set 密码=? where 密码=? and 用户ID=?";
            db.pre();
            try
            {
                db.preparedStatement.setString(1, newPasswd);
                db.preparedStatement.setString(2, oldPasswd);
                db.preparedStatement.setString(3, UserID);
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            db.exeSql();
            if (db.effectedLines > 0)
            {
                JOptionPane.showMessageDialog(null, "密码修改成功", "成功", JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            } else
            {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
                //记录新密码
                Passwd = newPasswd;
            }
        }

    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label5 = new JLabel();
        passwordField1 = new JPasswordField();
        label2 = new JLabel();
        passwordField2 = new JPasswordField();
        label4 = new JLabel();
        passwordField3 = new JPasswordField();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{75, 0, 0, 60, 94, 23, 20, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{19, 37, 22, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("\u4fee\u6539\u5bc6\u7801");
        label1.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 21));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, new GridBagConstraints(0, 1, 7, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

        //---- label5 ----
        label5.setText("\u539f\u5bc6\u7801");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
        contentPane.add(label5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(passwordField1, new GridBagConstraints(3, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- label2 ----
        label2.setText("\u65b0\u5bc6\u7801");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(passwordField2, new GridBagConstraints(3, 4, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- label4 ----
        label4.setText("\u786e\u8ba4\u5bc6\u7801");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(passwordField3, new GridBagConstraints(3, 5, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- button2 ----
        button2.setText("\u786e\u5b9a");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 4f));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label5;
    private JPasswordField passwordField1;
    private JLabel label2;
    private JPasswordField passwordField2;
    private JLabel label4;
    private JPasswordField passwordField3;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
