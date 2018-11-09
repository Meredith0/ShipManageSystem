package BasicData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Meredith
 * @CreateDate: 2018-11-09 22:04
 * @Project: ShipManageSystem
 * @Package: BasicData
 * @Description: 4-1 录入资料
 **/
public class AddBasicInfo extends BasicDateGUI
{
    public void initComponents(JPanel addPanel)
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        //addPanel = new JPanel();
        panel2 = new JPanel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        ID = new JTextField();
        phone = new JTextField();
        onwer = new JTextField();
        address = new JTextField();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        shipName = new JTextField();
        shipType = new JTextField();
        shipMeterial = new JTextField();
        shipModel = new JTextField();
        label16 = new JLabel();
        label15 = new JLabel();
        port = new JTextField();
        label17 = new JLabel();
        factory = new JTextField();
        label18 = new JLabel();
        shipOfficialNumber = new JTextField();
        label19 = new JLabel();
        operatingLicenceNumber = new JTextField();
        label20 = new JLabel();
        checkDate = new JTextField();
        label21 = new JLabel();
        departureDate = new JTextField();
        label235 = new JLabel();
        buildDate = new JTextField();
        label23 = new JLabel();
        totalLength = new JTextField();
        label24 = new JLabel();
        totalWidth = new JTextField();
        label25 = new JLabel();
        totalDepth = new JTextField();
        label26 = new JLabel();
        grossWeight = new JTextField();
        label27 = new JLabel();
        netWeight = new JTextField();
        label28 = new JLabel();
        mainPower = new JTextField();
        label1434 = new JLabel();
        deadWeight = new JTextField();
        label22 = new JLabel();
        navigationLimits = new JTextField();
        label29 = new JLabel();
        remarks = new JTextField();
        label30 = new JLabel();
        photo = new JTextField();
        button1 = new JButton();

