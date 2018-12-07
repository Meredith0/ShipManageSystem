/*
 * Created by JFormDesigner on Wed Nov 14 18:14:22 CST 2018
 */

package BasicData;

import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
         * @description: 录入数据
         * @param [e]
         * @return void
         * @date: 2018/11/13 20:22
         */
        db.sqlLines = String.format("insert into 船舶所有权登记证书(船名,船舶种类,船体材料,机型,船籍港,造船地点,船舶登记号,营运证号,入户时间,迁出时间,建成日期,总长,型宽," +
                "型深,总吨,净吨,功率,载重吨,航行区域,备注,船舶所有人,身份证,船舶所有人地址,联系电话) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                "?,?,?)");
        db.pre();
        try {
            db.preparedStatement.setString(1, textField6.getText());
            db.preparedStatement.setString(2, textField7.getText());
            db.preparedStatement.setString(3, textField8.getText());
            db.preparedStatement.setString(4, textField9.getText());
            db.preparedStatement.setString(5, textField10.getText());
            db.preparedStatement.setString(6, textField11.getText());
            db.preparedStatement.setString(7, textField12.getText());
            db.preparedStatement.setString(8, textField13.getText());
            db.preparedStatement.setString(9, textField14.getText());
            db.preparedStatement.setString(10, textField15.getText());
            db.preparedStatement.setString(11, textField16.getText());
            db.preparedStatement.setString(12, textField17.getText());
            db.preparedStatement.setString(13, textField18.getText());
            db.preparedStatement.setString(14, textField19.getText());
            db.preparedStatement.setString(15, textField20.getText());
            db.preparedStatement.setString(16, textField21.getText());
            db.preparedStatement.setString(17, textField22.getText());
            db.preparedStatement.setString(18, textField23.getText());
            db.preparedStatement.setString(19, textField24.getText());
            db.preparedStatement.setString(20, textField25.getText());
            db.preparedStatement.setString(21, textField2.getText());
            db.preparedStatement.setString(22, textField3.getText());
            db.preparedStatement.setString(23, textField4.getText());
            db.preparedStatement.setString(24, textField5.getText());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSql();
        if (db.effectedLines > 0) {
            JOptionPane.showMessageDialog(null, "录入数据成功", "OK", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "录入数据失败", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        /**
         * @description: 上传照片
         */
        String path=null;
        try {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(fileChooser.FILES_ONLY);
            int n = fileChooser.showOpenDialog(this.getContentPane());
            if (n == fileChooser.APPROVE_OPTION) {

                path=fileChooser.getSelectedFile().getPath();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        db.sqlLines = "insert into 船舶相片(船名,船舶相片) values(?,?)";
        db.pre();
        File f=new File(path);
        try {
            FileInputStream input= new FileInputStream(f);
            db.preparedStatement.setString(1,textField6.getText());
            db.preparedStatement.setBinaryStream(2,input,(int)f.length());
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSql();
        if (db.effectedLines == 1) {
            JOptionPane.showMessageDialog(null, "上传照片成功", "OK", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "上传照片失败", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame1 = new JFrame();
        addData = new JPanel();
        label3 = new JLabel();
        label26 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label6 = new JLabel();
        textField6 = new JTextField();
        label16 = new JLabel();
        textField16 = new JTextField();
        label1 = new JLabel();
        textField3 = new JTextField();
        label7 = new JLabel();
        textField7 = new JTextField();
        label17 = new JLabel();
        textField17 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label8 = new JLabel();
        textField8 = new JTextField();
        label18 = new JLabel();
        textField18 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        label9 = new JLabel();
        textField9 = new JTextField();
        label19 = new JLabel();
        textField19 = new JTextField();
        label10 = new JLabel();
        textField10 = new JTextField();
        label20 = new JLabel();
        textField20 = new JTextField();
        label11 = new JLabel();
        textField11 = new JTextField();
        label21 = new JLabel();
        textField21 = new JTextField();
        label12 = new JLabel();
        textField12 = new JTextField();
        label22 = new JLabel();
        textField22 = new JTextField();
        label13 = new JLabel();
        textField13 = new JTextField();
        label23 = new JLabel();
        textField23 = new JTextField();
        label14 = new JLabel();
        textField14 = new JTextField();
        label24 = new JLabel();
        textField24 = new JTextField();
        label15 = new JLabel();
        textField15 = new JTextField();
        label25 = new JLabel();
        textField25 = new JTextField();
        button2 = new JButton();
        button1 = new JButton();

        //======== frame1 ========
        {
            frame1.setVisible(true);
            frame1.setBackground(Color.black);
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(null);

            //======== addData ========
            {
                addData.setLayout(new GridBagLayout());
                ((GridBagLayout)addData.getLayout()).columnWidths = new int[] {20, 61, 0, 123, 0, 0, 73, 152, 0, 75, 0, 137, 0, 0};
                ((GridBagLayout)addData.getLayout()).rowHeights = new int[] {65, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 43, 38, 0, 0};
                ((GridBagLayout)addData.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)addData.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label3 ----
                label3.setText("            \u8239\u4e3b\u57fa\u672c\u8d44\u6599");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 6f));
                addData.add(label3, new GridBagConstraints(1, 0, 4, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label26 ----
                label26.setText("                              \u8239\u53ea\u57fa\u672c\u8d44\u6599");
                label26.setFont(label26.getFont().deriveFont(label26.getFont().getSize() + 6f));
                addData.add(label26, new GridBagConstraints(7, 0, 5, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label2 ----
                label2.setText("\u8239\u4e3b\u59d3\u540d");
                addData.add(label2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label6 ----
                label6.setText("\u8239\u53ea\u540d\u79f0");
                addData.add(label6, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField6, new GridBagConstraints(7, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label16 ----
                label16.setText("\u5efa\u6210\u65f6\u95f4");
                addData.add(label16, new GridBagConstraints(9, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField16, new GridBagConstraints(10, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label1 ----
                label1.setText("\u8eab\u4efd\u8bc1");
                addData.add(label1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField3, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label7 ----
                label7.setText("\u8239\u8236\u7c7b\u578b");
                addData.add(label7, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField7, new GridBagConstraints(7, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label17 ----
                label17.setText("\u603b\u957f");
                addData.add(label17, new GridBagConstraints(9, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField17, new GridBagConstraints(10, 2, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label4 ----
                label4.setText("\u8054\u7cfb\u7535\u8bdd");
                addData.add(label4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField4, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label8 ----
                label8.setText("\u8239\u4f53\u6750\u6599");
                addData.add(label8, new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField8, new GridBagConstraints(7, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label18 ----
                label18.setText("\u578b\u5bbd");
                addData.add(label18, new GridBagConstraints(9, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField18, new GridBagConstraints(10, 3, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label5 ----
                label5.setText("\u8be6\u7ec6\u4f4f\u5740");
                addData.add(label5, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField5, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label9 ----
                label9.setText("\u673a\u578b");
                addData.add(label9, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField9, new GridBagConstraints(7, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label19 ----
                label19.setText("\u578b\u6df1");
                addData.add(label19, new GridBagConstraints(9, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField19, new GridBagConstraints(10, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label10 ----
                label10.setText("\u8239\u7c4d\u6e2f");
                addData.add(label10, new GridBagConstraints(6, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField10, new GridBagConstraints(7, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label20 ----
                label20.setText("\u603b\u5428");
                addData.add(label20, new GridBagConstraints(9, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField20, new GridBagConstraints(10, 5, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label11 ----
                label11.setText("\u5efa\u9020\u5382");
                addData.add(label11, new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField11, new GridBagConstraints(7, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label21 ----
                label21.setText("\u51c0\u5428");
                addData.add(label21, new GridBagConstraints(9, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField21, new GridBagConstraints(10, 6, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label12 ----
                label12.setText("\u8239\u8236\u767b\u8bb0\u53f7");
                addData.add(label12, new GridBagConstraints(6, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField12, new GridBagConstraints(7, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label22 ----
                label22.setText("\u4e3b\u673a\u529f\u7387");
                addData.add(label22, new GridBagConstraints(9, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField22, new GridBagConstraints(10, 7, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label13 ----
                label13.setText("\u8425\u8fd0\u8bc1\u53f7");
                addData.add(label13, new GridBagConstraints(6, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField13, new GridBagConstraints(7, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label23 ----
                label23.setText("\u8f7d\u91cd\u5428(AB\u7ea7)");
                addData.add(label23, new GridBagConstraints(9, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField23, new GridBagConstraints(10, 8, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label14 ----
                label14.setText("\u5165\u6237\u65f6\u95f4");
                addData.add(label14, new GridBagConstraints(6, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField14, new GridBagConstraints(7, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label24 ----
                label24.setText("\u822a\u884c\u533a\u57df");
                addData.add(label24, new GridBagConstraints(9, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField24, new GridBagConstraints(10, 9, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label15 ----
                label15.setText("\u8fc1\u51fa\u65f6\u95f4");
                addData.add(label15, new GridBagConstraints(6, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField15, new GridBagConstraints(7, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- label25 ----
                label25.setText("\u5907\u6ce8");
                addData.add(label25, new GridBagConstraints(9, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
                addData.add(textField25, new GridBagConstraints(10, 10, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- button2 ----
                button2.setText("\u4e0a\u4f20\u8239\u53ea\u7167\u7247");
                button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 4f));
                button2.addActionListener(e -> button2ActionPerformed(e));
                addData.add(button2, new GridBagConstraints(7, 12, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- button1 ----
                button1.setText("\u786e\u5b9a");
                button1.addActionListener(e -> button1ActionPerformed(e));
                addData.add(button1, new GridBagConstraints(10, 12, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));
            }
            frame1ContentPane.add(addData);
            addData.setBounds(0, 0, 790, 480);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < frame1ContentPane.getComponentCount(); i++) {
                    Rectangle bounds = frame1ContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = frame1ContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                frame1ContentPane.setMinimumSize(preferredSize);
                frame1ContentPane.setPreferredSize(preferredSize);
            }
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JPanel addData;
    private JLabel label3;
    private JLabel label26;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label6;
    private JTextField textField6;
    private JLabel label16;
    private JTextField textField16;
    private JLabel label1;
    private JTextField textField3;
    private JLabel label7;
    private JTextField textField7;
    private JLabel label17;
    private JTextField textField17;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label8;
    private JTextField textField8;
    private JLabel label18;
    private JTextField textField18;
    private JLabel label5;
    private JTextField textField5;
    private JLabel label9;
    private JTextField textField9;
    private JLabel label19;
    private JTextField textField19;
    private JLabel label10;
    private JTextField textField10;
    private JLabel label20;
    private JTextField textField20;
    private JLabel label11;
    private JTextField textField11;
    private JLabel label21;
    private JTextField textField21;
    private JLabel label12;
    private JTextField textField12;
    private JLabel label22;
    private JTextField textField22;
    private JLabel label13;
    private JTextField textField13;
    private JLabel label23;
    private JTextField textField23;
    private JLabel label14;
    private JTextField textField14;
    private JLabel label24;
    private JTextField textField24;
    private JLabel label15;
    private JTextField textField15;
    private JLabel label25;
    private JTextField textField25;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
