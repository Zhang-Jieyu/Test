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

public class RoomAdd extends JFrame{
	private JTextField textField;
	public RoomAdd() { 
		setTitle("\u589E\u52A0\u5BDD\u5BA4\u53F7");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5BBF\u820D\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("ËÎÌå", Font.BOLD, 24));
		lblNewLabel.setBounds(54, 56, 116, 42);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(238, 56, 116, 45);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ìí¼Ó");
		btnNewButton.setFont(new Font("ËÎÌå", Font.PLAIN, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String add1=textField.getText();
				new DataOperate().getSelectAll03("insert into "
						+ "Scj(num) values(add1)");

				JOptionPane.showMessageDialog(null, "Add successful!");
			}
		});
		btnNewButton.setBounds(132, 162, 123, 54);
		getContentPane().add(btnNewButton);
		
		
	}
	
}
