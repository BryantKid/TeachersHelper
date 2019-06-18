package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Plan;
import service.PlanDao;

public class PlanDaoimpl implements PlanDao {

	@Override
	public List<Plan> queryAllPlan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plan queryPlanById(int pid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Plan plan = null;
		
		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			plan = (Plan)session.get(Plan.class, pid);
			tx.commit();
			return plan;
		}catch(Exception e) {
			e.printStackTrace();
			tx.commit();
			return plan;
		}finally{
			if(tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean addPlan(Plan plan) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(plan);
			tx.commit();
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		}finally {
			if(tx!=null) {
				tx = null;
			}	
		}
	}
	

}
