package cn.edu.jsu.zjy.frm;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import new01.PageController03;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class StudentCorrect extends JFrame {
	
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private JPanel contentPane;
	 
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;

	public StudentCorrect() {
		setTitle("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		getContentPane().setLayout(null);
		
		textField_1 = new JTextField();//学号
		textField_1.setBounds(61, 15, 96, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

		JLabel lblNewLabel_1 = new JLabel("学号");
		lblNewLabel_1.setBounds(15, 15, 81, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setBounds(172, 18, 81, 21);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();//姓名
		textField.setColumns(10);
		textField.setBounds(211, 15, 96, 27);
		getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("性别");
		lblNewLabel.setBounds(322, 18, 81, 21);
		getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();//性别
		textField_2.setColumns(10);
		textField_2.setBounds(363, 15, 96, 27);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("院系");
		lblNewLabel_3.setBounds(182, 54, 81, 21);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();//院系
		textField_3.setColumns(10);
		textField_3.setBounds(233, 54, 96, 27);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("宿舍号");
		lblNewLabel_4.setBounds(15, 57, 81, 21);
		getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();//宿舍号
		textField_4.setColumns(10);
		textField_4.setBounds(71, 51, 96, 27);
		getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");//修改
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String add1=textField_1.getText();//学号
				String add2=textField.getText();//姓名
				String add3=textField_2.getText();//性别
				String add4=textField_3.getText();//院系
				String add5=textField_4.getText();//宿舍

				String sql="update Scj set xh=add1 xm=add2 xb=add3 yuanxi=add4 num=add5";
				JOptionPane.showMessageDialog(null, "correct successful!");
			}
		});
		btnNewButton.setBounds(347, 54, 123, 29);
		getContentPane().add(btnNewButton);
		
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 140, 693, 493);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();	// 定义动态数组表示表格标题
		Collections.addAll(titles, "xh", "xm", "num");
		Vector<Vector> stuInfo = new PageController03().getPaegData();	//获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {	// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {	//获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);	// 使用DefaultTableModel数据模型实例化表格
		sorter = new TableRowSorter<DefaultTableModel>(model);	//设置排序器
		table.setAutoCreateRowSorter(true);	//设置表格自动排序

		scrollPane.setViewportView(table);	// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示

		
	}
}
