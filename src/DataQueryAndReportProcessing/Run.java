package DataQueryAndReportProcessing;

import javax.swing.*;
import java.awt.*;

/**
*
* 项目名称：Ship
* 类名称：Run
* 类描述：
* 创建人：月明星稀
* 创建时间：2018年11月29日 上午8:08:33   X
* @version
*/
public class Run extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
