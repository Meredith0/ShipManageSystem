/*
 * Created by JFormDesigner on Fri Nov 16 18:31:23 CST 2018
 */

package NationalCtf;

import com.SQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author Meredith
 */
public class SelectAndModifyData extends JFrame {

    public static void main(String[] args) {
        new SelectAndModifyData();
    }

    SQL db = new SQL();

    public SelectAndModifyData() {
        initComponents();
        addCheckBoxItems();
    }

    public void addCheckBoxItems() {
        comboBox1.addItem("船只名称");
        comboBox1.addItem("船检登记号");
        comboBox1.addItem("船舶国籍配员证编号");
        comboBox1.addItem("下次换证时间");
        comboBox1.addItem("通知检验时间");
    }

    private void button1ActionPerformed(ActionEvent e) {
        /**
         * @description: 按所选择的的方式进行查询
         * @param [e]
         * @return void
         * @date: 2018/11/16 18:34
         */
        //通过日期查询
        if (comboBox1.getSelectedIndex() == 3 || comboBox1.getSelectedIndex() == 4) {
            db.sqlLines = "select * from 船舶国籍证书 where 下次换证时间=? or 换证通知时间=?";
            db.pre();
            try {
                db.preparedStatement.setString(1, textField1.getText());
                db.preparedStatement.setString(2, textField1.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            db.exeSelect();
            //打表
            db.toTable(db, table1);
        }
        //通过其他3种方式查询
        else {
            db.sqlLines = "select * from 船舶国籍证书 where 船名=? or 船检登记号=? or 证书编号=?";
            db.pre();
            try {
                db.preparedStatement.setString(1, textField1.getText());
                db.preparedStatement.setString(2, textField1.getText());
                db.preparedStatement.setString(3, textField1.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            db.exeSelect();
        }
        //打表
        db.toTable(db, table1);
    }

    private void button2ActionPerformed(ActionEvent e) {
        /**
         * @description: 由Jtable的数据更新数据库
         * @param [e]
         * @return void
         * @date: 2018/11/16 18:47
         */
        db.sqlLines = "update 船舶国籍证书 set 船名=?,船检登记号=?,证书编号=?,船舶所有人=?,船舶登记号=?,下次换证时间=?,换证通知时间=?,证书有效期至=?,签发日期=? where " +
                "序号=?";
        db.pre();
        try {
            for (int i = 1; i <= 9; i++) {
                db.preparedStatement.setString(i, table1.getValueAt(table1.getSelectedRow(), i).toString());
            }
            db.preparedStatement.setString(10, table1.getValueAt(table1.getSelectedRow(), 0).toString());
            System.out.println(table1.getSelectedRow());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSql();
        //同步修改[各证书有效期]中的值
        db.sqlLines = "update 各证书有效期 set 船名=?,证书有效期至=? where 船名=? and 证书名=?";
        db.pre();
        try {
            db.preparedStatement.setString(1, table1.getValueAt(0, 1).toString());
            db.preparedStatement.setString(2, table1.getValueAt(0, 8).toString());
            db.preparedStatement.setString(3, table1.getValueAt(0, 1).toString());
            db.preparedStatement.setString(4, "船舶国籍证书");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSql();
        if (db.effectedLines > 0) {
            JOptionPane.showMessageDialog(null, "修改数据成功", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "修改数据失败", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        /**
         * @description: 查询[国籍证书处理历史表]
         * @param [e]
         * @return void
         * @date: 2018/11/17 10:24
         */
        db.sqlLines = "select * from 国籍证书处理历史表 where 船名=? ";
        db.pre();
        try {
            db.preparedStatement.setString(1, textField2.getText());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSelect();
        db.toTable(db, table1);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this2 = new JFrame();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        button1 = new JButton();
        label4 = new JLabel();
        textField2 = new JTextField();
        button3 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        label3 = new JLabel();
        //======== this2 ========
        {
            this2.setVisible(true);
            Container this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(null);
            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout) panel1.getLayout()).columnWidths = new int[]{0, 83, 99, 0, 0};
                ((GridBagLayout) panel1.getLayout()).rowHeights = new int[]{28, 47, 45, 34, 41, 0, 40, 41, 37, 0};
                ((GridBagLayout) panel1.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) panel1.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                //---- label1 ----
                label1.setText("    \u67e5\u8be2\u56fd\u7c4d\u914d\u5458\u8bc1\u4e66");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
                panel1.add(label1, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                //---- label2 ----
                label2.setText("    \u67e5\u8be2\u65b9\u5f0f");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
                panel1.add(label2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                panel1.add(comboBox1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                panel1.add(textField1, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                //---- button1 ----
                button1.setText("\u786e\u5b9a");
                button1.addActionListener(e -> button1ActionPerformed(e));
                panel1.add(button1, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                //---- label4 ----
                label4.setText("      \u8239\u540d");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
                panel1.add(label4, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                panel1.add(textField2, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                //---- button3 ----
                button3.setText("\u67e5\u8be2\u5386\u53f2\u8868");
                button3.addActionListener(e -> button3ActionPerformed(e));
                panel1.add(button3, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
            }
            this2ContentPane.add(panel1);
            panel1.setBounds(0, 0, 245, 385);
            //======== scrollPane1 ========
            {
                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                        new Object[][]{
                        },
                        new String[]{
                                null, null, null, null, null, null, null, null, null, null, null, null, null
                        }
                ));
                scrollPane1.setViewportView(table1);
            }
            this2ContentPane.add(scrollPane1);
            scrollPane1.setBounds(240, 0, 891, 200);
            //---- button2 ----
            button2.setText("\u786e\u8ba4\u4fee\u6539");
            button2.addActionListener(e -> button2ActionPerformed(e));
            this2ContentPane.add(button2);
            button2.setBounds(870, 320, 98, 40);
            //---- label3 ----
            label3.setText("\u4fee\u6539\u56fd\u7c4d\u914d\u5458\u8bc1\u4e66");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
            this2ContentPane.add(label3);
            label3.setBounds(835, 275, 145, 42);
            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < this2ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = this2ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = this2ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                this2ContentPane.setMinimumSize(preferredSize);
                this2ContentPane.setPreferredSize(preferredSize);
            }
            this2.pack();
            this2.setLocationRelativeTo(this2.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame this2;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label4;
    private JTextField textField2;
    private JButton button3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
