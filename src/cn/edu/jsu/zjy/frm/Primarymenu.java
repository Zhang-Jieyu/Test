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

 JFrame f=new JFrame("标题");
 f.setTitle("\u4E3B\u754C\u9762");//主界面

 f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE );

 f.setSize(600,400);

 f.setLocationRelativeTo(null);

 f.getContentPane().setLayout(null);
 
 JMenuBar menuBar = new JMenuBar();//菜单行
 menuBar.setBounds(0, 0, 578, 31);
 f.getContentPane().add(menuBar);
 
 JMenu mnNewMenu = new JMenu("房间管理");//房间管理
 mnNewMenu.setBackground(Color.LIGHT_GRAY);
 menuBar.add(mnNewMenu);
 
 JMenuItem mntmNewMenuItem = new JMenuItem("删除房间信息");//房间信息删除
 mntmNewMenuItem.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new RoomDelete();
 	}
 });
 mnNewMenu.add(mntmNewMenuItem);
 
 JMenuItem mntmNewMenuItem_1 = new JMenuItem("添加房间信息");//房间信息增加
 mntmNewMenuItem_1.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new RoomAdd();
 	}
 });
 mnNewMenu.add(mntmNewMenuItem_1);
 
 JMenu mnNewMenu_1 = new JMenu("学生信息管理");//学生信息
 menuBar.add(mnNewMenu_1);
 
 JMenuItem mntmNewMenuItem_3 = new JMenuItem("学生信息删除");//删除学生信息
 mntmNewMenuItem_3.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new StudentDelete();
 	}
 });
 mnNewMenu_1.add(mntmNewMenuItem_3);
 
 JMenuItem mntmNewMenuItem_2 = new JMenuItem("学生信息修改");//增加学生信息
 mntmNewMenuItem_2.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new StudentCorrect();
 	}
 });
 mnNewMenu_1.add(mntmNewMenuItem_2);
 
 JMenu mnNewMenu_2 = new JMenu("住宿管理");//住宿管理
 menuBar.add(mnNewMenu_2);
 
 JMenuItem mntmNewMenuItem_6 = new JMenuItem("增加住宿信息");
 mntmNewMenuItem_6.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new AccommodationAdd();
 	}
 });
 mnNewMenu_2.add(mntmNewMenuItem_6);
 
 JMenu mnNewMenu_3 = new JMenu("信息查询");//信息查询
 menuBar.add(mnNewMenu_3);
 
 JMenuItem mntmNewMenuItem_4 = new JMenuItem("人员信息查询");
 mntmNewMenuItem_4.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new InformationSearch();
 	}
 });
 mnNewMenu_3.add(mntmNewMenuItem_4);
 
 JMenuItem mntmNewMenuItem_5 = new JMenuItem("宿舍信息查询");
 mntmNewMenuItem_5.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		new RoomInformationSearch();
 	}
 });
 mnNewMenu_3.add(mntmNewMenuItem_5);
 
 JMenu mnNewMenu_4 = new JMenu("帮助");
 menuBar.add(mnNewMenu_4);

 f.setVisible(true);

 }
 }


