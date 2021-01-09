package cn.edu.jsu.zjy.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.util.StringUtil;

import cn.edu.jsu.zjy.dbc.Sting;
import cn.edu.jsu.zjy.vo.Student;


/**
 * 
 * @author jieyu
 *
 */
public class StudentDao {
  public int StudentAdd(Connection con,Student student) throws Exception{
	 String sql = "insert into student_message values(null,?,?,?,?,?,?)";
	 PreparedStatement pstmt = con.prepareStatement(sql);
	 pstmt.setString(1,student.getName());
	 pstmt.setString(2,student.getSex());
	 pstmt.setString(3, student.getYuanxi());
	// pstmt.setString(4, student.getClassroom());
	 pstmt.setString(4, student.getDormitory()+"");
	// pstmt.setString(6, student.getBed()+"");
	 return pstmt.executeUpdate();
  }
  public ResultSet StudentSearch(Connection con,Student student) throws Exception{
	  StringBuffer sb = new StringBuffer("select * from student_message b,room_message bt where b.dormitory=bt.id");
	  if(Sting.isNotEmpty(student.getName())){
		 sb.append(" and b.name like '%"+student.getName()+"%'"); 
	  }
	  if(Sting.isNotEmpty(student.getSex())){
			// sb.append(" and b.sex = '"+student.getSex()+"'"); 
			 sb.append(" and b.sex = '"+student.getSex()+"'");
		  }
	  if(Sting.isNotEmpty(student.getYuanxi())){
			 sb.append(" and b.yuanxi like '%"+student.getYuanxi()+"%'"); 
		  }
//	  if(Sting.isNotEmpty(student.getClassroom())){
//			 sb.append(" and b.classroom like '%"+student.getClassroom()+"%'"); 
//		  }
	  if(student.getDormitory()!=-1){
			 sb.append(" and b.dormitory = " + student.getDormitory()); 
		  }
	  PreparedStatement pstmt = con.prepareStatement(sb.toString());
	  return pstmt.executeQuery();
  }
  public int StudentModify(Connection con,Student student)throws Exception{
	  String sql = "update student_message set name=?,sex=?,yuanxi=?,classroom=?,dormitory=?,bed=? where id=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,student.getName());
	  pstmt.setString(2,student.getSex());
	  pstmt.setString(3,student.getYuanxi());
//	  pstmt.setString(4,student.getClassroom());
	  pstmt.setInt(4,student.getDormitory());
//	  pstmt.setInt(6,student.getBed());
	  pstmt.setInt(5,student.getId());
	  return pstmt.executeUpdate();  
  }
  public int StudentDelete(Connection con,Student student) throws Exception{
	  String sql = "delete from student_message where name=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,student.getName()+"");
	  return pstmt.executeUpdate();
  }
}
