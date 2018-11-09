package BasicData;

import com.SQL;

import javax.swing.*;

/**
 * @Author: Meredith
 * @CreateDate: 2018-11-09 22:05
 * @Project: ShipManageSystem
 * @Package: BasicData
 * @Description: 用于测试
 **/
public class BasicDateGUI
{
    SQL db = new SQL();
    static JFrame Frame4 = new JFrame("船只资料管理系统");
    static JPanel addPanel = new JPanel();
    public static void main(String[] args)
    {
        Frame4.setLocation(500,250);
        Frame4.setSize(800, 600);
        Frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AddBasicInfo A = new AddBasicInfo();
        A.initComponents(addPanel);
        Frame4.add(addPanel);

        Frame4.setVisible(true);
    }
}
