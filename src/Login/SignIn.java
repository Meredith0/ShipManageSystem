/*
 * Created by JFormDesigner on Wed Nov 21 19:39:23 CST 2018
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
public class SignIn extends JFrame
{
    SQL db = new SQL();

    public SignIn()
    {
        initComponents();
    }

    private void button2ActionPerformed(ActionEvent e)
    {
        /**
         * @description: 增加用户
         * @param [e]
         * @return void
         * @date: 2018/11/21 19:41
         */
        if (!passwordField1.getText().equals(passwordField2.getText()))
        {
            JOptionPane.showMessageDialog(null, "两次密码不相同,请重新输入", "错误", JOptionPane.ERROR_MESSAGE);
        }
        if (textField3.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "注册失败", "错误", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String password = new String(passwordField1.getPassword());
            //MD5加密
            MD5 md5 = new MD5();
            password = md5.MD5WithoutSalt(password);

            db.sqlLines = "insert into 系统用户表(用户ID,密码,权限,员工姓名,联系电话) values(?,?,?,?,?)";
            db.pre();
            try
            {
                db.preparedStatement.setString(1, textField3.getText());
                db.preparedStatement.setString(2, password);
                db.preparedStatement.setString(3, "0");//默认权限为0
                db.preparedStatement.setString(4, textField1.getText());
                db.preparedStatement.setString(5, textField2.getText());
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            db.exeSql();//执行SQL语句
            if (db.effectedLines > 0)
            {
                JOptionPane.showMessageDialog(null, "注册成功", "", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new LoginPanel();
            } else
            {
                JOptionPane.showMessageDialog(null, "注册失败", "", JOptionPane.ERROR_MESSAGE);
                this.dispose();
                new LoginPanel();
            }

        }

    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label5 = new JLabel();
        textField3 = new JTextField();
        label3 = new JLabel();
        textField1 = new JTextField();
        label6 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        label4 = new JLabel();
        passwordField2 = new JPasswordField();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {75, 0, 0, 60, 94, 23, 20, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {19, 37, 22, 0, 0, 0, 0, 0, 45, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("\u6ce8\u518c\u8d26\u6237");
        label1.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 21));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, new GridBagConstraints(0, 1, 7, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- label5 ----
        label5.setText("\u7528\u6237ID");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
        contentPane.add(label5, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField3, new GridBagConstraints(3, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label3 ----
        label3.setText("\u59d3\u540d");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField1, new GridBagConstraints(3, 4, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label6 ----
        label6.setText("\u8054\u7cfb\u7535\u8bdd");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 4f));
        contentPane.add(label6, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(textField2, new GridBagConstraints(3, 5, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(passwordField1, new GridBagConstraints(3, 6, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label4 ----
        label4.setText("\u786e\u8ba4\u5bc6\u7801");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        contentPane.add(passwordField2, new GridBagConstraints(3, 7, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button2 ----
        button2.setText("\u786e\u5b9a");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 4f));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(3, 9, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label5;
    private JTextField textField3;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label6;
    private JTextField textField2;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JLabel label4;
    private JPasswordField passwordField2;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
