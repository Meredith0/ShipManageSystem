package System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @Author: Meredith
 * @CreateDate: 2018-11-06 22:03
 * @Project: ShipManageSystem
 * @Package: System
 * @Description: 删除用户
 **/
public class DeleteUser_ChangePasswd extends SystemGUI
{
    private JTextField userText = new JTextField();
    private JPasswordField passwordText = new JPasswordField();

    JLabel adduserLable = new JLabel("删除用户");
    JLabel userLable = new JLabel("用户名");
    JLabel passwordLabel = new JLabel("密码");
    JButton deleteButton = new JButton("删除用户");
    JButton updatePasswdButton = new JButton("修改密码");

    DeleteUser_ChangePasswd(JPanel panel)
    {
        Font lable_font = new Font("宋体", Font.BOLD, 20);
        adduserLable.setFont(lable_font);
        adduserLable.setBounds(400, 80, 100, 90);
        panel.add(adduserLable);

        Font font1 = new Font("宋体", Font.BOLD, 18);
        userLable.setBounds(500, 50, 80, 80);
        userLable.setFont(font1);
        panel.add(userLable);

        userText.setBounds(580, 80, 130, 20);
        panel.add(userText);

        passwordLabel.setBounds(500, 80, 80, 80);
        passwordLabel.setFont(font1);
        panel.add(passwordLabel);

        passwordText.setBounds(580, 110, 130, 20);
        panel.add(passwordText);

        deleteButton.setBounds(450, 200, 120, 40);
        deleteButton.setFont(font1);
        panel.add(deleteButton);
        deleteButton.addActionListener(new DeleteUserHandler());

        updatePasswdButton.setBounds(600, 200, 120, 40);
        updatePasswdButton.setFont(font1);
        panel.add(updatePasswdButton);
        updatePasswdButton.addActionListener(new UpdatePasswdHandler());

    }

    class UpdatePasswdHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String ID = userText.getText();
            String password = new String(passwordText.getPassword());

            //SQL语句
            db.sqlLines = "update 系统用户表 set 密码=? where 用户ID=?";
            db.pre();
            try
            {
                db.preparedStatement.setString(1,password);
                db.preparedStatement.setString(2,ID);
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }

            db.exeSql();//执行SQL语句
            if (db.effectedLines >0)
            {
                JOptionPane.showMessageDialog(null, "修改密码成功", "", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "修改密码失败", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    class DeleteUserHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String ID = userText.getText();
            String password = new String(passwordText.getPassword());

            //SQL语句
            db.sqlLines = "delete from 系统用户表 where 用户ID=? and 密码=?";
            db.pre();
            try
            {
                db.preparedStatement.setString(1, ID);
                db.preparedStatement.setString(2,password);
            } catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            db.exeSql();//执行SQL语句

            if (db.effectedLines >0)
            {
                JOptionPane.showMessageDialog(null, "删除用户成功", "", JOptionPane.INFORMATION_MESSAGE);
                sA.refresh();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "删除用户失败", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
