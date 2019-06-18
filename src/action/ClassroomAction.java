package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entity.Classroom;

import service.ClassroomDAO;

import service.impl.ClassroomDAOimpl;


public class ClassroomAction extends superAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String query() {
		ClassroomDAO cDAO = new ClassroomDAOimpl();
		List<Classroom> list= cDAO.queryAllClassroom();
		if(list!=null&&list.size()>0) {
			session.setAttribute("classroom_list", list);
		}else {
			session.setAttribute("classroom_list", null);
		}
		System.out.println(list);
		return "query_success";
	}
	
	public String add() {
		Classroom classroom=new Classroom();
		classroom.setCname(this.request.getParameter("cname"));
		ClassroomDAO classroomDAO = new ClassroomDAOimpl();
		classroomDAO.addClassroom(classroom);
		return "add_success";
	}
	
	public String delete() {
		ClassroomDAO cDAO = new ClassroomDAOimpl();
		int cid = Integer.parseInt(request.getParameter("cid"));
		cDAO.deleteClassroom(cid);
		return "delete_success";
	}


}
