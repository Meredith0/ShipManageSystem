import Login.LoginPanel;

import javax.swing.*;

/**
 * @Author: Meredith
 * @CreateDate: 2018-11-21 15:53
 * @Project: ShipManageSystem
 * @Package: src
 * @Description: 主函数入口
 **/
public class RUN
{
    public static void main(String[] args)
    {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try
        {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        //登陆入口
        new LoginPanel();
    }
}
