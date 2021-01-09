package cn.edu.jsu.zjy.frm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

 public class denglu {
 
 public static void main(String[] args) {

 // TODO Auto-generated method stub

	 deng();

 }

 public static  void deng(){
		JFrame f=new JFrame("登录");
		f.getContentPane().setLayout(null);//绝对定位
		Container cont=f.getContentPane();//窗体容器
		f.setSize(500, 447);
		
		JLabel lab1=new JLabel("\u8D26    \u53F7");//标签
		lab1.setBounds(27, 81, 123, 29);
		f.getContentPane().add(lab1);
		JTextField textField = new JTextField();//账号文本框
		textField.setBounds(175, 82, 164, 27);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lab2=new JLabel("密    码");//标签
		lab2.setBounds(27, 150, 123, 29);
		f.getContentPane().add(lab2);
		JTextField textField1 = new JTextField();//账号文本框
		textField1.setBounds(175, 151, 164, 27);
		f.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		
		JComboBox jcb=null;	//下拉列表框
		String nations[]= {"学生","管理员"};
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Primarymenu();
			}
		});
		btnNewButton.setBounds(148, 246, 123, 29);
		f.getContentPane().add(btnNewButton);
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBounds(286, 137, 41, 27);
//		f.getContentPane().add(comboBox);
		
		f.setVisible(true);	//显示窗体
		f.addWindowListener(new WindowAdapter() {//加入时间监听
			public void windowClosing(WindowEvent arg0) {//覆写窗口关闭
				System.exit(1);
			}
		});
	}
 }
