package service;

import java.util.List;

import entity.Plan;

public interface PlanDao {
	
	public List<Plan> queryAllPlan();
	
	public Plan queryPlanById(int pid);
	
	public boolean addPlan(Plan plan);

}
