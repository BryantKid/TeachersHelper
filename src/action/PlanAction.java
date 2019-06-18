package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ModelDriven;

import entity.Plan;
import service.PlanDao;
import service.impl.PlanDaoimpl;

public class PlanAction extends superAction implements ModelDriven<Plan>{
	//添加计划
	public String add() throws Exception{
		Plan plan = new Plan();
		plan.setName(request.getParameter("name"));
		plan.setPlantype(request.getParameter("plantype"));
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = simpleDateFormat.parse(this.request.getParameter("plantime"));
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		plan.setPlantime(date);
		plan.setAddress(request.getParameter("address"));
		plan.setRemarks(request.getParameter("remarks"));
		PlanDao pdao = new PlanDaoimpl();
		pdao.addPlan(plan);
		return "add_success";
	}

	@Override
	public Plan getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
