package action;

import java.util.List;

import entity.Course;
import service.CourseDAO;
import service.impl.CourseDAOimpl;

public class CourseAction extends superAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public String modify() {
    	//获得传递过来教师的编号
    	int csid = Integer.parseInt(request.getParameter("csid"));
    	CourseDAO cdao = new CourseDAOimpl();
    	Course c = cdao.queryCourseByCsid(csid);
    	session.setAttribute("modify_course", c);
    	return "modify_success";
    }
    public String save() throws Exception{
    	Course c = new Course();
//    	System.out.println(request.getParameter("csid"));
    	c.setCsid(Integer.parseInt(request.getParameter("csid")));
    	c.setCtn(request.getParameter("ctn"));
    	c.setCscn(request.getParameter("cscn"));
    	c.setPass(request.getParameter("pass"));
    	c.setCheck(request.getParameter("check"));
    	c.setCsname(request.getParameter("csname"));
    	c.setSop(request.getParameter("sop"));
    	CourseDAO cdao = new CourseDAOimpl();
    	System.out.println(cdao.updateCourse(c));
    	cdao.updateCourse(c);
    	return "save_success";
    }
    
    
	public String query() {
		CourseDAO cDAO = new CourseDAOimpl();
		List<Course> list = cDAO.queryAllCourse();
		if(list!=null&&list.size()>0) {
			session.setAttribute("course_list", list);
		}else {
			session.setAttribute("course_list", list);
		}
		System.out.println(list);
		return "query_success";
	}
	
	public String queryByClassroom() {
		CourseDAO cDAO = new CourseDAOimpl();
		String cscn = request.getParameter("cscn");
		List<Course> list = cDAO.queryCourseByClassroom(cscn);
		if(list!=null&&list.size()>0) {
			session.setAttribute("course_list", list);
		}else {
			session.setAttribute("course_list", list);
		}
		return "queryByClassroom_success";
	}
	
	public String queryByTeachername() {
		CourseDAO cDAO = new CourseDAOimpl();
		String ctn = request.getParameter("ctn");
		List<Course> list = cDAO.queryCourseByTeachername(ctn);
		if(list!=null&&list.size()>0) {
			session.setAttribute("course_list", list);
		}else {
			session.setAttribute("course_list", list);
		}
		return "queryByTeachername_success";
	}
	
	public String queryByTn() {
		CourseDAO cDAO = new CourseDAOimpl();
		String ctn = request.getParameter("ctn");
		List<Course> list = cDAO.queryCourseByTeachername(ctn);
		if(list!=null&&list.size()>0) {
			session.setAttribute("course_list", list);
		}else {
			session.setAttribute("course_list", list);
		}
		return "queryByTn_success";
	}
	
	public String queryByCoursename() {
		CourseDAO cDAO = new CourseDAOimpl();
		String csname = request.getParameter("csname");
		List<Course> list = cDAO.queryCourseByCoursename(csname);
		if(list!=null&&list.size()>0) {
			session.setAttribute("course_list", list);
		}else {
			session.setAttribute("course_list", list);
		}
		return "queryByCoursename_success";
	}
	
	public String add() {
		Course course = new Course();
		course.setCscn(this.request.getParameter("cscn"));
		course.setCsname(this.request.getParameter("csname"));
		course.setCtn(this.request.getParameter("ctn"));
		CourseDAO cDAO = new CourseDAOimpl();
		cDAO.addCourse(course);
		return "add_success";
	}
	public String delete() {
		CourseDAO cDAO = new CourseDAOimpl();
		int csid = Integer.parseInt(request.getParameter("csid"));
		cDAO.deleteCourse(csid);
		return "delete_success";
	}
	
	public String querybyUser() {
		CourseDAO cDAO = new CourseDAOimpl();
		List<Course> list = cDAO.queryAllCourse();
		if(list!=null&&list.size()>0) {
			session.setAttribute("course_list", list);
		}else {
			session.setAttribute("course_list", list);
		}
		System.out.println(list);
		return "querybyUser_success";
	}

}
