package cn.edu.jsu.zjy.dbc;
/**
 * ��������
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Data {
	//��������
	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    //����ѧԺ
    private static String[] yuan= {"��Ժ","�Ź�","��ͳ","ҽѧ","����","��Ժ"};
    
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    //�������ѧ��
    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder xh=new StringBuilder("201940");//ѧ��ǰ6λ��ͬ
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,9999)));//���ȡ��4λ
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "000");//�����1λ����ǰ������3��0
    		xh=xh.append(xh1);//ǰ6λ���4λƴ�ӳ�ѧ��
    	}else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "00");//�����2λ����ǰ������2��0
    		xh=xh.append(xh1); 
    	}else if(xh1.length()==3) {//�����3λ����ǰ������1��0
    		xh1=xh1.insert(0,"0");
    		xh=xh.append(xh1);
    	}
    	else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
    //������������
    public static StringBuilder getRoomNum() {
    	StringBuilder roomNum1=new StringBuilder("1-");//��������ǰ1λ��ͬ
    	StringBuilder roomNum2=new StringBuilder("2-");//Ů������ǰ1λ��ͬ
    	StringBuilder roomNum3=new StringBuilder(String.valueOf(getNum(1,999)));//���ȡ��3λ
    	String room=getSex();
    	StringBuilder num=null;
    	if(room.equals("��")) {
    		if(roomNum3.length()==1) {
    			roomNum3=roomNum3.insert(0, "00");//�����1λ����ǰ������2��0
        		num=roomNum1.append(roomNum3);//ǰ1λ���3λƴ�ӳ������
        	}else if(roomNum3.length()==2) {
        		roomNum3=roomNum3.insert(0, "0");//�����2λ����ǰ������1��0
        		num=roomNum1.append(roomNum3);
        	}else{//�����3λ����ǰ�治��0
        		
        		num=roomNum1.append(roomNum3);
        	}
        	
    	}
    	else{
    		if(roomNum3.length()==1) {
    			roomNum3=roomNum3.insert(0, "00");//�����1λ����ǰ������2��0
        		num=roomNum2.append(roomNum3);//ǰ1λ���3λƴ�ӳ������
        	}else if(roomNum3.length()==2) {
        		roomNum3=roomNum3.insert(0, "0");//�����2λ����ǰ������1��0
        		num=roomNum2.append(roomNum3);
        	}else  {//�����3λ����ǰ�治��0
        
        		num=roomNum2.append(roomNum3);
        	}
 
    	}
       	
    	return num;
    }
    //�����ȡԺ��
    public static String getYuan() {
    	   int index=getNum(0, yuan.length-1);//���ȡ�����ַ����е�����λ��
           String name=yuan[index];//��ȡ��λ�õ�Ժ��
           return name;
    }
    //��������������� 
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    //�����ȡ�Ա�
    public static String getSex() {
    	//String S[]= {"��","Ů"};
    	int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
    	if(sex==1) {
    		return "��";
    	}else {
    		return "Ů";
    	}
    }
    
    public static void main(String[] args) {
    	add();
    }
   
    public static void add() {//���ӳɼ�
    	DatabaseConnection dbcs=new DatabaseConnection();//ʹ��1�ж�����������ݿ����
    	String sql="insert into scj(xh,xm,xb,yuanxi,num) values(?,?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
    		for(int i=1;i<=800;) {
    			String xh=getStuno().toString();//�����ȡѧ��
    			if(!alist.contains(xh)) {//�ж�ѧ���Ƿ�Ψһ
    				alist.add(xh);//��ѧ�ż��뼯��
    				String xm=getChineseName();	//�����ȡ����
    				String xb=getSex();	//�����ȡ�Ա�
    				String yuanxi=getYuan();	//�����ȡԺ��
    				String num=getRoomNum().toString();	//�����ȡ�����
    				
    				pstmt.setString(1, xh);//�����1��ռλ��������
    	    		pstmt.setString(2, xm);//�����2��ռλ��������
    	    		pstmt.setString(3, xb);//�����3��ռλ��������
    	    		pstmt.setString(4, yuanxi);//�����4��ռλ��������
    	    		pstmt.setString(5, num);//�����4��ռλ��������
    	    		
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//ѧ��Ψһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "sucess");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    

    
}

