package new01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.jsu.zjy.dbc.Data;
import cn.edu.jsu.zjy.dbc.DatabaseConnection;

public class DataOperate {
	
	//ɾ�����
	 public static  void getDelete(String sql){
	    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement

	    		pstmt.executeUpdate();//ִ����䣬����ŵ����ݼ���
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	 //������������� ��ӹ���
	 public static void add(String accnu) {	
	    	DatabaseConnection dbcs=new DatabaseConnection();
	    	String sql="insert into Scj(num) values(?)";
	    	try (Connection conn=dbcs.getConnection();
	    		PreparedStatement pstmt=conn.prepareStatement(sql);
	    		){
	    		
	    		String num=Data.getChineseName();

				pstmt.setString(1, num);//�����1��ռλ��������

	    		}
			 catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	 
	 //ס������ѧ�� ��ӹ���
	 public static void add01(String accnu) {
	    	DatabaseConnection dbcs=new DatabaseConnection();
	    	String sql="insert into Scj(xh,xm,xb,yuanxi,num) values(?,?,?,?,?)";
	    	try (Connection conn=dbcs.getConnection();
	    		PreparedStatement pstmt=conn.prepareStatement(sql);
	    		){
	    		String xh=Data.getChineseName();
	    		String xm=Data.getChineseName();
	    		String xb=Data.getChineseName();
	    		String yuanxi=Data.getChineseName();
	    		String num=Data.getChineseName();

				pstmt.setString(1, xh);//�����1��ռλ��������
				pstmt.setString(2, xm);
				pstmt.setString(3, xb);
				pstmt.setString(4, yuanxi);
				pstmt.setString(5, num);
	    		}
			 catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	 
	 // �� ѧ���û��� ����5��
	public static Vector<Vector> getSelectAll(String sql){
		Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
		DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
		try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
 		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
 		ResultSet rs=pstmt.executeQuery();	//ִ����䣬����ŵ����ݼ���
 		while(rs.next()) {//�������ݼ�
 			Vector row=new Vector();//����������
 			row.add(rs.getString(1));//��ȡ��һ���ֶ�
 			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
 			row.add(rs.getString(3));//��ȡ�������ֶ�
 			row.add(rs.getString(4));
 			row.add(rs.getString(5));

 			rows.add(row);//����������ӵ���¼������
 		}
 	}catch(SQLException e) {
 		e.printStackTrace();
 	}
			return rows;//��������������
 }
 
	//�� ����3�� 
    public static Vector<Vector> getSelectAll01(String sql){ 
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
    			row.add(rs.getString(3));//��ȡ�������ֶ�
    			row.add(rs.getString(4));
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//��������������
    }
    
    //�� ����1��
    public static Vector<Vector> getSelectAll02(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
    			
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//��������������
    }
	//�� ɾ  ����3�� 
    public static void getSelectAll03(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		pstmt.executeUpdate();//ִ����䣬����ŵ����ݼ���

    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
  
    public static void add1(String accnu) {
    	DatabaseConnection dbcs=new DatabaseConnection();
    	String sql="insert into Scj(num) values(?)";
    	try (Connection conn=dbcs.getConnection();
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		){
    		String xh=Data.getChineseName();
		
			pstmt.setString(1, accnu);//�����1��ռλ��������
    		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
