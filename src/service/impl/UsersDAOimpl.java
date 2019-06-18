package service.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Users;
import service.UsersDAO;

public class UsersDAOimpl implements UsersDAO {

	@Override
	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		Transaction txTransaction=null;
		String  hql="";
		try {
			Session session=MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			txTransaction=session.beginTransaction();
			hql="from Users where username=? and password=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
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

	@Override
	public List<Users> queryAllUsers() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Users> list = null;
		String hql ="";
		
		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return list;
		}finally {
			if(tx!=null) {
				tx = null;
			}
			
		}
	}

	@Override
	public Users queryUsersByUid(int uid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Transaction tx = null;
				Users u = null;
				
				try {
					Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
					tx = session.beginTransaction();
					u = (Users)session.get(Users.class, uid);
					tx.commit();
					return u;
					
				}catch(Exception ex) {
					ex.printStackTrace();
					tx.commit();
					return u;
				}finally {
					if(tx!=null) {
						tx = null;
					}
					
				}
	}

	@Override
	public boolean addUsers(Users u) {
		// TODO Auto-generated method stub
		Transaction tx = null;

		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(u);
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

	@Override
	public boolean updateUsers(Users u) {
		// TODO Auto-generated method stub
		Transaction tx = null;

		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(u);
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

	@Override
	public boolean deleteUsers(int uid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		//String hql = "";
		
		
		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Users u = (Users)session.get(Users.class, uid);
			session.delete(u);
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
	public Users queryUsersByUsername(String username) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Users u = null;
		
		try {
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			u = (Users)session.get(Users.class, username);
			tx.commit();
			return u;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			tx.commit();
			return u;
		}finally {
			if(tx!=null) {
				tx = null;
			}
			
		}
	}



	

}
