package cn.edu.jsu.zjy.dbc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
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

import new01.DataOperate;
import new01.PageController;
//import cn.edu.jsu.zjy.dbc;
//��ť�Ĺ���
public class CustomerInfo extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
	private Vector<String> titles;
	private JTextField textField;

	/**
	 * ���幹�췽���������弰���.
	 */
	public CustomerInfo() {
		setLocationRelativeTo(null);// �������
		setVisible(true);// ����ɼ�
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerInfo.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 810, 763);// ���ô���λ�����С
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 140, 693, 493);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "xh", "xm", "xb","yuanxi","num");
		Vector<Vector> stuInfo = new PageController().getPaegData();//��ȡ��һҳ������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setAutoCreateRowSorter(true);;//���ñ���Զ�����

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		JLabel lblKey = new JLabel("Key words:");
		lblKey.setBounds(44, 31, 191, 36);
		contentPane.add(lblKey);
		

		
//		��һҳ��ť
		JButton btnPre = new JButton("��һҳ");
		btnPre.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
				
			}
		});
		btnPre.setBounds(44, 648, 169, 25);
		contentPane.add(btnPre);
		
//		��һҳ��ť
		JButton btnNext = new JButton("��һҳ");
		btnNext.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		btnNext.setBounds(228, 648, 169, 25);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("Display on each page:");
		lblMsg.setBounds(474, 648, 210, 25);
		contentPane.add(lblMsg);

		//������
		JComboBox comboBox = new JComboBox(new Integer[] {10,20,50,100,150,200});
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				PageController pcl=new PageController();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
				model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ��
				table.setModel(model);//���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
		comboBox.setBounds(672, 649, 55, 23);
		contentPane.add(comboBox);
		
//		ɾ����ť
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(228, 83, 137, 42);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//������
				String sqlLookString="delete from root where accnum='"+textField.getText().trim()+"'\r\n" + 
						"delete from scj where accnum='"+textField.getText().trim()+"'";
				String sqlLookString2="select * from scj where accnum like'"+textField.getText().trim()+"%'";
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
		contentPane.add(btnDelete);
		
//		���Ұ�ť
		JButton btnFind_1_1 = new JButton("LOOKUP");
		btnFind_1_1.setBounds(412, 83, 145, 41);
		btnFind_1_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {//������
				String sqlLookString="select * from cus where accnum like'"+textField.getText().trim()+"%'";
				PageController pcl=new PageController(sqlLookString);
				model=new DefaultTableModel(pcl.getPaegData(),titles);
				table.setModel(model);
				if(!pcl.setInsert(sqlLookString)) {
					JOptionPane.showMessageDialog(null, "Null Values!");
				}
			}
		});
		contentPane.add(btnFind_1_1);
		
		//���°�ť???
		JButton btnFind_1_2 = new JButton("UPDATE");
		btnFind_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//������
				String sqlLookString="select * from Scj where accnum like'"+textField.getText().trim()+"%'";
				String sqlLookString2="delete from root where accnum='"+textField.getText().trim()+"'\r\n" + 
						"delete from Scj where accnum='"+textField.getText().trim()+"'";
				PageController pcl=new PageController();
				if(pcl.setInsert(sqlLookString)) {
					PageController pcl2=new PageController();
					pcl2.dataDelete(sqlLookString2);
					DataOperate.add(textField.getText().trim());
					JOptionPane.showMessageDialog(null,"Update Success!");
				}else {
						JOptionPane.showMessageDialog(null, "Null Values!");
					}
			}
		});
		btnFind_1_2.setBounds(597, 83, 140, 42);
		contentPane.add(btnFind_1_2);
		
		textField = new JTextField();
		textField.setBounds(147, 31, 590, 36);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
