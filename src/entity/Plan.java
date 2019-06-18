package entity;

import java.util.Date;


public class Plan {
	private int pid;
	private String name;
	private String plantype;
	private Date plantime;
	private String address;
	private String remarks;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlantype() {
		return plantype;
	}
	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}
	public Date getPlantime() {
		return plantime;
	}
	public void setPlantime(Date plantime) {
		this.plantime = plantime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Plan(int pid, String name, String plantype, Date plantime, String address, String remarks) {
		this.pid = pid;
		this.name = name;
		this.plantype = plantype;
		this.plantime = plantime;
		this.address = address;
		this.remarks = remarks;
	}
	
	public Plan() {
		
	}
	@Override
	public String toString() {
		return "Plans [pid=" + pid + ", name=" + name + ", plantype=" + plantype + ", plantime=" + plantime
				+ ", address=" + address + ", remarks=" + remarks +"]";
	}
	
	
}
