package cn.les.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;


import cn.les.hib.HibernateSessionFactory;

public class BaseDao {
	
	protected Session session;
	private Transaction transaction;
	
	public void openConnection() throws Exception{
		session = (Session) HibernateSessionFactory.getSession();
	}
		
	
	public void closeConnection() throws Exception{
		if(session!=null){
			session.close();
		}
	}
	
	public void beginTransaction() throws Exception{
		if(session!=null){
			transaction = session.beginTransaction();
		}
	}
	
	
	public void commit()throws Exception{
		if(transaction!=null){
			transaction.commit();
		}
		
	}
	
	public void callback()throws Exception{
		if(transaction!=null){
			transaction.rollback();
		}
		
	}

}
