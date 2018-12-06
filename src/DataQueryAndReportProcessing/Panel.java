/*
 * Created by JFormDesigner on Fri Nov 16 15:35:47 CST 2018
 */

package DataQueryAndReportProcessing;

import Login.MainPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import test1.CertificateInquiry;
//import test1.CertificateValidityPeriod;
//import test1.PaymentSituation;

/**
 *
 * 项目名称：Ship 类名称：Panel 类描述： 创建人：月明星稀 创建时间：2018年12月4日 下午12:52:39
 *
 * @version
 */
public class Panel extends JFrame {
	public Panel() {
		initComponents();
	}

	// private void button1ActionPerformed(ActionEvent e) {
	//// CertificateInquiry frame = new CertificateInquiry();
	//// frame.setBounds(0, 50, 1200, 400);
	//// frame.setVisible(true);
	// //new AddData();
	// }
	//
	// private void button3ActionPerformed(ActionEvent e) {
	// // new SelectAndModifyData();
	// }
	//
	// private void button2ActionPerformed(ActionEvent e) {
	// //new DeleteData();
	// }
	//
	// private void returnUpperPanelHandler(ActionEvent e) {
	// // TODO 杩斿洖涓婁竴灞傝彍鍗�
	// }

	private void initComponents() {
		/**
		 * Create the frame.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D44\u6599\u67E5\u8BE2\u4E0E\u62A5\u8868\u5904\u7406\u6A21\u5757");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 19));
		lblNewLabel.setBounds(125, 10, 222, 34);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("\u8BC1\u4E66\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CertificateInquiry frame = new CertificateInquiry();
							frame.setBounds(0, 50, 1200, 400);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(87, 73, 135, 39);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u7F34\u8D39\u60C5\u51B5");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PaymentSituation frame = new PaymentSituation();
							frame.setBounds(0, 50, 1200, 400);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(249, 73, 135, 39);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u8BC1\u4E66\u6709\u6548\u671F");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CertificateValidityPeriod frame = new CertificateValidityPeriod();
							frame.setBounds(0, 50, 660, 300);
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_2.setBounds(87, 124, 135, 39);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u8239\u53EA\u5173\u8054\u8D44\u6599");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VesselRelatedInformation frame = new VesselRelatedInformation();
							frame.setLocationRelativeTo(null);
							frame.setBounds(0, 50, 1600, 300);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_3.setBounds(249, 124, 135, 39);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainPanel();
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_4.setBounds(177, 173, 135, 39);
		contentPane.add(btnNewButton_4);
	}

	private JPanel contentPane;
	// // JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// private JLabel label1;
	// private JButton button1;
	// private JButton button3;
	// private JButton button2;
	// private JButton button4;
	// // JFormDesigner - End of variables declaration //GEN-END:variables
}
