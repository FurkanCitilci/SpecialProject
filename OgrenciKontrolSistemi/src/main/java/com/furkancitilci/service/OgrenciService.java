package com.furkancitilci.service;

import java.util.List;

import javax.swing.JTextField;

import com.furkancitilci.entity.Ogrenci;
import com.furkancitilci.repository.OgrenciDao;

public class OgrenciService {
	
	private OgrenciDao ogrenciDao;
	
	

	public OgrenciService() {

		this.ogrenciDao = new OgrenciDao();
	}



	public void save(Ogrenci ogrenci) {
		
		try {
			ogrenciDao.save(ogrenci);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}



	public List<Ogrenci> getAll() {
		
		List<Ogrenci> list = null;
		try {
			list = ogrenciDao.getAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}



	public List<Ogrenci> getByEmal(String eMail) {
		
		List<Ogrenci> list = null;
		try {
			list = ogrenciDao.getByEmal(eMail);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}



	public void update(Ogrenci ogrenci) {
		try {
			ogrenciDao.update(ogrenci);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}



	public void delete(int id) {

		try {
			ogrenciDao.delete(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}



	public List<Ogrenci> getByName(String firstname) {
		List<Ogrenci> list = null;
		try {
			list = ogrenciDao.getByName(firstname);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}



	public List<Ogrenci> getByLastName(String lastName) {
		List<Ogrenci> list = null;
		try {
			list = ogrenciDao.getByLastName(lastName);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return list;
	}

}
