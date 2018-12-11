/*
 * Created by JFormDesigner on Fri Nov 16 15:49:25 CST 2018
 */

package OperationCtf;

import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * @author Meredith
 */
public class AddData extends JFrame {

    SQL db = new SQL();

    public AddData() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        /**
         * @description: 录入数据到表 [船舶国籍证书]
         * @param [e]
         * @return void
         * @date: 2018/11/16 16:46
         */
        //判断船名,船舶所有人,船舶登记号是否合法
        if (!db.islegal(textField11.getText(), textField12.getText())) {
            JOptionPane.showMessageDialog(null, "此船只未在[船只基本资料]中登记", "", JOptionPane.ERROR_MESSAGE);
        }
        //合法则将船只的检验证书基本信息录入到表 [船舶国籍证书]
        else {
            db.sqlLines = "insert into 船只营运证书(船名,船检登记号,营运证编号,船舶所有人,船舶登记号,经营人许可证号码,管理人许可证号码,发证机关,营运证使用有效期至,发证日期) "
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            db.pre();
            try {
                db.preparedStatement.setString(1, textField11.getText());
                db.preparedStatement.setString(2, textField12.getText());
                db.preparedStatement.setString(3, textField1.getText());
                db.preparedStatement.setString(4, textField5.getText());
                db.preparedStatement.setString(5, textField6.getText());
                db.preparedStatement.setString(6, textField8.getText());
                db.preparedStatement.setString(7, textField2.getText());
                db.preparedStatement.setString(8, textField3.getText());
                db.preparedStatement.setString(9, textField4.getText());
                db.preparedStatement.setString(10, textField9.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            db.exeSql();
            // 将证书有效期录入到表 [各证书有效期]
            db.sqlLines = "insert into 各证书有效期(船名,证书名,证书有效期至,发证日期) values(?,?,?,?)";
            db.pre();
            try {
                db.preparedStatement.setString(1, textField11.getText());
                db.preparedStatement.setString(2, "船只营运证书");
                db.preparedStatement.setString(3, textField4.getText());
                db.preparedStatement.setString(4, textField9.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            db.exeSql();
            if (db.effectedLines > 0) {
                JOptionPane.showMessageDialog(null, "录入数据成功", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "录入数据失败", "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        private void button2ActionPerformed (ActionEvent e){
            /**
             * @description: 录入数据到表 [国籍证书处理历史表]
             * @param [e]
             * @return void
             * @date: 2018/11/16 20:31
             */
            db.sqlLines = "insert into 营运证处理历史表(船名,证书编号,办理日期,办理人,证书有效期至,业务办理情况) values(?,?,?,?,?,?)";
            db.pre();
            try {
                db.preparedStatement.setString(1, textField11.getText());
                db.preparedStatement.setString(2, textField9.getText());
                db.preparedStatement.setString(3, textField10.getText());
                db.preparedStatement.setString(4, textField8.getText());
                db.preparedStatement.setString(5, textField14.getText());
                db.preparedStatement.setString(6, textField13.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            db.exeSql();
            if (db.effectedLines > 0) {
                JOptionPane.showMessageDialog(null, "录入数据成功", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "录入数据失败", "", JOptionPane.ERROR_MESSAGE);
            }
        }
        private void initComponents ()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            label2 = new JLabel();
            label15 = new JLabel();
            textField11 = new JTextField();
            label17 = new JLabel();
            label16 = new JLabel();
            textField12 = new JTextField();
            label3 = new JLabel();
            textField1 = new JTextField();
            label9 = new JLabel();
            textField2 = new JTextField();
            label4 = new JLabel();
            textField5 = new JTextField();
            label10 = new JLabel();
            textField3 = new JTextField();
            label5 = new JLabel();
            textField6 = new JTextField();
            label11 = new JLabel();
            textField4 = new JTextField();
            label6 = new JLabel();
            textField7 = new JTextField();
            label13 = new JLabel();
            button1 = new JButton();
            separator1 = new JSeparator();
            label1 = new JLabel();
            textField10 = new JTextField();
            label12 = new JLabel();
            textField9 = new JTextField();
            label7 = new JLabel();
            textField8 = new JTextField();
            label14 = new JLabel();
            textField14 = new JTextField();
            button2 = new JButton();
            label8 = new JLabel();
            textField13 = new JTextField();
            //======== this ========
            setVisible(true);
            Container contentPane = getContentPane();
            contentPane.setLayout(new GridBagLayout());
            ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{66, 116, 157, 71, 115, 171, 41, 0};
            ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 38, 37, 35, 13, 35, 35, 35, 35, 41, 0, 52, 35, 35, 35, 37, 43, 0};
            ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            //---- label2 ----
            label2.setText("\u8239\u53ea\u8425\u8fd0\u8bc1\u4e66\u57fa\u672c\u8d44\u6599");
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 13f));
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            contentPane.add(label2, new GridBagConstraints(1, 0, 5, 2, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label15 ----
            label15.setText("\u8239\u540d");
            label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 4f));
            contentPane.add(label15, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField11, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label17 ----
            label17.setText("\u2190\u5173\u8054\u2192");
            label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 6f));
            contentPane.add(label17, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label16 ----
            label16.setText("\u8239\u68c0\u767b\u8bb0\u53f7");
            label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 4f));
            contentPane.add(label16, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField12, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label3 ----
            label3.setText("\u8bc1\u4e66\u7f16\u53f7");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
            contentPane.add(label3, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField1, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label9 ----
            label9.setText("\u6362\u8bc1\u901a\u77e5\u65f6\u95f4");
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 4f));
            contentPane.add(label9, new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField2, new GridBagConstraints(5, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label4 ----
            label4.setText("\u8239\u8236\u6240\u6709\u4eba");
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
            contentPane.add(label4, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField5, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label10 ----
            label10.setText("\u6709\u6548\u671f\u81f3");
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 4f));
            contentPane.add(label10, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField3, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label5 ----
            label5.setText("\u8239\u8236\u767b\u8bb0\u53f7");
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
            contentPane.add(label5, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField6, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label11 ----
            label11.setText("\u53d1\u8bc1\u65e5\u671f");
            label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 4f));
            contentPane.add(label11, new GridBagConstraints(4, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField4, new GridBagConstraints(5, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label6 ----
            label6.setText("\u4e0b\u6b21\u6362\u8bc1\u65f6\u95f4");
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 4f));
            contentPane.add(label6, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField7, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label13 ----
            label13.setText("\u8239\u53ea\u8425\u8fd0\u8bc1\u4e66\u6362\u8bc1\u65f6\u95f4\u8bb0\u5f55");
            label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 9f));
            label13.setHorizontalAlignment(SwingConstants.CENTER);
            contentPane.add(label13, new GridBagConstraints(1, 11, 5, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- button1 ----
            button1.setText("\u786e\u8ba4");
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 7f));
            button1.addActionListener(e -> button1ActionPerformed(e));
            contentPane.add(button1, new GridBagConstraints(5, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(separator1, new GridBagConstraints(0, 10, 7, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
            //---- label1 ----
            label1.setText("\u529e\u7406\u65e5\u671f");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 4f));
            contentPane.add(label1, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField10, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label12 ----
            label12.setText("\u8bc1\u4e66\u7f16\u53f7");
            label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 4f));
            contentPane.add(label12, new GridBagConstraints(4, 12, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField9, new GridBagConstraints(5, 12, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label7 ----
            label7.setText("\u529e\u7406\u4eba");
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 4f));
            contentPane.add(label7, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField8, new GridBagConstraints(2, 13, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label14 ----
            label14.setText("\u6709\u6548\u671f\u81f3");
            label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 4f));
            contentPane.add(label14, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField14, new GridBagConstraints(2, 14, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- button2 ----
            button2.setText("\u6dfb\u52a0\u8bb0\u5f55");
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
            button2.addActionListener(e -> button2ActionPerformed(e));
            contentPane.add(button2, new GridBagConstraints(5, 15, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            //---- label8 ----
            label8.setText("\u4e1a\u52a1\u529e\u7406\u60c5\u51b5");
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 4f));
            contentPane.add(label8, new GridBagConstraints(1, 15, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            contentPane.add(textField13, new GridBagConstraints(2, 15, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            pack();
            setLocationRelativeTo(getOwner());
            // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }
        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        private JLabel label2;
        private JLabel label15;
        private JTextField textField11;
        private JLabel label17;
        private JLabel label16;
        private JTextField textField12;
        private JLabel label3;
        private JTextField textField1;
        private JLabel label9;
        private JTextField textField2;
        private JLabel label4;
        private JTextField textField5;
        private JLabel label10;
        private JTextField textField3;
        private JLabel label5;
        private JTextField textField6;
        private JLabel label11;
        private JTextField textField4;
        private JLabel label6;
        private JTextField textField7;
        private JLabel label13;
        private JButton button1;
        private JSeparator separator1;
        private JLabel label1;
        private JTextField textField10;
        private JLabel label12;
        private JTextField textField9;
        private JLabel label7;
        private JTextField textField8;
        private JLabel label14;
        private JTextField textField14;
        private JButton button2;
        private JLabel label8;
        private JTextField textField13;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }
