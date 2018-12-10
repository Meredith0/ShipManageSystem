package DataQueryAndReportProcessing;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.SQLException;
//import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import com.SQL;

/**   
*    
* 项目名称：Ship   
* 类名称：CertificateInquiry   
* 类描述：   证书查询
* 创建人：月明星稀   
* 创建时间：2018年12月4日 下午4:41:39   
* @version        
*/
public class CertificateInquiry extends JFrame {
	private JTextField textField;
	private JTable table = new JTable();;

	/**
	 * Create the frame.
	 */
	public CertificateInquiry() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("船只名称:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 81, 78, 31);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("船只各类证书查询");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(39, 39, 139, 37);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("证书名:");
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
		comboBox.addItem("船舶国籍证书");
		comboBox.addItem("船只安检证书");
		comboBox.addItem("船只检验证书");
		comboBox.addItem("船只营运证书");

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SQL db = new SQL();
				// Vector columnNames = new Vector();
				/**
				 * @description: 各类证书查询
				 * @param [e]
				 * @return void
				 * @date: 2018/11/15 20:21
				 */
				db.sqlLines = "declare @tablename varchar(20)\r\n" + "declare @sql nvarchar(2000)\r\n"

						+ "declare @fname NVARCHAR(20)\r\n" + "set @tablename=?\r\n" + "set @fname = ?\r\n"

						+ "set @sql=N'select * from ' +@tablename+ ' where 船名=' +@fname\r\n" + "EXEC (@sql)";
				db.pre();
				try {
					db.preparedStatement.setString(1, (String) comboBox.getSelectedItem());
					db.preparedStatement.setString(2, textField.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				db.exeSelect();
				db.toTable(db, table);
			}

		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(56, 175, 93, 23);
		getContentPane().add(btnNewButton);

		JScrollPane scrollPane1 = new JScrollPane();
		{
			// ---- table ----
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { null, null, null, null, null, null, null, null, null, null, null, null }));
			scrollPane1.setViewportView(table);
		}
		getContentPane().add(scrollPane1);
		scrollPane1.setBounds(218, 0, 979, 190);
		
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
		button.setBounds(56, 213, 93, 23);
		getContentPane().add(button);
	}
}
