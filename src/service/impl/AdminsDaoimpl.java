package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Admins;
import entity.Students;
import service.AdminsDao;

public class AdminsDaoimpl implements AdminsDao{

	@Override
	public boolean adminsLogin(Admins a) {
		
		// TODO Auto-generated method stub
		Transaction txTransaction=null;
		String  hql="";
		
		
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			txTransaction=session.beginTransaction();
			hql = "from Admins where username=? and password=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0,a.getUsername());
			query.setParameter(1,a.getPassword());
			List list=query.list();
			txTransaction.commit();
			if(list.size()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}finally {
			if(txTransaction!=null)
			{
				txTransaction=null;
			}
		}
	}

//	@Override
//	public List<Admins> queryAdmins(String username) {
//		// TODO Auto-generated method stub
//		Transaction tx=null;
//		List<Admins> list=null;
//		String hql="";
//		try {
//			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
//			tx=session.beginTransaction();
//			hql="from Admins";   
//			Query query=session.createQuery(hql);
//			list=query.list();
//			tx.commit();
//			System.out.println(list);
//			return list;		
//		} catch(Exception e)
//		{
//			e.printStackTrace();
//			tx.commit();
//			return list;
//		}
//		finally {
//			if(tx!=null)
//			{
//				tx=null;
//			}
//			
//		}
//	}
//
//	@Override
//	public Admins queryAdminByUsername(String username) {
//		// TODO Auto-generated method stub
//		Transaction tx=null;
//		Admins admins=null;
//		String hql="";
//		try {
//			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
//			tx=session.beginTransaction();
////			System.out.println(username);
//			hql="from Admins where username = '"+username+"'";   
//			Query query=session.createQuery(hql);
//			System.out.println(query);
////			admins = (Admins)query.;
////			admins=(Admins)session.get(Admins.class, username);
////			students=(Students)session.get(Students.class, sid);
//			
//			tx.commit();
//			return admins;			
//		} catch(Exception e)
//		{
//			e.printStackTrace();
//			tx.commit();
//			return admins;
//		}
//		finally {
//			if(tx!=null)
//			{
//				tx=null;
//			}
//			
//		}
//	}
//
	@Override
	public boolean updateAdmins(Admins admins) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			session.update(admins);
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
	public Admins queryAdminById(int aid) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Admins admins=null;
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx=session.beginTransaction();
			admins=(Admins)session.get(Admins.class, aid);
			tx.commit();
			return admins;			
		} catch(Exception e)
		{
			e.printStackTrace();
			tx.commit();
			return admins;
		}
		finally {
			if(tx!=null)
			{
				tx=null;
			}
			
		}
	}



}
