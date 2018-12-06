/*
 * Created by JFormDesigner on Wed Nov 21 14:24:00 CST 2018
 */

package Login;

import DataQueryAndReportProcessing.Panel;
import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static Login.LoginPanel.*;

/**
 * @author Meredith
 */
public class MainPanel extends JFrame {

    public static void main(String[] args) {
        new MainPanel();
    }

    public MainPanel() {
        initComponents();
        setWelcomeInfo();
        setWarning();
        setAdmini();
    }

    private void button2ActionPerformed(ActionEvent e) {
        // 系统管理模块
        MySystem.SystemGUI.run();
    }

    private void button8ActionPerformed(ActionEvent e) {
        // 资料查询模块
        DataQueryAndReportProcessing.Panel frame = new Panel();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.dispose();
    }

    private void button3ActionPerformed(ActionEvent e) {
        // 船只基本资料管理模块
        this.dispose();
        new BasicData.Panel();
    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO （五）、船只营运证书资料管理模块
    }

    private void button4ActionPerformed(ActionEvent e) {
        //  （六）、船只检验证书资料管理模块
        this.dispose();
        new InspectionCtf.Panel();
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO （七）、船只安检证书资料管理模块
    }

    private void button7ActionPerformed(ActionEvent e) {
        // （八）、船只国籍配员证书资料管理模块
        this.dispose();
        new NationalCtf.Panel();
    }

    private void button9ActionPerformed(ActionEvent e) {
        // TODO 九）、船只缴纳航道费情况管理模块
    }

    private void button10ActionPerformed(ActionEvent e) {
        // 船只缴纳水运费情况管理模块
        this.dispose();
        new Waterage.Panel();
    }

    public void setAdmini() {
        /**
         * @description: 设置管理员按钮是否可用
         * @param []
         * @return void
         * @date: 2018/11/21 18:37
         */
        int au = Integer.parseInt(Autho);
        if (au >= 4) {
            button2.setEnabled(true);
        }
    }

    public void setWelcomeInfo() {
        /**
         * @description: 设置欢迎信息
         * @param []
         * @return void
         * @date: 2018/11/21 16:02
         */
        textPane3.setText(UserName);
        textPane4.setText(UserID);
        String MyAutho = "无权限";
        if ("0".equals(Autho)) {
            MyAutho = "无权限";
        }
        if ("1".equals(Autho)) {
            MyAutho = "收费权";
        }
        if ("2".equals(Autho)) {
            MyAutho = "监督权";
        }
        if ("3".equals(Autho)) {
            MyAutho = "收费权, 监督权";
        }
        if ("4".equals(Autho)) {
            MyAutho = "管理员";
        }
        if ("5".equals(Autho)) {
            MyAutho = "收费权, 管理员";
        }
        if ("6".equals(Autho)) {
            MyAutho = "监督权, 管理员";
        }
        if ("7".equals(Autho)) {
            MyAutho = "收费权, 监督权, 管理员";
        }
        textPane2.setText(MyAutho);
    }

