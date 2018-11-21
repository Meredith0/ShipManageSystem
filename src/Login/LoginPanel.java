/*
 * Created by JFormDesigner on Wed Nov 21 15:38:12 CST 2018
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
public class LoginPanel extends JFrame
{
    public static String UserID;//记录用户名
    public static String UserName;//记录姓名
    public static String Autho;//记录权限

    SQL db = new SQL();

    public LoginPanel()
    {
        initComponents();
        addCheckBoxItems();
    }

    public void addCheckBoxItems()
    {
        comboBox1.addItem("用户ID");
        comboBox1.addItem("用户姓名");
    }

    private void button2ActionPerformed(ActionEvent e)
    {
        /**
         * @description: 登陆按钮
         * @param [e]
         * @return void
         * @date: 2018/11/21 15:46
         */
        if (comboBox1.getSelectedIndex() == 0)
        {
            db.sqlLines = "select 用户ID, 密码, 员工姓名,权限 from 系统用户表 where 用户ID=? and 密码=?";
            db.pre();
            MD5 md5 = new MD5();
            String Passwd = md5.MD5WithoutSalt(passwordField1.getText());
            try
            {
                db.preparedStatement.setString(1, textField1.getText());
                db.preparedStatement.setString(2, Passwd);
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            db.exeSelect();
            if (db.result[1][1] == null)
            {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "密码错误", JOptionPane.ERROR_MESSAGE);
            } else
            {
                UserID = db.result[1][1];
                UserName = db.result[3][1];
                Autho = db.result[4][1];
                this.dispose();
                new MainPanel();
            }
        } else if ((comboBox1.getSelectedIndex() == 1))
        {
            db.sqlLines = "select 用户ID, 密码, 员工姓名,权限 from 系统用户表 where 员工姓名=? and 密码=?";
            db.pre();
            MD5 md5 = new MD5();
            String Passwd = md5.MD5WithoutSalt(passwordField1.getText());
            try
            {
                db.preparedStatement.setString(1, textField1.getText());
                db.preparedStatement.setString(2, Passwd);
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            db.exeSelect();
            if (db.result[1][1] == null)
            {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "密码错误", JOptionPane.ERROR_MESSAGE);
            } else
            {
                UserID = db.result[1][1];
                UserName = db.result[3][1];
                Autho = db.result[4][1];
                new MainPanel();
                this.dispose();
            }
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        /**
         * @description:  注册
         * @param [e]
         * @return void
         * @date: 2018/11/21 19:38
         */
        this.dispose();
        new SignIn();
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {75, 0, 0, 49, 85, 23, 20, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {19, 37, 22, 0, 0, 37, 0, 46, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label2 ----
        label2.setText("\u6b22\u8fce\u4f7f\u7528\u8239\u53ea\u8d44\u6599\u7ba1\u7406\u7cfb\u7edf");
        label2.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 21));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label2, new GridBagConstraints(0, 1, 7, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        contentPane.add(comboBox1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField1, new GridBagConstraints(3, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label3 ----
        label3.setText("  \u5bc6\u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(passwordField1, new GridBagConstraints(3, 4, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button1 ----
        button1.setText("\u6ce8\u518c");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 4f));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button2 ----
        button2.setText("\u767b\u9646");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 4f));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
