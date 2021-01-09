
	package cn.edu.jsu.zjy.frm;

	import javax.swing.JFrame;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import new01.DataOperate;

import java.awt.Font;

	public class AccommodationAdd extends JFrame{
		private JTextField textField_1;
		private JTextField textField;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		public AccommodationAdd() { 
			setTitle("\u589E\u52A0\u5BDD\u5BA4\u53F7");
			getContentPane().setLayout(null);
			
			textField_1 = new JTextField();//学号
			textField_1.setBounds(82, 15, 96, 27);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
			

			JLabel lblNewLabel_1 = new JLabel("学号");
			lblNewLabel_1.setBounds(15, 18, 81, 21);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("姓名");
			lblNewLabel_2.setBounds(213, 18, 81, 21);
			getContentPane().add(lblNewLabel_2);
			
			textField = new JTextField();//姓名
			textField.setColumns(10);
			textField.setBounds(265, 15, 96, 27);
			getContentPane().add(textField);
			
			JLabel lblNewLabel = new JLabel("性别");
			lblNewLabel.setBounds(15, 57, 81, 21);
			getContentPane().add(lblNewLabel);
			
			textField_2 = new JTextField();//性别
			textField_2.setColumns(10);
			textField_2.setBounds(82, 57, 96, 27);
			getContentPane().add(textField_2);
			
			JLabel lblNewLabel_3 = new JLabel("院系");
			lblNewLabel_3.setBounds(213, 57, 81, 21);
			getContentPane().add(lblNewLabel_3);
			
			textField_3 = new JTextField();//院系
			textField_3.setColumns(10);
			textField_3.setBounds(265, 60, 96, 27);
			getContentPane().add(textField_3);
			
			JLabel lblNewLabel_4 = new JLabel("宿舍号");
			lblNewLabel_4.setBounds(15, 110, 81, 21);
			getContentPane().add(lblNewLabel_4);
			
			textField_4 = new JTextField();//宿舍号
			textField_4.setColumns(10);
			textField_4.setBounds(82, 107, 96, 27);
			getContentPane().add(textField_4);
			
			JButton btnNewButton = new JButton("添加");
			btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String add1=textField_1.getText();//学号
					String add2=textField.getText();//姓名
					String add3=textField_2.getText();//性别
					String add4=textField_3.getText();//院系
					String add5=textField_4.getText();//宿舍

					new DataOperate().getSelectAll03("insert into "
							+ "Scj(xh,xm,xb,yaunxi,num) values(add1,add2,add3,add4,add5)");
					
				}
			});
			btnNewButton.setBounds(159, 181, 88, 48);
			getContentPane().add(btnNewButton);
			
			
		}
		
	}


