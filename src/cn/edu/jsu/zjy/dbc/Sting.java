package cn.edu.jsu.zjy.dbc;
/**
 * isEmpty() �����ж��ַ����ĳ����Ƿ�Ϊ��,����ַ�������Ϊ 0,�򷵻� true,���򷵻� false
 * @author jieyu
 *
 */
public class Sting {
	  public static boolean isEmpty(String type){
		  if(type.equals("")){
			  return true;
		  }else{
			  return false;
		  }
	  }
	  public static boolean isNotEmpty(String type){
		  //if(!type.equals("")&&type!=null){
		  if(type!=null&&!type.equals("")){
			  return true;
		  }else{
			  return false;
		  }
	  }
	}
