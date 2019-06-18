package action;

import java.util.List;

import org.apache.catalina.User;
import org.apache.catalina.deploy.LoginConfig;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UsersDAO;
import service.impl.UsersDAOimpl;

public class UsersAction extends superAction implements ModelDriven<Users>{

	
	
	
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Users user =new Users();
    //查询
    public String query() {
    	UsersDAO udao = new UsersDAOimpl();
    	List<Users> list = udao.queryAllUsers();
    	if(list!=null&&list.size()>0) {
    		session.setAttribute("users_list", list);
//    		System.out.println(list);
    	}else {
    		session.setAttribute("users_list", null);
    	}
    	System.out.println(list);
    	return "query_success";
    	
    }

    
    public String modifyByself() {
    	String username = request.getParameter("username");
    	UsersDAO udao = new UsersDAOimpl();
    	Users u = udao.queryUsersByUsername(username);
    	session.setAttribute("modifyByself_users", u);
    	return "modifyByself_success";
    }
    
    
    
    //删除教师动作
    public String delete() {
    	UsersDAO uDAO = new UsersDAOimpl();
    	int uid = Integer.parseInt(request.getParameter("uid"));
    	System.out.println(uid);
    	uDAO.deleteUsers(uid);
    	return "delete_success";
    }
    
    //添加教师账号
    public String add() throws Exception{
    	Users u = new Users();
    	u.setName(request.getParameter("name"));
    	u.setUsername(request.getParameter("username"));
    	u.setPassword(request.getParameter("password"));
    	UsersDAO udao = new UsersDAOimpl();
    	udao.addUsers(u);
    	return "add_success";
    }
    
    
    //修改教师资料动作
    
    
    public String modify() {
    	//获得传递过来教师的编号
    	int uid = Integer.parseInt(request.getParameter("uid"));
    	UsersDAO udao = new UsersDAOimpl();
    	Users u = udao.queryUsersByUid(uid);
    	session.setAttribute("modify_users", u);
    	return "modify_success";
    }
    
    //保存修改后的教师账号
    public String save() throws Exception{
    	Users u = new Users();
    	u.setUid(Integer.parseInt(request.getParameter("uid")));
    	u.setName(request.getParameter("name"));
    	u.setUsername(request.getParameter("username"));
    	u.setPassword(request.getParameter("password"));
    	UsersDAO udao = new UsersDAOimpl();
    	udao.updateUsers(u);
    	return "save_success";
    }
    
    
    //用户登录动作
    public String login()
    {
    	
    	UsersDAO usersDAO=new UsersDAOimpl();
    	System.out.println(user.getUsername()+","+user.getPassword());
    	if(usersDAO.usersLogin(user))
    	{
    		session.setAttribute("loginUserName", user.getUsername());
    		return "login_success";
    	}else
    	{
    		return "login_failure";
    	}
    }
    
    
    //注销功能
    @SkipValidation
    public String loginout()
    {
    	if(session.getAttribute("loginUserName")!=null)
    	{
    		session.removeAttribute("loginUserName");
    	}
    	return "loginout_success";
    }
    
//	@Override
//	public void validate() {
//		if("".equals(user.getUsername().trim()))
//		{
//			this.addFieldError("usernameError","用户名不能为空");
//		}
//
//	}

	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
