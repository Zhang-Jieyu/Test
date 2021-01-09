package cn.edu.jsu.zjy.vo;

public class Dormitory {

	private String id;
	private String member;//≥…‘±
	  
	public Dormitory(String id, String member) {
		super();
		this.id = id;
		this.member = member;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Dormitory [id=" + id + ", member=" + member + "]";
	}


}
