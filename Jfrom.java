/*
 * Created by JFormDesigner on Wed Nov 07 12:23:20 CST 2018
 */



/**
 * @author unknown
 */
public class Jfrom extends JPanel {
    public Jfrom() {
        initComponents();
    }

    private void comboBox1ItemStateChanged() {
        // TODO AddBasicInfo your code here

    }

    private void confirmHandler(ActionEvent e) {
        // TODO AddBasicInfo your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this2 = new JPanel();
        panel2 = new JPanel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        ID = new JTextField();
        phone = new JTextField();
        onwer = new JTextField();
        textField9 = new JTextField();
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
        buildDate = new JLabel();
        bulidDate = new JTextField();
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
        deadWeight = new JLabel();
        shipName12 = new JTextField();
        label22 = new JLabel();
        navigationLimits = new JTextField();
        label29 = new JLabel();
        remarks = new JTextField();
        label30 = new JLabel();
        photo = new JTextField();
        button1 = new JButton();

        //======== this2 ========
        {
            this2.setLayout(null);

            //======== panel2 ========
            {
                panel2.setLayout(null);
            }
            this2.add(panel2);
            panel2.setBounds(90, 80, panel2.getPreferredSize().width, 0);

            //---- label6 ----
            label6.setText("\u8239\u4e3b\u57fa\u672c\u8d44\u6599");
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 10f));
            this2.add(label6);
            label6.setBounds(95, 10, 150, 45);

