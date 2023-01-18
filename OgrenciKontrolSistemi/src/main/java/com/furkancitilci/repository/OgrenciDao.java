package com.furkancitilci.repository;

import java.util.List;

import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.furkancitilci.entity.Ogrenci;
import com.furkancitilci.utilty.HibernateUtil;

public class OgrenciDao {

	public void save(Ogrenci ogrenci) throws Exception {
		
		Transaction transaction = null;		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {			
			transaction = session.beginTransaction();			
			session.save(ogrenci);			
			transaction.commit();					
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("kayıt başarısız!");
		}
		
		
	}

	public List<Ogrenci> getAll() throws Exception {
		
		Transaction transaction = null;
		List<Ogrenci> list = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start transaction
			transaction = session.beginTransaction();			
			//get  objects
			list = session.createQuery("from Ogrenci", Ogrenci.class).list();			
			// commit transaction
			transaction.commit();							
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("kayıt başarısız!");
		}
		
		return list;
	
	}

	public List<Ogrenci> getByEmal(String eMail) throws Exception {
		Transaction transaction = null;
		List<Ogrenci> list = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();	
			list = session.createQuery("Select ogrenci from Ogrenci as ogrenci where ogrenci.email like '"+eMail+"%'", Ogrenci.class).list(); 
			transaction.commit();							
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("kayıt başarısız!");
		}		
		return list;
		
	}

	public void update(Ogrenci ogrenci) throws Exception {
		Transaction transaction = null;		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(ogrenci);
			transaction.commit();					
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("update başarısız!");
		}
	}

	public void delete(int id) throws Exception {
		
		Transaction transaction = null;
		Ogrenci studentTemp = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			studentTemp = session.get(Ogrenci.class, id);
			session.delete(studentTemp);
			transaction.commit();					
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("silme başarısız!");
		}			
		
	}
	
	public List<Ogrenci> getByName(String firstName) throws Exception {
		Transaction transaction = null;
		List<Ogrenci> list = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();	
			list = session.createQuery("Select ogrenci from Ogrenci as ogrenci where ogrenci.firstName = '"+firstName+"'", Ogrenci.class).list(); 
			transaction.commit();							
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("kayıt başarısız!");
		}		
		return list;
		
	}

	public List<Ogrenci> getByLastName(String lastName) throws Exception {
		Transaction transaction = null;
		List<Ogrenci> list = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();	
			list = session.createQuery("Select ogrenci from Ogrenci as ogrenci where ogrenci.lastName like '"+lastName+"%'", Ogrenci.class).list(); 
			transaction.commit();							
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new Exception("kayıt başarısız!");
		}		
		return list;
		
	}


}
