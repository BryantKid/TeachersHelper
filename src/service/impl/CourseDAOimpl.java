package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Classroom;
import entity.Course;
import service.CourseDAO;

public class CourseDAOimpl implements CourseDAO{

	@Override
	public List<Course> queryAllCourse() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Course> list = null;
		String hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Course";
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

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		
		Transaction tx=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(course);
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
	public boolean deleteCourse(int csid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		//String hql = "";
		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Course c = (Course)session.get(Course.class,csid);
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

	@Override
	public List<Course> queryCourseByClassroom(String cscn) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List<Course> list=null;
		String hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Course WHERE cscn='"+cscn+"'";   
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			System.out.println(list);
			return list;		
		} catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return list;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
			
		}
	}

	@Override
	public List<Course> queryCourseByTeachername(String ctn) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List<Course> list=null;
		String hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Course WHERE ctn='"+ctn+"'";   
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			System.out.println(list);
			return list;		
		} catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return list;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
			
		}
	}

	@Override
	public List<Course> queryCourseByCoursename(String csname) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List<Course> list=null;
		String hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Course WHERE csname='"+csname+"'";   
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
			System.out.println(list);
			return list;		
		} catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return list;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
			
		}
	}

	@Override
	public Course queryCourseByCsid(int csid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Course cs = null;
		
		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			cs = (Course)session.get(Course.class, csid);
			tx.commit();
			return cs;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return cs;
		}finally {
			if(tx!=null) {
				tx = null;
			}
			
		}
	}

	@Override
	public boolean updateCourse(Course c) {
		// TODO Auto-generated method stub
		Transaction tx = null;

		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(c);
			tx.commit();
			return true;
			
		}catch(Exception ex) {
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
