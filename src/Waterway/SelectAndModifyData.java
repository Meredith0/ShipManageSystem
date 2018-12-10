/*
 * Created by JFormDesigner on Sat Nov 17 10:45:00 CST 2018
 */

package Waterway;

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

    public static void main(String[] args)
    {
        new SelectAndModifyData();
    }
    SQL db = new SQL();

    public SelectAndModifyData() {
        initComponents();
        addCheckBoxItems();
    }

    public void addCheckBoxItems() {
        comboBox1.addItem("船只名称");
        comboBox1.addItem("填表时间");
    }

    private void button1ActionPerformed(ActionEvent e) {
        /**
         * @description: 按所选择的的方式进行查询
         * @param [e]
         * @return void
         * @date: 2018/11/17 10:49
         */
        //按船名查询
        if (comboBox1.getSelectedIndex() == 0) {
            db.sqlLines = "select * from 航道费纪录表 where 船名=?";
            db.pre();
            try {
                db.preparedStatement.setString(1, textField1.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            db.exeSelect();
            db.toTable(db, table1);
        }
        //按填表日期查询
        else if (comboBox1.getSelectedIndex() == 1) {
            db.sqlLines = "select * from 航道费纪录表 where 填表日期=?";
            db.pre();
            try {
                db.preparedStatement.setString(1, textField1.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            db.exeSelect();
            db.toTable(db, table1);
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        /**
         * @description: 由Jtable的数据更新数据库
         * @param [e]
         * @return void
         * @date: 2018/11/17 17:28
         */
        db.sqlLines = "update 航道费纪录表 set 船名=?,船检登记号=?,航道费用=?,填表日期=?,航道费合计=?,签注记录=? where 序号=?";
        db.pre();
        try {
            for (int i = 1; i <= 6; i++) {
                db.preparedStatement.setString(i, table1.getValueAt(table1.getSelectedRow(), i).toString());
            }
            db.preparedStatement.setString(7, table1.getValueAt(table1.getSelectedRow(), 0).toString());
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
        // 打印
        try {
            table1.print();
        } catch (PrinterException e1) {
            e1.printStackTrace();
        }
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
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        label3 = new JLabel();
        button3 = new JButton();

        //======== this2 ========
        {
            this2.setVisible(true);
            Container this2ContentPane = this2.getContentPane();
            this2ContentPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 83, 99, 0, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {28, 47, 45, 34, 41, 0, 40, 41, 37, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("    \u67e5\u8be2\u822a\u9053\u8d39\u7f34\u7eb3\u8bb0\u5f55");
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
            }
            this2ContentPane.add(panel1);
            panel1.setBounds(0, 0, 245, 385);

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        null, null, null, null, null, null
                    }
                ));
                scrollPane1.setViewportView(table1);
            }
            this2ContentPane.add(scrollPane1);
            scrollPane1.setBounds(250, 0, 490, 200);

            //---- button2 ----
            button2.setText("\u786e\u8ba4\u4fee\u6539");
            button2.addActionListener(e -> button2ActionPerformed(e));
            this2ContentPane.add(button2);
            button2.setBounds(595, 290, 98, 40);

            //---- label3 ----
            label3.setText("\u4fee\u6539\u822a\u9053\u8d39\u7f34\u7eb3\u8bb0\u5f55");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
            this2ContentPane.add(label3);
            label3.setBounds(535, 245, 175, 42);

            //---- button3 ----
            button3.setText("\u6253\u5370");
            button3.addActionListener(e -> button3ActionPerformed(e));
            this2ContentPane.add(button3);
            button3.setBounds(new Rectangle(new Point(615, 340), button3.getPreferredSize()));

            this2ContentPane.setPreferredSize(new Dimension(755, 465));
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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JLabel label3;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
