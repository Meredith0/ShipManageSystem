/*
 * Created by JFormDesigner on Wed Nov 14 19:58:13 CST 2018
 */

package BasicData;

import com.SQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
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
        comboBox1.addItem("船只名称");
        comboBox1.addItem("船舶登记号");
        comboBox1.addItem("船舶类型");
        comboBox1.addItem("船舶营运证号");
    }

    private void button1ActionPerformed(ActionEvent e) {
        /**
         * @description: 按船只名称、船检登记号、船舶类型、船舶营运证号等进行查询相关船只的基本资料
         * @param [e]
         * @return void
         * @date: 2018/11/15 20:21
         */
        db.sqlLines = "select * from 船舶所有权登记证书 where 船名=? or 船舶种类=? or 船舶登记号=? or 营运证号=?";
        db.pre();
        try {
            db.preparedStatement.setString(1, textField1.getText());
            db.preparedStatement.setString(2, textField1.getText());
            db.preparedStatement.setString(3, textField1.getText());
            db.preparedStatement.setString(4, textField1.getText());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        db.exeSelect();
        db.toTable(db, table1);

        db.sqlLines="select 船舶相片 from 船舶相片 where 船名=?";
        db.pre();
        byte [] b=new byte[10240*10];
        try {
            db.preparedStatement.setString(1, textField1.getText());
            ResultSet rs=db.preparedStatement.executeQuery();
            while (rs.next()) {
                //获取图片数据
                InputStream in=rs.getBinaryStream(1);
                //将数据存储在字节数组b中
                try {
                    in.read(b);
                    //从数据库获取图片保存的位置
                    File f=new File("D:/temp.jpg ");
                    FileOutputStream out=new FileOutputStream(f);
                    out.write(b, 0, b.length);
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            //显示图片
            ImageIcon imageIcon = new ImageIcon("D:/temp.jpg");
            label4.setIcon(imageIcon);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    private void button2ActionPerformed(ActionEvent e) {
        /**
         * @description: 由Jtable的数据更新数据库
         * @param [e]
         * @return void
         * @date: 2018/11/15 20:22
         */
        db.sqlLines = "update 船舶所有权登记证书 set 船名=?,船舶登记号=?,营运证号=?,船籍港=?,船舶种类=?,船体材料=?,机型=?,造船地点=?,建成日期=?,总长=?,型宽=?," +
                "型深=?,总吨=?,净吨=?,功率=?,载重吨=?,航行区域=?,船舶所有人=?,身份证=?,船舶所有人地址=?,联系电话=?,入户时间=?,迁出时间=?,备注=? where 序号=?";
        db.pre();
        //插入数据
        try {
            for (int j = 1; j <= 24; j++) {
                db.preparedStatement.setString(j, table1.getValueAt(table1.getSelectedRow(), j).toString());
            }
            //标识修改的行
            db.preparedStatement.setString(25, table1.getValueAt(table1.getSelectedRow(), 0).toString());
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame1 = new JFrame();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label3 = new JLabel();
        button2 = new JButton();
        label4 = new JLabel();

        //======== frame1 ========
        {
            frame1.setVisible(true);
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(null);

            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 83, 99, 0, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {28, 47, 45, 34, 41, 0, 0, 36, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("\u67e5\u8be2\u8239\u53ea\u8d44\u6599");
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
            }
            frame1ContentPane.add(panel1);
            panel1.setBounds(5, 5, 245, 450);

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null
                    }
                ));
                scrollPane1.setViewportView(table1);
            }
            frame1ContentPane.add(scrollPane1);
            scrollPane1.setBounds(250, 0, 1305, 190);

            //---- label3 ----
            label3.setText("\u67e5\u8be2\u8d44\u6599\u540e\u53ef\u5bf9\u5176\u8fdb\u884c\u4fee\u6539");
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 5f));
            frame1ContentPane.add(label3);
            label3.setBounds(1095, 265, 219, 40);

            //---- button2 ----
            button2.setText("\u786e\u8ba4\u4fee\u6539");
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 3f));
            button2.addActionListener(e -> button2ActionPerformed(e));
            frame1ContentPane.add(button2);
            button2.setBounds(1190, 310, 105, 40);

            //---- label4 ----
            label4.setText(" ");
            frame1ContentPane.add(label4);
            label4.setBounds(250, 205, 525, 275);

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
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label3;
    private JButton button2;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
