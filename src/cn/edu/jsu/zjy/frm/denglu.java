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
		JFrame f=new JFrame("��¼");
		f.getContentPane().setLayout(null);//���Զ�λ
		Container cont=f.getContentPane();//��������
		f.setSize(500, 447);
		
		JLabel lab1=new JLabel("\u8D26    \u53F7");//��ǩ
		lab1.setBounds(27, 81, 123, 29);
		f.getContentPane().add(lab1);
		JTextField textField = new JTextField();//�˺��ı���
		textField.setBounds(175, 82, 164, 27);
		f.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lab2=new JLabel("��    ��");//��ǩ
		lab2.setBounds(27, 150, 123, 29);
		f.getContentPane().add(lab2);
		JTextField textField1 = new JTextField();//�˺��ı���
		textField1.setBounds(175, 151, 164, 27);
		f.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		
		JComboBox jcb=null;	//�����б��
		String nations[]= {"ѧ��","����Ա"};
		
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
		
		f.setVisible(true);	//��ʾ����
		f.addWindowListener(new WindowAdapter() {//����ʱ�����
			public void windowClosing(WindowEvent arg0) {//��д���ڹر�
				System.exit(1);
			}
		});
	}
 }
