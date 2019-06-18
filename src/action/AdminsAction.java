package action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Admins;
import service.AdminsDao;
import service.impl.AdminsDaoimpl;



public class AdminsAction extends superAction implements ModelDriven<Admins>{

	private static final long serialVersionUID = 1L;
	private Admins admin = new Admins();
	
	public String login() {
		AdminsDao adao = new AdminsDaoimpl();
		System.out.println(admin.getUsername()+","+admin.getPassword());
		if(adao.adminsLogin(admin)) {
			
			session.setAttribute("loginUserName",admin.getUsername());
			
			return "login_success";
		}else {
			return "login_failure";
		}
		
		
	}
	public String save()
	{
		Admins admins=new Admins();
		admins.setAid(1);
		admins.setUsername(request.getParameter("username"));
		admins.setPassword(request.getParameter("password"));
		AdminsDao adminsDAO = new AdminsDaoimpl();
		adminsDAO.updateAdmins(admins);
		return "save_success";
		
	}
	
//	public String queryByUsername() {
//		AdminsDao aDAO = new AdminsDaoimpl();
//		String username = request.getParameter("username");
//		List<Admins> list = aDAO.queryAdmins(username);
//		if(list!=null&&list.size()>0) {
//			session.setAttribute("admins_list", list);
//		}else {
//			session.setAttribute("admins_list", list);
//		}
//		return "queryByUsername_success";
//	}
//	
//	public String modify()
//	{
//		String username = request.getParameter("username");
//		AdminsDao aDAO = new AdminsDaoimpl();
//		Admins admins = aDAO.queryAdminByUsername(username);
//		request.getSession().setAttribute("modify_admins", admins);
//		return "modify_success";
//	}
	public String modify()
	{
//		String aid=request.getParameter("aid");
		AdminsDao adminsDao = new AdminsDaoimpl();
		Admins admins=adminsDao.queryAdminById(1);
		request.getSession().setAttribute("modify_admins", admins);
		return "modify_success";
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
	
	
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
//		用户名不能为空
//		if("".equals(admin.getUsername().trim())) {
//			this.addFieldError("usernameError", "用户名不能为空！");
//			
//		}
	}



	@Override
	public Admins getModel() {
		// TODO Auto-generated method stub
		return this.admin;
	}
	
	

    

}
