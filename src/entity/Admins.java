package entity;

public class Admins {
	
	
	private int aid;
	private String username;
	private String password;
	
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Admins() {
		
	}
	
	
	
	public Admins(int aid, String username, String password) {
		
		this.aid = aid;
		this.username = username;
		this.password = password;
	}
	
	public String toString() {
		return "Admins [aid=" + aid + ", username=" + username + ", password=" + password  + "]";
	}
	

}
