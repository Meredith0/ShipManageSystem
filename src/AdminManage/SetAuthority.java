package AdminManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

/**
 * @Author: Meredith
 * @CreateDate: 2018-11-08 09:20
 * @Project: ShipManageSystem
 * @Package: AdminManage
 * @Description: 设置权限
 **/
public class SetAuthority extends SystemGUI {

    public String rs[] = new String[100];
    private JTextField userText = new JTextField();
    private JLabel userLable = new JLabel("用户名");
    private JButton confirmButton = new JButton("确定");
    private JLabel text = new JLabel("用户权限管理");
    private JCheckBox charge = new JCheckBox("收费权");
    private JCheckBox supervisory = new JCheckBox("监督权");
    private JCheckBox admini = new JCheckBox("管理员");
    private JComboBox list0 = new JComboBox();

    public void setAuthority(JPanel panel) {
        Font text1_font = new Font("宋体", Font.BOLD, 28);
        text.setFont(text1_font);
        panel.setLayout(null);
        text.setBounds(300, 300, 180, 80);
        panel.add(text);
        Font font1 = new Font("宋体", Font.BOLD, 18);
        userLable.setFont(font1);
        userLable.setBounds(60, 370, 80, 30);
        panel.add(userLable);
        //初始化下拉列表
        db.sqlLines = "Select 用户ID from 系统用户表";
        db.pre();
        db.exeSelect();
        for (int i = 0; i < db.col; i++) {
            if (db.result[1][i]!=null)
            list0.addItem(db.result[1][i]);
        }

        list0.setBounds(130, 370, 130, 30);
        panel.add(list0);
        list0.setSelectedIndex(-1);
        list0.setVisible(true);
        list0.addItemListener(new listHandler());
        charge.setBounds(300, 370, 70, 30);
        panel.add(charge);
        supervisory.setBounds(400, 370, 70, 30);
        panel.add(supervisory);
        admini.setBounds(500, 370, 70, 30);
        panel.add(admini);
        confirmButton.setFont(font1);
        confirmButton.setBounds(600, 370, 100, 30);
        panel.add(confirmButton);
        confirmButton.addActionListener(new setAuthorityHandler());
    }

    class listHandler implements ItemListener {

        /**
         * @param
         * @return
         * @description: 通过JCheckBox显示权限
         * @date: 2018/11/15 20:32 进行了一次修改
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                charge.setSelected(false);
                supervisory.setSelected(false);
                admini.setSelected(false);
                String ID = null;
                int t;
                t = list0.getSelectedIndex();
                ID = list0.getItemAt(t).toString();
                db.sqlLines = "select 权限 from 系统用户表 where 用户ID=?";
                db.pre();
                try {
                    db.preparedStatement.setString(1, ID);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                db.exeSelect();//执行SQL语句
                rs[1] = db.result[1][1];
                if ("1".equals(db.result[1][1])) {
                    charge.setSelected(true);
                }
                if ("2".equals(db.result[1][1])) {
                    supervisory.setSelected(true);
                }
                if ("3".equals(db.result[1][1])) {
                    charge.setSelected(true);
                    supervisory.setSelected(true);
                }
                if ("4".equals(db.result[1][1])) {
                    admini.setSelected(true);
                }
                if ("5".equals(db.result[1][1])) {
                    charge.setSelected(true);
                    supervisory.setSelected(true);
                }
                if ("6".equals(db.result[1][1])) {
                    supervisory.setSelected(true);
                    admini.setSelected(true);
                }
                if ("7".equals(db.result[1][1])) {
                    charge.setSelected(true);
                    supervisory.setSelected(true);
                    admini.setSelected(true);
                }
            }
        }
    }

    public void refresh() {
        /**
         * @description: 刷新下拉列表
         * @param []
         * @return void
         * @date: 2018/11/15 20:33
         */
        db.sqlLines = "Select 用户ID from 系统用户表";
        db.pre();
        db.exeSelect();
        list0.removeAllItems();
        for (int i = 0; i < db.col; i++) {
            list0.addItem(db.result[1][i]);
        }
        list0.setSelectedIndex(-1);//设默认的选择为空
    }

    class setAuthorityHandler implements ActionListener {

        /**
         * @param
         * @return
         * @description: 修改权限
         * @date: 2018/11/15 20:34
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String ID = list0.getSelectedItem().toString();
            boolean isCharge = charge.isSelected();//1
            boolean isSup = supervisory.isSelected();//2
            boolean isAdmini = admini.isSelected();//4
            int Autho = 0;
            if (isCharge == true) {
                Autho += 1;
            }
            if (isSup == true) {
                Autho += 2;
            }
            if (isAdmini == true) {
                Autho += 4;
            }
            String strAutho = Autho + "";
            //SQL语句
            db.sqlLines = "update 系统用户表 set 权限=? where 用户ID=?";
            db.pre();
            try {
                db.preparedStatement.setString(1, strAutho);
                db.preparedStatement.setString(2, ID);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            db.exeSql();//执行SQL语句
            if (db.effectedLines > 0) {
                JOptionPane.showMessageDialog(null, "更新权限成功", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "更新权限失败", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
