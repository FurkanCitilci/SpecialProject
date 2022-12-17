package com.furkancitilci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username ="";
		String password ="";
		
		do {
			
			System.out.println("Enter username: ");
			username = sc.nextLine();
			System.out.println("Enter password: ");
			password = sc.nextLine();
			
		} while (!verfyUsernamePassword(username,password,sc));
		
		System.out.println("Sisteme hoşgeldiniz...");

	}

	public static boolean verfyUsernamePassword(String username, String password, Scanner sc) {
		
		boolean usernamePasswordCiftiMevcutMu= false;
		System.out.println("Trying connect...");
		String url= "jdbc:postgresql://localhost:5432/dbtest";		
		String kullaniciadi = "postgres";
		System.out.println("Lütfen şifreyi giriniz:");
		String sifre = sc.nextLine();
		
		Connection conn= null;
		
		
		try {
			conn = DriverManager.getConnection(url, kullaniciadi, sifre);
			//System.out.println("Connection established...");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//SELECT AND CONTROL
		String sql="select username, password from users where username ='" + username + "' and password = '" + password + "'";
		PreparedStatement prp;
		
		try {
			prp = conn.prepareCall(sql);
			ResultSet rs = prp.executeQuery();
			
			if(rs.next()) {
				
				usernamePasswordCiftiMevcutMu= true;
			}else {
				
				System.out.println("Kullanıcı bulunamadı, tekrar deneyin...");
				usernamePasswordCiftiMevcutMu= false;
			}
				
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return usernamePasswordCiftiMevcutMu;
	}

}


