package com.furkancitilci.controller;



import java.util.List;

import javax.swing.JTextField;

import com.furkancitilci.entity.Ogrenci;
import com.furkancitilci.service.OgrenciService;

public class OgrenciController {
	
	private OgrenciService ogrenciService;
	
	
	

	public OgrenciController() {

		this.ogrenciService= new OgrenciService();
	}




	public void save(String email, String firstName, String lastName, String gender, String address1, String address2,
			String telNo1, String telNo2) {
		
		if(address2 == null & telNo2 ==null) {
			Ogrenci ogrenci = new Ogrenci(email,firstName,lastName,gender,address1,telNo1);
			ogrenciService.save(ogrenci);
		}else if (address1 == null & telNo1 ==null) {
			Ogrenci ogrenci = new Ogrenci(email,firstName,lastName,gender,address2,telNo2);
			ogrenciService.save(ogrenci);
		}else {
			Ogrenci ogrenci = new Ogrenci(email,firstName,lastName,gender,address1,address2,telNo1,telNo2);
			ogrenciService.save(ogrenci);
		}

		
	}


	public List<Ogrenci> getAll() {
		
		List<Ogrenci> list = null;
		try {
			list = ogrenciService.getAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
	}




	public List<Ogrenci> getByEmal(String textField_eMail) {
		
		List<Ogrenci> list = null; 
		try {
			list = ogrenciService.getByEmal(textField_eMail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
		
		
	}




	public void update(String id,String email, String firstName, String lastName, String gender, String address1, String address2,
			String telNo1, String telNo2) {
		
		Ogrenci ogrenci = new Ogrenci(Integer.parseInt(id),email,firstName,lastName,gender,address1,address2,telNo1,telNo2);
		ogrenciService.update(ogrenci);
		
	}




	public void delete(String id) {

		ogrenciService.delete(Integer.parseInt(id));
		
	}


	public List<Ogrenci> getByName(String firstname) {
		List<Ogrenci> list = null; 
		try {
			list = ogrenciService.getByName(firstname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
	}




	public List<Ogrenci> getByLastName(String lastName) {
		
		List<Ogrenci> list = null; 
		try {
			list = ogrenciService.getByLastName(lastName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
