package cn.edu.jsu.zjy.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

//��ͬ������
//public class ConnectData{
	/**
     * ȡ��ָ��sql��ѯ���ļ�¼
     * @param sql ��ѯ���
     * @return ��ѯ���Ľ����������ΪVectorǶ�׼��ϣ��������DefaultTableModel����ģ��
     */
    

//    public static Vector<Vector> getSelectAll2(String sql){
//    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
//    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
//    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
//    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
//    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
//    		while(rs.next()) {//�������ݼ�
//    			Vector row=new Vector();//����������
//    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
//    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
//    			row.add(rs.getString(3));//��ȡ�������ֶ�
//    			row.add(rs.getString(4));
//    			rows.add(row);//����������ӵ���¼������
//    		}
//    	}catch(SQLException e) {
//    		e.printStackTrace();
//    	}
//			return rows;//��������������
//    }
//    
//    public static Vector<Vector> getSelectAll3(String sql){
//    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
//    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
//    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
//    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
//    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
//    		while(rs.next()) {//�������ݼ�
//    			Vector row=new Vector();//����������
//    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
//    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
//    			row.add(rs.getString(3));//��ȡ�������ֶ�
//    			rows.add(row);//����������ӵ���¼������
//    		}
//    	}catch(SQLException e) {
//    		e.printStackTrace();
//    	}
//			return rows;//��������������
//    }
//    
//    public static Vector<Vector> getSelectAll4(String sql){
//    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
//    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
//    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
//    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
//    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
//    		while(rs.next()) {//�������ݼ�
//    			Vector row=new Vector();//����������
//    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
//    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
//    			row.add(rs.getString(3));//��ȡ�������ֶ�
//    			rows.add(row);//����������ӵ���¼������
//    		}
//    	}catch(SQLException e) {
//    		e.printStackTrace();
//    	}
//			return rows;//��������������
//    }

//    public static  void getDelete(String sql){
//    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
//    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
//    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
//
//    		pstmt.executeUpdate();//ִ����䣬����ŵ����ݼ���
//    	}catch(SQLException e) {
//    		e.printStackTrace();
//    	}
//    }

//    public static boolean checkPass(String sql,String pass) {//��������Ƿ�ƥ��
//    	int i=0;
//    	DatabaseConnection dbcs=new DatabaseConnection();
//    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
//        		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
//        		ResultSet rs=pstmt.executeQuery();
//        while(rs.next()) {		if(rs.getString(2).equals(pass)) {
//        			i=1;
//        		}else {
//					i=0;
//				}}
//    	}catch (Exception e) {
//    		e.printStackTrace();
//    	}
//    	if(i==1) {
//    		return true;
//    	}else {
//			return false;
//		}
//	}

//    public static void add(String accnu) {
//    	DatabaseConnection dbcs=new DatabaseConnection();
//    	String sql="insert into Scj(num) values(?)";
//    	try (Connection conn=dbcs.getConnection();
//    		PreparedStatement pstmt=conn.prepareStatement(sql);
//    		){
//    		//String xm=Customer.getChineseName();//�����ȡ����
//    		String xm=DataOperate.getChineseName();
////			String xb=DataOperate.getSex();
////			String dz=DataOperate.getProCity();
////			String dh=DataOperate.getMobile();
//			pstmt.setString(1, accnu);//�����1��ռλ��������
////    		pstmt.setString(2, xm);//�����2��ռλ��������
////    		pstmt.setString(3, xb);//�����3��ռλ��������
////    		pstmt.setString(4, dz);//�����4��ռλ��������
////    		pstmt.setString(5, dh);
////    		pstmt.executeUpdate();
//    		}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//    public static void add2(int pronu) {
//    	DatabaseConnection dbcs=new DatabaseConnection();
//    	String sql="insert into pro(pronum,proname,prosum,proprice) values(?,?,?,?)";
//    	try (Connection conn=dbcs.getConnection();
//    		PreparedStatement pstmt=conn.prepareStatement(sql);
//    		){
//    		String cm=Product.getProname();
//			int sum=Product.getProsum();
//			int pri=Product.getPrice();
//			pstmt.setInt(1, pronu);
//			pstmt.setString(2, cm);
//			pstmt.setInt(3, sum);
//			pstmt.setInt(4, pri);
//    		pstmt.executeUpdate();
//    		}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//    public static void add3(int odrnu) {
//    	DatabaseConnection dbcs=new DatabaseConnection();
//    	String sql="insert into order01(ordernum,accnum,pronum) values(?,?,?)";
//    	try (Connection conn=dbcs.getConnection();
//    		PreparedStatement pstmt=conn.prepareStatement(sql);
//    		){
//    		String ac=Customer.getAccnum();
//			int num=Product.getPronum();
//			pstmt.setInt(1, odrnu);//�����1��ռλ��������
//    		pstmt.setString(2, ac);//�����2��ռλ��������
//    		pstmt.setInt(3, num);//�����3��ռλ��������
//    		pstmt.executeUpdate();
//    		}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//    public static void add4(String userr,String passw) {
//    	DatabaseConnection dbcs=new DatabaseConnection();
//    	String sql="insert into uer01(accnum,password,ordernum) values(?,?,?)";
//    	String sql2="select * from user01 where accnum='"+userr+"'";
//    	try (Connection conn=dbcs.getConnection();
//    		PreparedStatement pstmt=conn.prepareStatement(sql);
//    			PreparedStatement pstmt2=conn.prepareStatement(sql2);
//    		){
//    		int ordern=pstmt2.
//			pstmt.setString(1, userr);//�����1��ռλ��������
//    		pstmt.setString(2, passw);//�����2��ռλ��������
//    		pstmt.setInt(3,ordern);
//    		pstmt.executeUpdate();
//    		}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//}