package Login;

import com.SQL;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Meredith
 * @CreateDate: 2018-11-16 20:36
 * @Project: ShipManageSystem
 * @Package: Login
 * @Description: 登陆后的主界面
 **/
public class Warning extends JFrame
{
    SQL db = new SQL();

    public static void main(String[] args)
    {
        Warning warning = new Warning();
        warning.initComponents();
        warning.setWarning();

    }

    public void setWarning()
    {
        //select那些未过期的证书
        db.sqlLines = "select 证书有效期至,船名,证书名 from 各证书有效期";
        db.pre();
        db.exeSelect();
        Calendar cal = Calendar.getInstance();
        //获取当前日期 并加一个月
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar nowCal=Calendar.getInstance();
        nowCal.getTime();
        nowCal.add(Calendar.MONTH,+1);
        String now = sdf.format(nowCal.getTime());

        Date date = null;
        String text = "                 Warning\n";
        {
            for (int j = 1; j < db.row; j++)//遍历行
            {
                //如果当前日期加1个月小于过期日
                    try
                    {
                        date = sdf.parse(db.result[1][j]);
                    } catch (ParseException e)
                    {
                        e.printStackTrace();
                    }
                    cal.setTime(date);
                    String dbDate = sdf.format(cal.getTime());
                    if (now.compareTo(dbDate) <= 0)
                    {
                        text += "船只 [" + db.result[2][j] + "] 的证书 [" + db.result[3][j] + "] 将于一个月内过期\n";
                    }

            }
        }
        textPane1.setText(text);
    }

    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- textPane1 ----
            textPane1.setEditable(false);
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(485, 305, 190, 75);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++)
            {
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
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