    public void setWarning() {
        /**
         * @description: 证书过期警告
         * @param []
         * @return void
         * @date: 2018/11/21 16:04
         */
        SQL db = new SQL();
        //select那些未过期的证书
        db.sqlLines = "select 证书有效期至,船名,证书名 from 各证书有效期";
        db.pre();
        db.exeSelect();
        Calendar cal = Calendar.getInstance();
        //获取当前日期 并加一个月
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar nowCal = Calendar.getInstance();
        nowCal.getTime();
        String now = sdf.format(nowCal.getTime());
        Date date = null;
        String text = "         Warning\n";
        {
            for (int j = 1; j < db.row; j++)//遍历行
            {
                //获取数据库日期
                try {
                    date = sdf.parse(db.result[1][j]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                cal.setTime(date);
                String dbDate = sdf.format(cal.getTime());
                //若当前日期小于数据库日期
                if (now.compareTo(dbDate) <= 0) {
                    //且当前日期+1个月大于数据库日期
                    nowCal.add(Calendar.MONTH, +1);
                    String now1 = sdf.format(nowCal.getTime());
                    if (now1.compareTo(dbDate) >= 0) {
                        text += "船只 [" + db.result[2][j] + "] 的证书 [" + db.result[3][j] + "] 将于一个月内过期\n";
                    }
                }
            }
        }
        textPane1.setText(text);
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        /**
         * @description: 修改密码
         * @param [e]
         * @return void
         * @date: 2018/11/21 15:18
         */
        new ChangePasswd();
        this.dispose();
    }

    private void menuItem2ActionPerformed(ActionEvent e) {
        /**
         * @description: 退出系统
         * @param [e]
         * @return void
         * @date: 2018/11/21 18:26
         */
        System.exit(0);
    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        /**
         * @description: 重新登陆
         * @param [e]
         * @return void
         * @date: 2018/11/21 18:26
         */
        this.dispose();
        new LoginPanel();
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        /**
         * @description: 关于我们
         * @param [e]
         * @return void
         * @date: 2018/11/21 18:27
         */
        new AboutUs();
    }

    private void menuItem5ActionPerformed(ActionEvent e) {
        /**
         * @description: 配置IP
         * @param [e]
         * @return void
         * @date: 2018/11/21 18:27
         */
        new Config();
    }

    private void thisWindowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(this,
                "你确定要退出吗 ?", "",
                JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION)
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        else if (result == JOptionPane.NO_OPTION)
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        label2 = new JLabel();
        textPane3 = new JTextPane();
        label3 = new JLabel();
        textPane4 = new JTextPane();
        label4 = new JLabel();
        textPane2 = new JTextPane();
        label1 = new JLabel();
        button2 = new JButton();
        button8 = new JButton();
        button3 = new JButton();
        button5 = new JButton();
        button4 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button9 = new JButton();
        button10 = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        //======== this ========
        setVisible(true);
        setTitle("\u8239\u53ea\u8d44\u6599\u7ba1\u7406\u7cfb\u7edf");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{43, 0, 55, 120, 57, 0, 0, 55, 55, 15, 15, 30, 55, 55, 35, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0, 25, 79, 0, 35, 35, 0, 35, 35, 0, 35, 35, 0, 23, 20, 0, 38, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        //======== menuBar1 ========
        {
            //======== menu1 ========
            {
                menu1.setText("\u6587\u4ef6");
                //---- menuItem1 ----
                menuItem1.setText("\u4fee\u6539\u5bc6\u7801");
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                menu1.add(menuItem1);
                //---- menuItem2 ----
                menuItem2.setText("\u9000\u51fa\u7cfb\u7edf");
                menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                menu1.add(menuItem2);
                //---- menuItem3 ----
                menuItem3.setText("\u91cd\u65b0\u767b\u9646");
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);
            //======== menu3 ========
            {
                menu3.setText("\u7f16\u8f91");
                //---- menuItem5 ----
                menuItem5.setText("\u914d\u7f6e\u670d\u52a1\u5668\u4fe1\u606f");
                menuItem5.addActionListener(e -> menuItem5ActionPerformed(e));
                menu3.add(menuItem5);
            }
            menuBar1.add(menu3);
            //======== menu2 ========
            {
                menu2.setText("\u5e2e\u52a9");
                //---- menuItem4 ----
                menuItem4.setText("\u5173\u4e8e");
                menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);
        //---- label2 ----
        label2.setText("\u6b22\u8fce\u60a8");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 1f));
        contentPane.add(label2, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- textPane3 ----
        textPane3.setEditable(false);
        contentPane.add(textPane3, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- label3 ----
        label3.setText("\u5de5\u4f5c\u7f16\u53f7");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 1f));
        contentPane.add(label3, new GridBagConstraints(6, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- textPane4 ----
        textPane4.setEditable(false);
        contentPane.add(textPane4, new GridBagConstraints(8, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- label4 ----
        label4.setText("\u6743\u9650");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 1f));
        contentPane.add(label4, new GridBagConstraints(10, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- textPane2 ----
        textPane2.setEditable(false);
        contentPane.add(textPane2, new GridBagConstraints(12, 2, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        //---- label1 ----
        label1.setText("\u8239\u53ea\u8d44\u6599\u7ba1\u7406\u7cfb\u7edf");
        label1.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 32));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBackground(new Color(8, 93, 149));
        contentPane.add(label1, new GridBagConstraints(0, 3, 15, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        //---- button2 ----
        button2.setText("\u7cfb\u7edf\u7ba1\u7406(\u7ba1\u7406\u5458)");
        button2.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 17));
        button2.setEnabled(false);
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(2, 5, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- button8 ----
        button8.setText("\u8d44\u6599\u67e5\u8be2");
        button8.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 17));
        button8.addActionListener(e -> button8ActionPerformed(e));
        contentPane.add(button8, new GridBagConstraints(7, 5, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- button3 ----
        button3.setText("\u57fa\u672c\u8d44\u6599\u7ba1\u7406");
        button3.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 17));
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3, new GridBagConstraints(12, 5, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- button5 ----
        button5.setText("\u8425\u8fd0\u8bc1\u4e66\u7ba1\u7406");
        button5.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 17));
        button5.addActionListener(e -> button5ActionPerformed(e));
        contentPane.add(button5, new GridBagConstraints(2, 8, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- button4 ----
        button4.setText("\u68c0\u9a8c\u8bc1\u4e66\u7ba1\u7406");
        button4.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 17));
        button4.addActionListener(e -> button4ActionPerformed(e));
        contentPane.add(button4, new GridBagConstraints(7, 8, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- button6 ----
        button6.setText("\u5b89\u68c0\u8bc1\u4e66\u7ba1\u7406");
        button6.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 17));
        button6.addActionListener(e -> button6ActionPerformed(e));
        contentPane.add(button6, new GridBagConstraints(12, 8, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- button7 ----
        button7.setText("\u56fd\u7c4d\u914d\u5458\u8bc1\u4e66\u7ba1\u7406");
        button7.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 17));
        button7.addActionListener(e -> button7ActionPerformed(e));
        contentPane.add(button7, new GridBagConstraints(2, 11, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- button9 ----
        button9.setText("\u7f34\u7eb3\u822a\u9053\u8d39\u60c5\u51b5\u7ba1\u7406");
        button9.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 17));
        button9.addActionListener(e -> button9ActionPerformed(e));
        contentPane.add(button9, new GridBagConstraints(7, 11, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //---- button10 ----
        button10.setText("\u7f34\u7eb3\u6c34\u8fd0\u8d39\u60c5\u51b5\u7ba1\u7406");
        button10.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 16));
        button10.addActionListener(e -> button10ActionPerformed(e));
        contentPane.add(button10, new GridBagConstraints(12, 11, 2, 2, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
        //======== scrollPane1 ========
        {
            //---- textPane1 ----
            textPane1.setEditable(false);
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1, new GridBagConstraints(12, 15, 3, 3, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JLabel label2;
    private JTextPane textPane3;
    private JLabel label3;
    private JTextPane textPane4;
    private JLabel label4;
    private JTextPane textPane2;
    private JLabel label1;
    private JButton button2;
    private JButton button8;
    private JButton button3;
    private JButton button5;
    private JButton button4;
    private JButton button6;
    private JButton button7;
    private JButton button9;
    private JButton button10;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
