/*
 * Created by JFormDesigner on Thu Nov 15 22:02:09 CST 2018
 */

package BasicData;

import Login.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Meredith
 */
public class Panel extends JFrame
{
    /**
     * @description: 用于调用三个组件
     * @param
     * @return
     * @date: 2018/11/15 22:22
     */
    public Panel()
    {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e)
    {
        new AddData();

    }

    private void button3ActionPerformed(ActionEvent e)
    {
        SelectAndModifyData selectAndModifyData = new SelectAndModifyData();
        selectAndModifyData.addCheckBoxItems();
    }

    private void button2ActionPerformed(ActionEvent e)
    {
        new DeleteData();

    }

    private void returnUpperPanelHandler(ActionEvent e)
    {
        //返回上一层菜单
        this.dispose();
        new MainPanel();
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        button1 = new JButton();
        button3 = new JButton();
        button2 = new JButton();
        button4 = new JButton();

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {83, 84, 80, 83, 83, 76, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {68, 0, 48, 0, 13, 47, 0, 75, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label1 ----
        label1.setText("     \u8239\u53ea\u57fa\u672c\u8d44\u6599\u7ba1\u7406\u6a21\u5757");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1, new GridBagConstraints(1, 0, 4, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button1 ----
        button1.setText("\u65b0\u589e\u8239\u53ea");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(1, 2, 2, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button3 ----
        button3.setText("\u67e5\u8be2\u4e0e\u4fee\u6539");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3, new GridBagConstraints(3, 2, 2, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button2 ----
        button2.setText("\u5220\u9664");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2, new GridBagConstraints(1, 5, 2, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- button4 ----
        button4.setText("\u8fd4\u56de\u4e0a\u4e00\u5c42");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 5f));
        button4.addActionListener(e -> returnUpperPanelHandler(e));
        contentPane.add(button4, new GridBagConstraints(3, 5, 2, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