        //======== addPanel ========
        {
            addPanel.setLayout(null);

            //======== panel2 ========
            {
                panel2.setLayout(null);
            }
            addPanel.add(panel2);
            panel2.setBounds(90, 80, panel2.getPreferredSize().width, 0);

            //---- label6 ----
            label6.setText("\u8239\u4e3b\u57fa\u672c\u8d44\u6599");
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));
            addPanel.add(label6);
            label6.setBounds(95, 10, 150, 45);

            //---- label7 ----
            label7.setText("\u8239\u4e3b\u59d3\u540d");
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 3f));
            addPanel.add(label7);
            label7.setBounds(50, 70, 70, 22);

            //---- label8 ----
            label8.setText("\u8eab\u4efd\u8bc1");
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 3f));
            addPanel.add(label8);
            label8.setBounds(new Rectangle(new Point(61, 100), label8.getPreferredSize()));

            //---- label9 ----
            label9.setText("\u8054\u7cfb\u7535\u8bdd");
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 3f));
            addPanel.add(label9);
            label9.setBounds(56, 130, label9.getPreferredSize().width, 22);

            //---- label10 ----
            label10.setText("\u8be6\u7ec6\u4f4f\u5740");
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 3f));
            addPanel.add(label10);
            label10.setBounds(new Rectangle(new Point(56, 165), label10.getPreferredSize()));
            addPanel.add(ID);
            ID.setBounds(130, 98, 125, ID.getPreferredSize().height);
            addPanel.add(phone);
            phone.setBounds(130, 130, 125, phone.getPreferredSize().height);
            addPanel.add(onwer);
            onwer.setBounds(130, 67, 125, onwer.getPreferredSize().height);
            addPanel.add(address);
            address.setBounds(130, 163, 125, address.getPreferredSize().height);

            //---- label11 ----
            label11.setText("\u8239\u53ea\u540d\u79f0");
            label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 3f));
            addPanel.add(label11);
            label11.setBounds(new Rectangle(new Point(290, 70), label11.getPreferredSize()));

            //---- label12 ----
            label12.setText("\u8239\u8236\u7c7b\u578b");
            label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 3f));
            addPanel.add(label12);
            label12.setBounds(290, 103, label12.getPreferredSize().width, 17);

            //---- label13 ----
            label13.setText("\u8239\u4f53\u6750\u6599");
            label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 3f));
            addPanel.add(label13);
            label13.setBounds(new Rectangle(new Point(290, 134), label13.getPreferredSize()));

            //---- label14 ----
            label14.setText("\u673a\u578b");
            label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 3f));
            addPanel.add(label14);
            label14.setBounds(new Rectangle(new Point(290, 165), label14.getPreferredSize()));
            addPanel.add(shipName);
            shipName.setBounds(375, 65, 125, shipName.getPreferredSize().height);
            addPanel.add(shipType);
            shipType.setBounds(375, 97, 125, shipType.getPreferredSize().height);
            addPanel.add(shipMeterial);
            shipMeterial.setBounds(375, 129, 125, shipMeterial.getPreferredSize().height);
            addPanel.add(shipModel);
            shipModel.setBounds(375, 162, 125, shipModel.getPreferredSize().height);

            //---- label16 ----
            label16.setText("\u8239\u53ea\u57fa\u672c\u8d44\u6599");
            label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 10f));
            addPanel.add(label16);
            label16.setBounds(450, 10, 150, 45);

            //---- label15 ----
            label15.setText("\u8239\u7c4d\u6e2f");
            label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 3f));
            addPanel.add(label15);
            label15.setBounds(new Rectangle(new Point(290, 200), label15.getPreferredSize()));
            addPanel.add(port);
            port.setBounds(375, 195, 125, port.getPreferredSize().height);

            //---- label17 ----
            label17.setText("\u5efa\u9020\u5382");
            label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 3f));
            addPanel.add(label17);
            label17.setBounds(289, 235, 60, 20);
            addPanel.add(factory);
            factory.setBounds(374, 230, 125, 30);

            //---- label18 ----
            label18.setText("\u8239\u8236\u767b\u8bb0\u53f7");
            label18.setFont(label18.getFont().deriveFont(label18.getFont().getSize() + 3f));
            addPanel.add(label18);
            label18.setBounds(new Rectangle(new Point(289, 270), label18.getPreferredSize()));
            addPanel.add(shipOfficialNumber);
            shipOfficialNumber.setBounds(374, 265, 125, 30);

            //---- label19 ----
            label19.setText("\u8425\u8fd0\u8bc1\u53f7");
            label19.setFont(label19.getFont().deriveFont(label19.getFont().getSize() + 3f));
            addPanel.add(label19);
            label19.setBounds(new Rectangle(new Point(289, 305), label19.getPreferredSize()));
            addPanel.add(operatingLicenceNumber);
            operatingLicenceNumber.setBounds(374, 300, 125, 30);

            //---- label20 ----
            label20.setText("\u5165\u6237\u65f6\u95f4");
            label20.setFont(label20.getFont().deriveFont(label20.getFont().getSize() + 3f));
            addPanel.add(label20);
            label20.setBounds(new Rectangle(new Point(289, 340), label20.getPreferredSize()));
            addPanel.add(checkDate);
            checkDate.setBounds(374, 335, 125, 30);

            //---- label21 ----
            label21.setText("\u8fc1\u51fa\u65f6\u95f4");
            label21.setFont(label21.getFont().deriveFont(label21.getFont().getSize() + 3f));
            addPanel.add(label21);
            label21.setBounds(new Rectangle(new Point(292, 377), label21.getPreferredSize()));
            addPanel.add(departureDate);
            departureDate.setBounds(375, 372, 125, 30);

            //---- label235 ----
            label235.setText("\u5efa\u6210\u65f6\u95f4");
            label235.setFont(label235.getFont().deriveFont(label235.getFont().getSize() + 3f));
            addPanel.add(label235);
            label235.setBounds(518, 71, 60, 17);
            addPanel.add(buildDate);
            buildDate.setBounds(609, 65, 125, 30);

            //---- label23 ----
            label23.setText("\u603b\u957f");
            label23.setFont(label23.getFont().deriveFont(label23.getFont().getSize() + 3f));
            addPanel.add(label23);
            label23.setBounds(520, 102, 60, 20);
            addPanel.add(totalLength);
            totalLength.setBounds(609, 97, 125, 30);

            //---- label24 ----
            label24.setText("\u578b\u5bbd");
            label24.setFont(label24.getFont().deriveFont(label24.getFont().getSize() + 3f));
            addPanel.add(label24);
            label24.setBounds(521, 133, 30, 20);
            addPanel.add(totalWidth);
            totalWidth.setBounds(609, 128, 125, 30);

            //---- label25 ----
            label25.setText("\u578b\u6df1");
            label25.setFont(label25.getFont().deriveFont(label25.getFont().getSize() + 3f));
            addPanel.add(label25);
            label25.setBounds(520, 168, 60, 20);
            addPanel.add(totalDepth);
            totalDepth.setBounds(609, 163, 125, 30);

            //---- label26 ----
            label26.setText("\u603b\u5428");
            label26.setFont(label26.getFont().deriveFont(label26.getFont().getSize() + 3f));
            addPanel.add(label26);
            label26.setBounds(519, 203, 60, 20);
            addPanel.add(grossWeight);
            grossWeight.setBounds(608, 198, 125, 30);

            //---- label27 ----
            label27.setText("\u51c0\u5428");
            label27.setFont(label27.getFont().deriveFont(label27.getFont().getSize() + 3f));
            addPanel.add(label27);
            label27.setBounds(519, 238, 76, 20);
            addPanel.add(netWeight);
            netWeight.setBounds(608, 233, 125, 30);

            //---- label28 ----
            label28.setText("\u4e3b\u673a\u529f\u7387");
            label28.setFont(label28.getFont().deriveFont(label28.getFont().getSize() + 3f));
            addPanel.add(label28);
            label28.setBounds(new Rectangle(new Point(518, 273), label28.getPreferredSize()));
            addPanel.add(mainPower);
            mainPower.setBounds(608, 268, 125, 30);

            //---- label1434 ----
            label1434.setText("\u8f7d\u91cd\u5428");
            label1434.setFont(label1434.getFont().deriveFont(label1434.getFont().getSize() + 3f));
            addPanel.add(label1434);
            label1434.setBounds(new Rectangle(new Point(519, 308), label1434.getPreferredSize()));
            addPanel.add(deadWeight);
            deadWeight.setBounds(608, 303, 125, 30);

            //---- label22 ----
            label22.setText("\u822a\u884c\u533a\u57df");
            label22.setFont(label22.getFont().deriveFont(label22.getFont().getSize() + 3f));
            addPanel.add(label22);
            label22.setBounds(518, 342, 60, label22.getPreferredSize().height);
            addPanel.add(navigationLimits);
            navigationLimits.setBounds(607, 337, 125, 30);

            //---- label29 ----
            label29.setText("\u5907\u6ce8");
            label29.setFont(label29.getFont().deriveFont(label29.getFont().getSize() + 3f));
            addPanel.add(label29);
            label29.setBounds(new Rectangle(new Point(522, 377), label29.getPreferredSize()));
            addPanel.add(remarks);
            remarks.setBounds(607, 372, 125, 30);

            //---- label30 ----
            label30.setText("\u8239\u8236\u76f8\u7247");
            label30.setFont(label30.getFont().deriveFont(label30.getFont().getSize() + 3f));
            addPanel.add(label30);
            label30.setBounds(new Rectangle(new Point(521, 412), label30.getPreferredSize()));
            addPanel.add(photo);
            photo.setBounds(607, 407, 125, 30);

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.addActionListener(new confirmHandler());
            addPanel.add(button1);
            button1.setBounds(new Rectangle(new Point(340, 480), button1.getPreferredSize()));

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < addPanel.getComponentCount(); i++)
                {
                    Rectangle bounds = addPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = addPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                addPanel.setMinimumSize(preferredSize);
                addPanel.setPreferredSize(preferredSize);
            }
        }

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < addPanel.getComponentCount(); i++)
            {
                Rectangle bounds = addPanel.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = addPanel.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            addPanel.setMinimumSize(preferredSize);
            addPanel.setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    class confirmHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //获取所有输入框的值
            String getOwner = onwer.getText();
            String getID = ID.getText();
            String getphone=phone.getText();
            String getAddress = address.getText();

            String name = shipName.getText();
            String type = shipType.getText();
            String meterial = shipMeterial.getText();
            String model = shipModel.getText();
            String oriPort=port.getText();
            String buildFactory=factory.getText();
            String officialNum=shipOfficialNumber.getText();
            String operatingNum=shipOfficialNumber.getText();
            String checkDt=checkDate.getText();
            String departureDt = departureDate.getText();
            String buildDt = buildDate.getText();
            String length = totalLength.getText();
            String width = totalWidth.getText();
            String depth = totalDepth.getText();
            String GW = grossWeight.getText();
            String NW = netWeight.getText();
            String power = mainPower.getText();
            String deadW = deadWeight.getText();
            String navlimits = navigationLimits.getText();
            String remark = remarks.getText();
            String picture = phone.getText();

            db.sqlLines="insert into 船舶所有权登记证书(船名,船舶种类,船体材料,船籍港,建造厂,登记号码,取得所有权日期,)";

        }
    }

    //static public JPanel addPanel;
    private JPanel panel2;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JTextField ID;
    private JTextField phone;
    private JTextField onwer;
    private JTextField address;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JTextField shipName;
    private JTextField shipType;
    private JTextField shipMeterial;
    private JTextField shipModel;
    private JLabel label16;
    private JLabel label15;
    private JTextField port;
    private JLabel label17;
    private JTextField factory;
    private JLabel label18;
    private JTextField shipOfficialNumber;
    private JLabel label19;
    private JTextField operatingLicenceNumber;
    private JLabel label20;
    private JTextField checkDate;
    private JLabel label21;
    private JTextField departureDate;
    private JLabel label235;
    private JTextField buildDate;
    private JLabel label23;
    private JTextField totalLength;
    private JLabel label24;
    private JTextField totalWidth;
    private JLabel label25;
    private JTextField totalDepth;
    private JLabel label26;
    private JTextField grossWeight;
    private JLabel label27;
    private JTextField netWeight;
    private JLabel label28;
    private JTextField mainPower;
    private JLabel label1434;
    private JTextField deadWeight;
    private JLabel label22;
    private JTextField navigationLimits;
    private JLabel label29;
    private JTextField remarks;
    private JLabel label30;
    private JTextField photo;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
