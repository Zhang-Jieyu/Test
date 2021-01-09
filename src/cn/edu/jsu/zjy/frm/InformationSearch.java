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
	 
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
	private Vector<String> titles;
	private JTextField textField;
	private JTextField textField_1;
	
	public InformationSearch() {
		 contentPane=new JPanel() ;// ���崰��������壬���ø����
		JFrame f=new JFrame();
		f.setTitle("\u4FE1\u606F\u67E5\u8BE2");
		f.setVisible(true); 
		f.setBounds(400, 300, 500, 400);
		f.getContentPane().add(contentPane);
		
		JButton btn = new JButton("\u5B66\u53F7");//ѧ��
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		btn.setBounds(25, 15, 78, 29);
		contentPane.add(btn);
		
		textField = new JTextField();//ѧ���ı���
		textField.setBounds(116, 16, 109, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u59D3\u540D");//����
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(25, 55, 78, 29);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();//�����ı���
		textField_1.setBounds(116, 58, 106, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");//��ѯ
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
					
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// ���ô���رհ�ť
//		setBounds(100, 100, 810, 763);// ���ô���λ�����С
//		setLocationRelativeTo(null);// �������
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		//setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 140, 693, 493);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();	// ���嶯̬�����ʾ������
		Collections.addAll(titles, "xh", "xm", "xb","yuanxi");
		Vector<Vector> stuInfo = new PageController01().getPaegData();	//��ȡ��һҳ������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {	// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {	//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);	// ʹ��DefaultTableModel����ģ��ʵ�������
		sorter = new TableRowSorter<DefaultTableModel>(model);	//����������
		table.setAutoCreateRowSorter(true);	//���ñ���Զ�����

		scrollPane.setViewportView(table);	// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ

		
		
	}
}