            //---- label7 ----
            label7.setText("\u8239\u4e3b\u59d3\u540d");
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 3f));
            this2.add(label7);
            label7.setBounds(56, 70, 60, 22);

            //---- label8 ----
            label8.setText("\u8eab\u4efd\u8bc1");
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getSize() + 3f));
            this2.add(label8);
            label8.setBounds(new Rectangle(new Point(61, 100), label8.getPreferredSize()));

            //---- label9 ----
            label9.setText("\u8054\u7cfb\u7535\u8bdd");
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 3f));
            this2.add(label9);
            label9.setBounds(56, 130, label9.getPreferredSize().width, 22);

            //---- label10 ----
            label10.setText("\u8be6\u7ec6\u4f4f\u5740");
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 3f));
            this2.add(label10);
            label10.setBounds(new Rectangle(new Point(56, 165), label10.getPreferredSize()));
            this2.add(ID);
            ID.setBounds(130, 98, 125, ID.getPreferredSize().height);
            this2.add(phone);
            phone.setBounds(130, 130, 125, phone.getPreferredSize().height);
            this2.add(onwer);
            onwer.setBounds(130, 67, 125, onwer.getPreferredSize().height);
            this2.add(textField9);
            textField9.setBounds(130, 163, 125, textField9.getPreferredSize().height);

            //---- label11 ----
            label11.setText("\u8239\u53ea\u540d\u79f0");
            label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 3f));
            this2.add(label11);
            label11.setBounds(new Rectangle(new Point(290, 70), label11.getPreferredSize()));

            //---- label12 ----
            label12.setText("\u8239\u8236\u7c7b\u578b");
            label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 3f));
            this2.add(label12);
            label12.setBounds(290, 103, label12.getPreferredSize().width, 17);

            //---- label13 ----
            label13.setText("\u8239\u4f53\u6750\u6599");
            label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 3f));
            this2.add(label13);
            label13.setBounds(new Rectangle(new Point(290, 134), label13.getPreferredSize()));

            //---- label14 ----
            label14.setText("\u673a\u578b");
            label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 3f));
            this2.add(label14);
            label14.setBounds(new Rectangle(new Point(290, 165), label14.getPreferredSize()));
            this2.add(shipName);
            shipName.setBounds(375, 65, 125, shipName.getPreferredSize().height);
            this2.add(shipType);
            shipType.setBounds(375, 97, 125, shipType.getPreferredSize().height);
            this2.add(shipMeterial);
            shipMeterial.setBounds(375, 129, 125, shipMeterial.getPreferredSize().height);
            this2.add(shipModel);
            shipModel.setBounds(375, 162, 125, shipModel.getPreferredSize().height);

            //---- label16 ----
            label16.setText("\u8239\u53ea\u57fa\u672c\u8d44\u6599");
            label16.setFont(label16.getFont().deriveFont(label16.getFont().getSize() + 10f));
            this2.add(label16);
            label16.setBounds(450, 10, 150, 45);

            //---- label15 ----
            label15.setText("\u8239\u7c4d\u6e2f");
            label15.setFont(label15.getFont().deriveFont(label15.getFont().getSize() + 3f));
            this2.add(label15);
            label15.setBounds(new Rectangle(new Point(290, 200), label15.getPreferredSize()));
            this2.add(port);
            port.setBounds(375, 195, 125, port.getPreferredSize().height);

            //---- label17 ----
            label17.setText("\u5efa\u9020\u5382");
            label17.setFont(label17.getFont().deriveFont(label17.getFont().getSize() + 3f));
            this2.add(label17);
            label17.setBounds(289, 235, 60, 20);
            this2.add(factory);
            factory.setBounds(374, 230, 125, 30);

            //---- label18 ----
            label18.setText("\u8239\u8236\u767b\u8bb0\u53f7");
            label18.setFont(label18.getFont().deriveFont(label18.getFont().getSize() + 3f));
            this2.add(label18);
            label18.setBounds(new Rectangle(new Point(289, 270), label18.getPreferredSize()));
            this2.add(shipOfficialNumber);
            shipOfficialNumber.setBounds(374, 265, 125, 30);

            //---- label19 ----
            label19.setText("\u8425\u8fd0\u8bc1\u53f7");
            label19.setFont(label19.getFont().deriveFont(label19.getFont().getSize() + 3f));
            this2.add(label19);
            label19.setBounds(new Rectangle(new Point(289, 305), label19.getPreferredSize()));
            this2.add(operatingLicenceNumber);
            operatingLicenceNumber.setBounds(374, 300, 125, 30);

            //---- label20 ----
            label20.setText("\u5165\u6237\u65f6\u95f4");
            label20.setFont(label20.getFont().deriveFont(label20.getFont().getSize() + 3f));
            this2.add(label20);
            label20.setBounds(new Rectangle(new Point(289, 340), label20.getPreferredSize()));
            this2.add(checkDate);
            checkDate.setBounds(374, 335, 125, 30);

            //---- label21 ----
            label21.setText("\u8fc1\u51fa\u65f6\u95f4");
            label21.setFont(label21.getFont().deriveFont(label21.getFont().getSize() + 3f));
            this2.add(label21);
            label21.setBounds(new Rectangle(new Point(292, 377), label21.getPreferredSize()));
            this2.add(departureDate);
            departureDate.setBounds(375, 372, 125, 30);

            //---- buildDate ----
            buildDate.setText("\u5efa\u6210\u65f6\u95f4");
            buildDate.setFont(buildDate.getFont().deriveFont(buildDate.getFont().getSize() + 3f));
            this2.add(buildDate);
            buildDate.setBounds(518, 71, 60, 17);
            this2.add(bulidDate);
            bulidDate.setBounds(609, 65, 125, 30);

            //---- label23 ----
            label23.setText("\u603b\u957f");
            label23.setFont(label23.getFont().deriveFont(label23.getFont().getSize() + 3f));
            this2.add(label23);
            label23.setBounds(520, 102, 60, 20);
            this2.add(totalLength);
            totalLength.setBounds(609, 97, 125, 30);

            //---- label24 ----
            label24.setText("\u578b\u5bbd");
            label24.setFont(label24.getFont().deriveFont(label24.getFont().getSize() + 3f));
            this2.add(label24);
            label24.setBounds(521, 133, 30, 20);
            this2.add(totalWidth);
            totalWidth.setBounds(609, 128, 125, 30);

            //---- label25 ----
            label25.setText("\u578b\u6df1");
            label25.setFont(label25.getFont().deriveFont(label25.getFont().getSize() + 3f));
            this2.add(label25);
            label25.setBounds(520, 168, 60, 20);
            this2.add(totalDepth);
            totalDepth.setBounds(609, 163, 125, 30);

            //---- label26 ----
            label26.setText("\u603b\u5428");
            label26.setFont(label26.getFont().deriveFont(label26.getFont().getSize() + 3f));
            this2.add(label26);
            label26.setBounds(519, 203, 60, 20);
            this2.add(grossWeight);
            grossWeight.setBounds(608, 198, 125, 30);

            //---- label27 ----
            label27.setText("\u51c0\u5428");
            label27.setFont(label27.getFont().deriveFont(label27.getFont().getSize() + 3f));
            this2.add(label27);
            label27.setBounds(519, 238, 76, 20);
            this2.add(netWeight);
            netWeight.setBounds(608, 233, 125, 30);

            //---- label28 ----
            label28.setText("\u4e3b\u673a\u529f\u7387");
            label28.setFont(label28.getFont().deriveFont(label28.getFont().getSize() + 3f));
            this2.add(label28);
            label28.setBounds(new Rectangle(new Point(518, 273), label28.getPreferredSize()));
            this2.add(mainPower);
            mainPower.setBounds(608, 268, 125, 30);

            //---- deadWeight ----
            deadWeight.setText("\u8f7d\u91cd\u5428");
            deadWeight.setFont(deadWeight.getFont().deriveFont(deadWeight.getFont().getSize() + 3f));
            this2.add(deadWeight);
            deadWeight.setBounds(new Rectangle(new Point(519, 308), deadWeight.getPreferredSize()));
            this2.add(shipName12);
            shipName12.setBounds(608, 303, 125, 30);

            //---- label22 ----
            label22.setText("\u822a\u884c\u533a\u57df");
            label22.setFont(label22.getFont().deriveFont(label22.getFont().getSize() + 3f));
            this2.add(label22);
            label22.setBounds(518, 342, 60, label22.getPreferredSize().height);
            this2.add(navigationLimits);
            navigationLimits.setBounds(607, 337, 125, 30);

            //---- label29 ----
            label29.setText("\u5907\u6ce8");
            label29.setFont(label29.getFont().deriveFont(label29.getFont().getSize() + 3f));
            this2.add(label29);
            label29.setBounds(new Rectangle(new Point(522, 377), label29.getPreferredSize()));
            this2.add(remarks);
            remarks.setBounds(607, 372, 125, 30);

            //---- label30 ----
            label30.setText("\u8239\u8236\u76f8\u7247");
            label30.setFont(label30.getFont().deriveFont(label30.getFont().getSize() + 3f));
            this2.add(label30);
            label30.setBounds(new Rectangle(new Point(521, 412), label30.getPreferredSize()));
            this2.add(photo);
            photo.setBounds(607, 407, 125, 30);

            //---- button1 ----
            button1.setText("\u786e\u5b9a");
            button1.addActionListener(e -> confirmHandler(e));
            this2.add(button1);
            button1.setBounds(new Rectangle(new Point(340, 480), button1.getPreferredSize()));

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < this2.getComponentCount(); i++) {
                    Rectangle bounds = this2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = this2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                this2.setMinimumSize(preferredSize);
                this2.setPreferredSize(preferredSize);
            }
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel this2;
    private JPanel panel2;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JTextField ID;
    private JTextField phone;
    private JTextField onwer;
    private JTextField textField9;
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
    private JLabel buildDate;
    private JTextField bulidDate;
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
    private JLabel deadWeight;
    private JTextField shipName12;
    private JLabel label22;
    private JTextField navigationLimits;
    private JLabel label29;
    private JTextField remarks;
    private JLabel label30;
    private JTextField photo;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
