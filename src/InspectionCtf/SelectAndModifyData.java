/*
 * Created by JFormDesigner on Fri Nov 16 15:02:19 CST 2018
 */

package InspectionCtf;

import com.SQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import java.sql.SQLException;

/**
 * @author Meredith
 */
public class SelectAndModifyData extends JFrame {

    SQL db = new SQL();

    public SelectAndModifyData() {
        initComponents();
        addCheckBoxItems();
    }

    public void addCheckBoxItems() {
        comboBox1.addItem("船名");
        comboBox1.addItem("船检登记号");
        comboBox1.addItem("检验证编号");
        comboBox1.addItem("下次检验时间");
        comboBox1.addItem("通知检验时间");
    }

    private void button1ActionPerformed(ActionEvent e) {
        /**
         * @description: 按所选择的查询方式打表
         * @param [e]
         * @return void
         * @date: 2018/11/16 15:12
         */
        String colname = comboBox1.getSelectedItem().toString();
        db.sqlLines = "select * from 船只检验证书 where " + colname + "=?";
        db.pre();
        try {
            db.preparedStatement.setString(1, textField1.getText());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSelect();
        db.toTable(db,table1);
    }

    private void button2ActionPerformed(ActionEvent e) {
        /**
         * @description: 由Jtable的数据更新数据库
         * @param [e]
         * @return void
         * @date: 2018/11/16 15:25
         */
        db.sqlLines = "update 船只检验证书 set 船名=?,船检登记号=?,检验证编号=?,船舶所有人=?,船舶登记号=?,船舶检验类型=?,下次检验时间=?,通知时间=?,检验机关=?,检验证使用有效期至=?,发证日期=?,船只检验情况记录=? where 序号=?";
        db.pre();
        try {
            for (int i = 1; i <= 12; i++) {
                db.preparedStatement.setString(i, table1.getValueAt(table1.getSelectedRow(), i).toString());
            }
            db.preparedStatement.setString(13, table1.getValueAt(table1.getSelectedRow(), 0).toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSql();
        //同步修改[各证书有效期]中的值
        db.sqlLines = "update 各证书有效期 set 船名=?,证书有效期至=? where 船名=? and 证书名=?";
        db.pre();
        try {
            db.preparedStatement.setString(1, table1.getValueAt(0, 1).toString());
            db.preparedStatement.setString(2, table1.getValueAt(0, 10).toString());
            db.preparedStatement.setString(3, table1.getValueAt(0, 1).toString());
            db.preparedStatement.setString(4, "船只检验证书");
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
         * @description: 查询[年度检验处理历史表]
         * @param [e]
         * @return void
         * @date: 2018/11/17 10:24
         */
        db.sqlLines = "select * from 年度检验处理历史表 where 船名=? ";
        db.pre();
        try {
            db.preparedStatement.setString(1, textField2.getText());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSelect();
        db.toTable(db, table1);
    }

    private void button4ActionPerformed(ActionEvent e) {
        // 打印
        try {
            table1.print();
        } catch (PrinterException e1) {
            e1.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
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
        button4 = new JButton();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 83, 99, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {28, 47, 45, 34, 41, 59, 35, 36, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- label1 ----
            label1.setText("\u67e5\u8be2\u68c0\u9a8c\u8bc1\u4e66");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
            panel1.add(label1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
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
            label4.setText("       \u8239\u540d");
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
            panel1.add(label4, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(textField2, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- button3 ----
            button3.setText("\u67e5\u8be2\u5386\u53f2\u8868");
            button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 4f));
            button3.addActionListener(e -> button3ActionPerformed(e));
            panel1.add(button3, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 245, 385);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    null, null, null, null, null, null, null, null, null, null, null, null, null
                }
            ));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(240, 0, 995, 200);

        //---- button2 ----
        button2.setText("\u786e\u8ba4\u4fee\u6539");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(870, 320, 98, 40);

        //---- label3 ----
        label3.setText("\u4fee\u6539\u68c0\u9a8c\u8bc1\u4e66");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
        contentPane.add(label3);
        label3.setBounds(865, 275, 115, 42);

        //---- button4 ----
        button4.setText("\u6253\u5370");
        button4.addActionListener(e -> button4ActionPerformed(e));
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(890, 375), button4.getPreferredSize()));

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
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
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
