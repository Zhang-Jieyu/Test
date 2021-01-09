package cn.edu.jsu.zjy.frm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import new01.PageController01;

public class InformationSearch {
	private JPanel contentPane;
	 
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;
	private JTextField textField;
	private JTextField textField_1;
	
	public InformationSearch() {
		 contentPane=new JPanel() ;// 定义窗体内容面板，放置各组件
		JFrame f=new JFrame();
		f.setTitle("\u4FE1\u606F\u67E5\u8BE2");
		f.setVisible(true); 
		f.setBounds(400, 300, 500, 400);
		f.getContentPane().add(contentPane);
		
		JButton btn = new JButton("\u5B66\u53F7");//学号
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		btn.setBounds(25, 15, 78, 29);
		contentPane.add(btn);
		
		textField = new JTextField();//学号文本框
		textField.setBounds(116, 16, 109, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u59D3\u540D");//姓名
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(25, 55, 78, 29);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();//姓名文本框
		textField_1.setBounds(116, 58, 106, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");//查询
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select xh from Scj like"+textField.getText().trim()+"%'";
				PageController01 pel=new PageController01(sql);
				model=new DefaultTableModel(pel.getPaegData(),titles);
				table.setModel(model);
				
				if(pel!=null) {
					JOptionPane.showMessageDialog(null, "search successful!");
				}
				else {
					JOptionPane.showMessageDialog(null, "There have not information!");
				}
			}
		});
		btnNewButton_1.setBounds(293, 44, 123, 29);
		contentPane.add(btnNewButton_1);

//		table_2 = new JTable();
//		
//		contentPane.add(table_2);
					
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 设置窗体关闭按钮
//		setBounds(100, 100, 810, 763);// 设置窗体位置与大小
//		setLocationRelativeTo(null);// 窗体居中
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		//setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 140, 693, 493);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();	// 定义动态数组表示表格标题
		Collections.addAll(titles, "xh", "xm", "xb","yuanxi");
		Vector<Vector> stuInfo = new PageController01().getPaegData();	//获取第一页的数据

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
