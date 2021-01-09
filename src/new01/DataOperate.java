package new01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.jsu.zjy.dbc.Data;
import cn.edu.jsu.zjy.dbc.DatabaseConnection;

public class DataOperate {
	
	//删除语句
	 public static  void getDelete(String sql){
	    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement

	    		pstmt.executeUpdate();//执行语句，结果放到数据集中
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	 //房间增加宿舍号 添加功能
	 public static void add(String accnu) {	
	    	DatabaseConnection dbcs=new DatabaseConnection();
	    	String sql="insert into Scj(num) values(?)";
	    	try (Connection conn=dbcs.getConnection();
	    		PreparedStatement pstmt=conn.prepareStatement(sql);
	    		){
	    		
	    		String num=Data.getChineseName();

				pstmt.setString(1, num);//定义第1个占位符的内容

	    		}
			 catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	 
	 //住宿增加学生 添加功能
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

				pstmt.setString(1, xh);//定义第1个占位符的内容
				pstmt.setString(2, xm);
				pstmt.setString(3, xb);
				pstmt.setString(4, yuanxi);
				pstmt.setString(5, num);
	    		}
			 catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	 
	 // 查 学生用户端 返回5列
	public static Vector<Vector> getSelectAll(String sql){
		Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
		DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
		try(Connection conn=dbcs.getConnection();//获取数据库接
 		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
 		ResultSet rs=pstmt.executeQuery();	//执行语句，结果放到数据集中
 		while(rs.next()) {//遍历数据集
 			Vector row=new Vector();//定义行数据
 			row.add(rs.getString(1));//获取第一个字段
 			row.add(rs.getString(2));//获取第二个字段
 			row.add(rs.getString(3));//获取第三个字段
 			row.add(rs.getString(4));
 			row.add(rs.getString(5));

 			rows.add(row);//将行数据添加到记录集合中
 		}
 	}catch(SQLException e) {
 		e.printStackTrace();
 	}
			return rows;//返回所有行数据
 }
 
	//查 返回3列 
    public static Vector<Vector> getSelectAll01(String sql){ 
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段
    			row.add(rs.getString(2));//获取第二个字段
    			row.add(rs.getString(3));//获取第三个字段
    			row.add(rs.getString(4));
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//返回所有行数据
    }
    
    //查 返回1列
    public static Vector<Vector> getSelectAll02(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段
    			
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//返回所有行数据
    }
	//增 删  返回3列 
    public static void getSelectAll03(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnection dbcs=new DatabaseConnection();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		pstmt.executeUpdate();//执行语句，结果放到数据集中

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
		
			pstmt.setString(1, accnu);//定义第1个占位符的内容
    		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
