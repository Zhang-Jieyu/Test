package cn.edu.jsu.zjy.dbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
//	//����SQLServer���ݿ���������
//	private static final String DBRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//	//����SQLServer���ݿ����ӵ�ַ
//	private static final String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName=testdb";
//	private static final String DBUSER="sa"; //SQLServer���ݿ������û���
//	private static final String PASSWORD="123456"; //SQLServer���ݿ���������
	
	//����MySQL���ݿ���������
	//org.gjt.mm.mysql.Driver
		private static final String DBRIVER="com.mysql.jdbc.Driver";
		//����MySQL���ݿ����ӵ�ַ��zjy�ɸĳ��Լ������ݿ�����
		private static final String DBURL="jdbc:mysql://localhost:3306/zjy";
		private static final String DBUSER="root"; //MySQL���ݿ������û���
		private static final String PASSWORD="123456"; //MySQL���ݿ���������

		
	private Connection conn=null; //�������Ӷ���
	public DatabaseConnection() {//���췽���������ݿ�
		try {
			Class.forName(DBRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
		} catch (Exception e) {e.printStackTrace();}
	}
	public Connection getConnection() {//�������ݿ����Ӷ���
		return this.conn;
	}
	public void close() {//�ر���������
		if(this.conn!=null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
