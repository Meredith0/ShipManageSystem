package DataQueryAndReportProcessing;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import com.SQL;

/**   
*    
* 项目名称：Ship   
* 类名称：VesselRelatedInformation   
* 类描述：   船只关联资料
* 创建人：月明星稀   
* 创建时间：2018年12月4日 下午4:38:35   
* @version        
*/
public class VesselRelatedInformation extends JFrame {
	private JTable table = new JTable();
	private JTextField textField_1;;

	/**
	 * Create the frame.
	 */
	public VesselRelatedInformation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("船只关联资料查询");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(39, 39, 139, 37);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("船只名:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 93, 53, 31);
		getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SQL db = new SQL();
				Vector columnNames = new Vector();
				/**
				 * @description: 各船只证书有效期查询
				 * @param [e]
				 * @return void
				 * @date: 2018/11/15 20:21
				 */
				db.sqlLines = "select *\r\n" + "from 船舶所有权登记证书\r\n" + "where 船名=? ";
				db.pre();
				try {
					db.preparedStatement.setString(1, textField_1.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				db.exeSelect();
				db.toTable(db, table);
			}

		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(59, 144, 93, 23);
		getContentPane().add(btnNewButton);

		JScrollPane scrollPane1 = new JScrollPane();
		{
			// ---- table ----
			table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { null, null, null, null, null, null,
					null, null, null, null, null, null, null, null, null, null, null, null, null }));
			scrollPane1.setViewportView(table);
		}
		getContentPane().add(scrollPane1);
		scrollPane1.setBounds(260, 8, 1315, 190);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(73, 98, 125, 21);
		getContentPane().add(textField_1);
		
		JButton button = new JButton("打印");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(59, 175, 93, 23);
		getContentPane().add(button);
	}
}
