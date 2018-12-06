package DataQueryAndReportProcessing;

import com.SQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//import java.util.Vector;

/**
*
* 项目名称：Ship
* 类名称：PaymentSituation
* 类描述：   缴费情况
* 创建人：月明星稀
* 创建时间：2018年12月4日 下午4:41:18
* @version
*/
public class PaymentSituation extends JFrame {
	private JTextField textField;
	private JTable table = new JTable();;

	/**
	 * Create the frame.
	 */
	public PaymentSituation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("船只名称:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 81, 78, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("船只的缴费情况查询");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(39, 39, 153, 37);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("费用名:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 122, 53, 31);
		getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(83, 86, 125, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(83, 127, 125, 21);
		getContentPane().add(comboBox);
		comboBox.addItem("航道费用");
		comboBox.addItem("水运费用");

		JButton btnNewButton = new JButton("查询缴费情况");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String tablename = null;
				SQL db = new SQL();
				// Vector columnNames = new Vector();
				/**
				 * @description: 船只缴费情况纪录表
				 * @param [e]
				 * @return void
				 * @date: 2018/11/15 20:21
				 */
				if (((String) comboBox.getSelectedItem()).equals("航道费用")) {
					tablename = "航道费纪录表";
				} else {
					tablename = "水运费纪录表";
				}
				db.sqlLines = "declare @tablename varchar(20)\r\n" + "declare @sql nvarchar(2000)\r\n"
						+ "declare @fname NVARCHAR(20)\r\n" + "set @tablename=?\r\n" + "set @fname = ?\r\n"
						+ "set @sql=N'select * from ' +@tablename+ ' where 船名=' +@fname\r\n" + "EXEC (@sql)";
				db.pre();
				try {
					db.preparedStatement.setString(1, tablename);
					db.preparedStatement.setString(2, textField.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				db.exeSelect();
				db.toTable(db, table);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(49, 167, 135, 23);
		getContentPane().add(btnNewButton);

		JScrollPane scrollPane1 = new JScrollPane();
		{
			// ---- table ----
			table.setModel(
					new DefaultTableModel(new Object[][] {}, new String[] { null, null, null, null, null, null }));
			scrollPane1.setViewportView(table);
		}
		getContentPane().add(scrollPane1);
		scrollPane1.setBounds(231, 0, 966, 233);

		JButton button = new JButton("查询历史情况");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablename = null;
				SQL db = new SQL();
				// Vector columnNames = new Vector();
				/**
				 * @description: 船只缴费情况历史表
				 * @param [e]
				 * @return void
				 * @date: 2018/11/15 20:21
				 */
				if (((String) comboBox.getSelectedItem()).equals("航道费用")) {
					tablename = "航道费历史表";
				} else {
					tablename = "水运费历史表";
				}
				db.sqlLines = "declare @tablename varchar(20)\r\n" + "declare @sql nvarchar(2000)\r\n"
						+ "declare @fname NVARCHAR(20)\r\n" + "set @tablename=?\r\n" + "set @fname = ?\r\n"
						+ "set @sql=N'select * from ' +@tablename+ ' where 船名=' +@fname\r\n" + "EXEC (@sql)";
				db.pre();
				try {
					db.preparedStatement.setString(1, tablename);
					db.preparedStatement.setString(2, textField.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				db.exeSelect();
				db.toTable(db, table);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBounds(49, 210, 135, 23);
		getContentPane().add(button);
	}
}
