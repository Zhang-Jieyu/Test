package cn.edu.jsu.zjy.vo;

public class Student {
	  private int  id;//学号
	  private String name;//姓名
	  private String sex;//性别
	  private String yuanxi;
	  private int dormitory=-1;
	  
	public Student(int id, String name, String sex, String yuanxi, int dormitory) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.yuanxi = yuanxi;
		
		this.dormitory = dormitory;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getYuanxi() {
		return yuanxi;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", yuanxi=" + yuanxi + ", dormitory="
				+ dormitory + "]";
	}

	public void setYuanxi(String yuanxi) {
		this.yuanxi = yuanxi;
	}


	public int getDormitory() {
		return dormitory;
	}

	public void setDormitory(int dormitory) {
		this.dormitory = dormitory;
	}

	
}
