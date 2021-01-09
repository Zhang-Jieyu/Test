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
	 
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
	private Vector<String> titles;

	public StudentCorrect() {
		setTitle("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		getContentPane().setLayout(null);
		
		textField_1 = new JTextField();//ѧ��
		textField_1.setBounds(61, 15, 96, 27);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

		JLabel lblNewLabel_1 = new JLabel("ѧ��");
		lblNewLabel_1.setBounds(15, 15, 81, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("����");
		lblNewLabel_2.setBounds(172, 18, 81, 21);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();//����
		textField.setColumns(10);
		textField.setBounds(211, 15, 96, 27);
		getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("�Ա�");
		lblNewLabel.setBounds(322, 18, 81, 21);
		getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();//�Ա�
		textField_2.setColumns(10);
		textField_2.setBounds(363, 15, 96, 27);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ժϵ");
		lblNewLabel_3.setBounds(182, 54, 81, 21);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();//Ժϵ
		textField_3.setColumns(10);
		textField_3.setBounds(233, 54, 96, 27);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_4 = new JLabel("�����");
		lblNewLabel_4.setBounds(15, 57, 81, 21);
		getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();//�����
		textField_4.setColumns(10);
		textField_4.setBounds(71, 51, 96, 27);
		getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");//�޸�
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String add1=textField_1.getText();//ѧ��
				String add2=textField.getText();//����
				String add3=textField_2.getText();//�Ա�
				String add4=textField_3.getText();//Ժϵ
				String add5=textField_4.getText();//����

				String sql="update Scj set xh=add1 xm=add2 xb=add3 yuanxi=add4 num=add5";
				JOptionPane.showMessageDialog(null, "correct successful!");
			}
		});
		btnNewButton.setBounds(347, 54, 123, 29);
		getContentPane().add(btnNewButton);
		
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 140, 693, 493);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();	// ���嶯̬�����ʾ������
		Collections.addAll(titles, "xh", "xm", "num");
		Vector<Vector> stuInfo = new PageController03().getPaegData();	//��ȡ��һҳ������

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
