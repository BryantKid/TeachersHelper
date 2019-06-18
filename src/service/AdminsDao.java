package service;

import java.util.List;

import entity.Admins;

public interface AdminsDao {
	public boolean adminsLogin(Admins a);
	
//	public List<Admins> queryAdmins(String username);
//	
	public Admins queryAdminById(int aid);
//	
	public boolean updateAdmins(Admins admins);
	
}
