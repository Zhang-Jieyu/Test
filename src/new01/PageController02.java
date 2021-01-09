package new01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import cn.edu.jsu.zjy.dbc.DatabaseConnection;

public class PageController02 {
	
	private static Vector<Vector> bigList ; // 大集合，从外界获取数据
	private Vector<Vector> smallList = new Vector<Vector>(); // 小集合，返回给调用它的类
	private static int curentPageIndex = 1; // 当前页码
	private static int  countPerpage = 5; // 每页显示条数
	private int pageCount; // 总页数
	private int recordCount; // 总记录条数
	{// 初始化代码块
		if(PageController02.bigList==null) {
			PageController02.bigList=DataOperate.getSelectAll("select * from scj");// 调用查询数据库的方法，返回所有的行
		}
		//获取总页数
		if(bigList.size()%countPerpage==0) {
			pageCount=bigList.size()/countPerpage;
		}else {
			pageCount=bigList.size()/countPerpage+1;
		}
	}
	public PageController02() {}//无参构造方法
	
	public PageController02(String sql) {//执行sql语句
		PageController02.bigList=DataOperate.getSelectAll(sql);//返回1列
	}
	
	public void dataDelete(String sql) {
		DataOperate.getDelete(sql);
	}

	
	public boolean setInsert(String sql) {//判断sql 语句运行结果返回值是否为空
		PageController02.bigList=DataOperate.getSelectAll02(sql);
		if(bigList.size()!=0) {
			return true;
		}else {
			return false ;
		}
	}
	
	//检查密码是否匹配
    public static boolean checkPass(String sql,String pass) {//检查密码是否匹配
    	int i=0;
    	DatabaseConnection dbcs=new DatabaseConnection();
    	try(Connection conn=dbcs.getConnection();//获取数据库接
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
        		ResultSet rs=pstmt.executeQuery();
        while(rs.next()) {		if(rs.getString(2).equals(pass)) {
        			i=1;
        		}else {
					i=0;
				}}
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	if(i==1) {
    		return true;
    	}else {
			return false;
		}
	}

	public PageController02(int curentPageIndex) {//构造方法设置当前页
		this.curentPageIndex = curentPageIndex;
	}
	public void setCountPerpage(int countPerpage) {//设置每页显示的记录数
		this.countPerpage=countPerpage;
	}
	public Vector<Vector> getPaegData() {// 根据当前页数，筛选记录
		recordCount = bigList.size();//定义记录数为数据库中表的所有数据
		for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {//取得当前页数的记录，curentPageIndex当前页数，countPerpage每页显示的记录数
			smallList.add(bigList.get(i));//将记录加入到小集合中
		}
		return smallList;//返回小集合（当前页的数据）
	}
	public Vector<Vector> nextPage(){//下一页
		if(curentPageIndex<pageCount) {
			curentPageIndex++;
		}else {
			curentPageIndex=1;
		}
		return getPaegData();//返回下一页的数据
	}
	public Vector<Vector> prePage(){//上一页
		if(curentPageIndex>1) {
			curentPageIndex--;
		}else {
			curentPageIndex=pageCount;
		}
		return getPaegData();//返回上一页的数据
	}
	public Vector<Vector> getMydate(String acc) {
		smallList=DataOperate.getSelectAll(acc);
		return smallList;
	}


	
}
