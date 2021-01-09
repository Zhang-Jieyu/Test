package new01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import cn.edu.jsu.zjy.dbc.DatabaseConnection;

public class PageController02 {
	
	private static Vector<Vector> bigList ; // �󼯺ϣ�������ȡ����
	private Vector<Vector> smallList = new Vector<Vector>(); // С���ϣ����ظ�����������
	private static int curentPageIndex = 1; // ��ǰҳ��
	private static int  countPerpage = 5; // ÿҳ��ʾ����
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	{// ��ʼ�������
		if(PageController02.bigList==null) {
			PageController02.bigList=DataOperate.getSelectAll("select * from scj");// ���ò�ѯ���ݿ�ķ������������е���
		}
		//��ȡ��ҳ��
		if(bigList.size()%countPerpage==0) {
			pageCount=bigList.size()/countPerpage;
		}else {
			pageCount=bigList.size()/countPerpage+1;
		}
	}
	public PageController02() {}//�޲ι��췽��
	
	public PageController02(String sql) {//ִ��sql���
		PageController02.bigList=DataOperate.getSelectAll(sql);//����1��
	}
	
	public void dataDelete(String sql) {
		DataOperate.getDelete(sql);
	}

	
	public boolean setInsert(String sql) {//�ж�sql ������н������ֵ�Ƿ�Ϊ��
		PageController02.bigList=DataOperate.getSelectAll02(sql);
		if(bigList.size()!=0) {
			return true;
		}else {
			return false ;
		}
	}
	
	//��������Ƿ�ƥ��
    public static boolean checkPass(String sql,String pass) {//��������Ƿ�ƥ��
    	int i=0;
    	DatabaseConnection dbcs=new DatabaseConnection();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
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

	public PageController02(int curentPageIndex) {//���췽�����õ�ǰҳ
		this.curentPageIndex = curentPageIndex;
	}
	public void setCountPerpage(int countPerpage) {//����ÿҳ��ʾ�ļ�¼��
		this.countPerpage=countPerpage;
	}
	public Vector<Vector> getPaegData() {// ���ݵ�ǰҳ����ɸѡ��¼
		recordCount = bigList.size();//�����¼��Ϊ���ݿ��б����������
		for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {//ȡ�õ�ǰҳ���ļ�¼��curentPageIndex��ǰҳ����countPerpageÿҳ��ʾ�ļ�¼��
			smallList.add(bigList.get(i));//����¼���뵽С������
		}
		return smallList;//����С���ϣ���ǰҳ�����ݣ�
	}
	public Vector<Vector> nextPage(){//��һҳ
		if(curentPageIndex<pageCount) {
			curentPageIndex++;
		}else {
			curentPageIndex=1;
		}
		return getPaegData();//������һҳ������
	}
	public Vector<Vector> prePage(){//��һҳ
		if(curentPageIndex>1) {
			curentPageIndex--;
		}else {
			curentPageIndex=pageCount;
		}
		return getPaegData();//������һҳ������
	}
	public Vector<Vector> getMydate(String acc) {
		smallList=DataOperate.getSelectAll(acc);
		return smallList;
	}


	
}
