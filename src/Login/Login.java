package Login;

import com.MD5;
import com.SQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @Author: Meredith
 * @Date: 2018-10-09 10:54
 * @Program: ShipManageSystem
 * @Description: 登陆界面
 **/
public class Login extends LoginGUI
{
    private JTextField userText = new JTextField();
    private JPasswordField passwordText = new JPasswordField();

    JLabel userLabel = new JLabel("用户名:");
    JLabel passwordLabel = new JLabel("密码:");
    JButton loginButton = new JButton("登陆");
    JButton signinButton = new JButton("注册");

    public void init(JPanel loginPanel)
    {
        /**
         * @description:登陆界面初始化
         * @param [loginPanel]
         * @return void
         * @date: 2018/10/9 11:41
         */
        loginPanel.setLayout(null);

        // 创建 JLabel
        //JLabel userLabel = new JLabel("用户名:");
        userLabel.setBounds(40, 20, 80, 25);
        loginPanel.add(userLabel);
        // JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        loginPanel.add(userText);

        // 输入密码的文本域
        //JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(40, 50, 80, 25);
        loginPanel.add(passwordLabel);
        passwordText.setBounds(100, 50, 165, 25);
        loginPanel.add(passwordText);
        // 创建登录按钮
        //JButton loginButton = new JButton("登陆");
        loginButton.setBounds(190, 80, 70, 25);
        loginPanel.add(loginButton);
        loginButton.addActionListener(new loginHandler());

        //创建注册按钮
        //JButton signinButton = new JButton("注册");
        signinButton.setBounds(100, 80, 70, 25);
        loginPanel.add(signinButton);
        signinButton.addActionListener(new signinHandler());
    }

    class loginHandler extends Login implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SQL login = new SQL();
            String ID = userText.getText();
            String password = new String(passwordText.getPassword());
            MD5 md5 = new MD5();
            password = md5.MD5WithoutSalt(password);
            login.sqlLines = "select 用户ID,密码 from 系统用户表 where 用户ID=?"+" and 密码=?";
            login.pre();
            try
            {
                login.preparedStatement.setString(1, ID);
                login.preparedStatement.setString(2, password);
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            login.exeSelect();//执行SQL语句
            if (login.result[1][1] == null)
            {
                JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "密码错误", JOptionPane.ERROR_MESSAGE);
            } else
            {
                JOptionPane.showMessageDialog(null, "登陆成功", "登陆成功", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class signinHandler extends Login implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            loginPanel.setVisible(false);
            JPanel sigin = new JPanel();
            Frame1.add(sigin);

        }

    }

    private void place_signin(JPanel signinPanel)
    {

    }
}



