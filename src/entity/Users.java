package entity;

public class Users {
	private int uid;
	private String name;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	public Users(int uid, String name, String username, String password) {
		
		this.uid = uid;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	
	public Users() {
	}
	
	public String toString() {
		return "Users [uid=" + uid + ", name=" + name + ", username=" + username + ", password=" + password  + "]";
	}
	

}
