package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Classroom;
import entity.Users;
import service.ClassroomDAO;

public class ClassroomDAOimpl implements ClassroomDAO{

	@Override
	public List<Classroom> queryAllClassroom() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Classroom> list = null;
		String hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Classroom";
			Query query = session.createQuery(hql);
			list =  query.list();
			tx.commit();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			tx.commit();
			return list;
		}finally {
			if(tx!=null) {
				tx=null;
			}
		}
	}
	
	








	public String sum(String address) {
		
		Transaction tx=null;
		String hql=null;
	
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="SELECT COUNT(ADDRESS) FROM TeachersHelper.STUDENTS WHERE ADDRESS='"+address+"'";
			Query query=session.createQuery(hql);
			String sunmun =(String)query.uniqueResult();
			tx.commit();
			System.out.println(sunmun);
			return sunmun;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;

		}finally {
			if(tx!=null)
			{
				tx=null;
			}
		}
	}




	@Override
	public boolean addClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		
		Transaction tx=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(classroom);
			tx.commit();
			return true;	
			
		} catch (Exception e) {
             e.printStackTrace();
             tx.commit();
             return false;
		}finally {
			if(tx!=null)
				tx=null;
		}
	}




	@Override
	public boolean deleteClassroom(int cid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		//String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Classroom c = (Classroom)session.get(Classroom.class,cid);
			session.delete(c);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}finally {
			if(tx!=null) {
				tx = null;
			}
		}
	}
	
	
	

}
