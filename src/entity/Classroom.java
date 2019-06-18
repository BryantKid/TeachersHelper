package entity;

public class Classroom {
	private int cid;
	private String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Classroom(int cid, String cname) {
//		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Classroom() {
//		super();
//		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Classroom [cid=" + cid + ", name=" + cname +  "]";
	}
	
}
