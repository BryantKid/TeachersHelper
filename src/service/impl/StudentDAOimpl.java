package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.spi.ResultSetReturn;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import db.MyHibernateSessionFactory;
import entity.Students;
import service.StudentsDAO;
import sun.security.timestamp.TSRequest;

public class StudentDAOimpl implements StudentsDAO {

	@Override
	public List<Students> queryAllStudents() {

		Transaction tx=null;
		List<Students> list=null;
		String hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Students";   
			Query query=session.createQuery(hql);
			list=query.list();
			tx.commit();
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
	public Students queryStudentsById(String sid) {
		// TODO Auto-generated method stub

		Transaction tx=null;
		Students students=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			students=(Students)session.get(Students.class, sid);
			tx.commit();
			return students;			
		} catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return students;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
			
		}
	}

	@Override
	public boolean addStudents(Students students) {

		students.setSid(getmaxid());
		Transaction tx=null;
		
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.save(students);
			tx.commit();
			return true;	
			
		} catch (Exception e) {
             e.printStackTrace();
             return false;
		}finally {
			if(tx!=null)
				tx=null;
		}
		
	}

	@Override
	public boolean updateStudents(Students students) {

		Transaction tx=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			//Students students=(Students)session.get(Students.class,sid);
			session.update(students);
			tx.commit();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
		}
		
	}

	@Override
	public boolean deleteStudents(String sid) {
		Transaction tx=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			Students students=(Students)session.get(Students.class,sid);
			session.delete(students);
			tx.commit();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return false;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
		}
	}
	

	
	public String getmaxid(){
		
		Transaction tx=null;
		String hql=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="select max(sid) from Students";
			Query query=session.createQuery(hql);
			String sid=(String)query.uniqueResult();
			if(sid==null||"".equals(sid))
			{
				sid= "s0000001";
			}else
			{
				String temp=sid.substring(1);
				int i=Integer.parseInt(temp);
				i++;
				temp=String.valueOf(i);
				int len=temp.length();
				for (int j = 0; j <7-len; j++)
				{
					temp="0"+temp;
				}
				temp="s"+temp;
				sid=temp;
			}
			tx.commit();   
			return sid;
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
	public List<Students> queryStudentsByClassroom(String address) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		List<Students> list=null;
		String hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			hql="from Students WHERE address='"+address+"'";   
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


}
