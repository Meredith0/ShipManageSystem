package MySystem;

import com.SQL;

import javax.swing.*;

/**
 * @Author: Meredith
 * @Date: 2018-10-23 09:57
 * @Program: ShipManageSystem
 * @Description: 系统管理模块主界面
 **/
public class SystemGUI
{
    SQL db = new SQL();
    static JFrame Frame2 = new JFrame("船只资料管理系统");
    static JPanel systemPanel = new JPanel();
    static JPanel sysManagePanel = new JPanel();
    static SetAuthority sA=new SetAuthority();
    public static void run()
    {
        // 创建 JFrame 实例

        Frame2.setSize(800, 600);
        Frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //登陆层容器
        systemPanel.setSize(480,320);
        new AddUser(sysManagePanel);
        new DeleteUser_ChangePasswd(sysManagePanel);

        sA.setAuthority(sysManagePanel);

        Frame2.add(sysManagePanel);
        Frame2.setLocationRelativeTo(null);
        Frame2.setVisible(true);
    }
}
