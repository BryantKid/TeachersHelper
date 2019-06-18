package entity;

public class Course {
	public int csid;
	public String csname;
	public String cscn;
	public String ctn;
	public String sop;
	public String check;
	public String pass;
	
	
	
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSop() {
		return sop;
	}
	public void setSop(String sop) {
		this.sop = sop;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public int getCsid() {
		return csid;
	}
	public void setCsid(int csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public String getCscn() {
		return cscn;
	}
	public void setCscn(String cscn) {
		this.cscn = cscn;
	}
	public String getCtn() {
		return ctn;
	}
	public void setCtn(String ctn) {
		this.ctn = ctn;
	}


	public Course(int csid, String csname, String cscn, String ctn, String sop, String check, String pass) {
		super();
		this.csid = csid;
		this.csname = csname;
		this.cscn = cscn;
		this.ctn = ctn;
		this.sop = sop;
		this.check = check;
		this.pass = pass;
	}
	public Course() {
//		super();
		// TODO Auto-generated constructor stub
	} 
	
	@Override
	public String toString() {
		return "Course [csid=" + csid + ", csname=" + csname + ", cscn=" + cscn + ", ctn=" + ctn+ ", sop=" + sop+ ", check=" + check+ ", pass=" + pass
				 + "]";
	}
	
}
