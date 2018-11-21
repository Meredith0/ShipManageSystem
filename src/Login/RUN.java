package Login;

import javax.swing.*;

/**
 * @Author: Meredith
 * @CreateDate: 2018-11-21 15:53
 * @Project: ShipManageSystem
 * @Package: Login
 * @Description: 主函数入口
 **/
public class RUN
{
    public static void main(String[] args)
    {
        //换个皮肤
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        try
        {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }

        //登陆入口
        new LoginPanel();
    }
}
