package cn.edu.jsu.zjy.dbc;
/**
 * isEmpty() 方法判断字符串的长度是否为空,如果字符串长度为 0,则返回 true,否则返回 false
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
