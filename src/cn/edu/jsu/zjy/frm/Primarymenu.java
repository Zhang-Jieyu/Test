package cn.edu.jsu.zjy.frm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

 public class  Primarymenu{
 public static void main(String[] args) { 

 // TODO Auto-generated method stub

 new Primarymenu();

 }

 public Primarymenu() {

 JFrame f=new JFrame("����");
 f.setTitle("\u4E3B\u754C\u9762");//������

 f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE );

 f.setSize(600,400);

 f.setLocationRelativeTo(null);

 f.getContentPane().setLayout(null);
 
 JMenuBar menuBar = new JMenuBar();//�˵���
 menuBar.setBounds(0, 0, 578, 31);
 f.getContentPane().add(menuBar);
 
 JMenu mnNewMenu = new JMenu("�������");//�������
 mnNewMenu.setBackground(Color.LIGHT_GRAY);
 menuBar.add(mnNewMenu);
 
 JMenuItem mntmNewMenuItem = new JMenuItem("ɾ��������Ϣ");//������Ϣɾ��
 mntmNewMenuItem.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new RoomDelete();
 	}
 });
 mnNewMenu.add(mntmNewMenuItem);
 
 JMenuItem mntmNewMenuItem_1 = new JMenuItem("��ӷ�����Ϣ");//������Ϣ����
 mntmNewMenuItem_1.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new RoomAdd();
 	}
 });
 mnNewMenu.add(mntmNewMenuItem_1);
 
 JMenu mnNewMenu_1 = new JMenu("ѧ����Ϣ����");//ѧ����Ϣ
 menuBar.add(mnNewMenu_1);
 
 JMenuItem mntmNewMenuItem_3 = new JMenuItem("ѧ����Ϣɾ��");//ɾ��ѧ����Ϣ
 mntmNewMenuItem_3.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new StudentDelete();
 	}
 });
 mnNewMenu_1.add(mntmNewMenuItem_3);
 
 JMenuItem mntmNewMenuItem_2 = new JMenuItem("ѧ����Ϣ�޸�");//����ѧ����Ϣ
 mntmNewMenuItem_2.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new StudentCorrect();
 	}
 });
 mnNewMenu_1.add(mntmNewMenuItem_2);
 
 JMenu mnNewMenu_2 = new JMenu("ס�޹���");//ס�޹���
 menuBar.add(mnNewMenu_2);
 
 JMenuItem mntmNewMenuItem_6 = new JMenuItem("����ס����Ϣ");
 mntmNewMenuItem_6.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new AccommodationAdd();
 	}
 });
 mnNewMenu_2.add(mntmNewMenuItem_6);
 
 JMenu mnNewMenu_3 = new JMenu("��Ϣ��ѯ");//��Ϣ��ѯ
 menuBar.add(mnNewMenu_3);
 
 JMenuItem mntmNewMenuItem_4 = new JMenuItem("��Ա��Ϣ��ѯ");
 mntmNewMenuItem_4.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new InformationSearch();
 	}
 });
 mnNewMenu_3.add(mntmNewMenuItem_4);
 
 JMenuItem mntmNewMenuItem_5 = new JMenuItem("������Ϣ��ѯ");
 mntmNewMenuItem_5.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new RoomInformationSearch();
 	}
 });
 mnNewMenu_3.add(mntmNewMenuItem_5);
 
 JMenu mnNewMenu_4 = new JMenu("����");
 menuBar.add(mnNewMenu_4);

 f.setVisible(true);

 }
 }


