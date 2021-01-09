package cn.edu.jsu.zjy.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
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

import cn.edu.jsu.zjy.dbc.DatabaseConnection;
import new01.PageController;


public class StudentDelete extends JFrame {
	
	private JTextField textField;
	private JPanel contentPane;
	 
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
	private Vector<String> titles;
	
	public StudentDelete() {
		
		JFrame f=new JFrame();
		f.setVisible(true);
		f.setBounds(400, 300, 500, 300);
		f.getContentPane().add(contentPane);
		
		setTitle("\u5220\u9664\u5B66\u751F\u4FE1\u606F");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("ɾ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlLookString="delete from Scj where xh='"+textField.getText().trim()+"'\r\n" +"'";
				String sqlLookString2="select * from scj where xh like'"+textField.getText().trim()+"%'";
				PageController pcl2=new PageController();
				if(pcl2.setInsert(sqlLookString2)) {
				PageController pcl=new PageController();
				pcl.dataDelete(sqlLookString);
				JOptionPane.showMessageDialog(null, "Deletion successful!");}
				else {
					JOptionPane.showMessageDialog(null, "Null Values!");
				}
				
			}
			
		});
		btnNewButton.setBounds(132, 236, 123, 29);
		getContentPane().add(btnNewButton);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 810, 763);// ���ô���λ�����С
		setLocationRelativeTo(null);// �������
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 140, 693, 493);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();	// ���嶯̬�����ʾ������
		Collections.addAll(titles, "xh", "xm", "num");
		Vector<Vector> stuInfo = new PageController().getPaegData();	//��ȡ��һҳ������

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
		
		JLabel lblKey = new JLabel("Key words:");
		lblKey.setBounds(44, 31, 191, 36);
		contentPane.add(lblKey);	
		
	}
}
