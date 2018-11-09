package Login;

import javax.swing.*;

/**
 * @Author: Meredith
 * @Date: 2018-10-14 18:42
 * @Program: ShipManageSystem
 * @Description: GUI的调用类
 **/
public class LoginGUI
{
    static JFrame Frame1 = new JFrame("船只资料管理系统");
    static JPanel loginPanel = new JPanel();

    public static void run()
    {

         // 创建 JFrame 实例
        //JFrame Frame = new JFrame("船只资料管理系统");//最大的窗口

        Frame1.setSize(400, 300);
        Frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //登陆层容器
        Login L = new Login();
        L.init(loginPanel);
        Frame1.add(loginPanel);

        Frame1.setLocationRelativeTo(null);
        Frame1.setVisible(true);

    }

}
