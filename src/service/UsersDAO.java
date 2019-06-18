package service;

import java.util.List;

import entity.Users;


public interface UsersDAO {

	public boolean usersLogin(Users u);
	
	//查询所有老师账号
	public List<Users> queryAllUsers();
	
	
	//根据老师编号查询老师账户
	public Users queryUsersByUid(int uid);
	
	//根据老师用户名查询老师账户
	public Users queryUsersByUsername(String username);
	
	
	//添加教师账户
	
	public boolean addUsers(Users u);
	
	//修改老师账户资料
	public boolean updateUsers(Users u);
	
	
	//删除教师资料
	
	public boolean deleteUsers(int uid);
	



	
	
}
