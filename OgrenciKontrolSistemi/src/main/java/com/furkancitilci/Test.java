package com.furkancitilci;

import com.furkancitilci.utilty.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory().openSession();

	}

}
