package com.furkancitilci.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.furkancitilci.controller.OgrenciController;
import com.furkancitilci.entity.Ogrenci;


import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class KontrolPaneli {

	private JFrame frmrenciBilgileri;
	
	
	private OgrenciController ogrenciController;
	//private OgrenciService ogrenciService;
	private JTable table;
	private JTextField textField_ID;
	private JTextField textField_eMail;
	private JTextField textFieldLastName;
	private JTextField textFieldFirstName;
	private JTextField textFieldTelno1;
	private JTextField textFieldAdres1;
	private JTextField textFieldTelno2;
	private JTextField textFieldAdres2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxGender;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxLang;
	private JButton btnGetAll;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblFirstname;
	private JLabel lblLastName;
	private JButton btnSorgulaMail;
	private JButton btnSorgulaName;
	private JButton btnSorgulaLastName;
	private JLabel lblTelno;
	private JLabel lblAdress;
	private JLabel lblCinsiyet;
	private JLabel label;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontrolPaneli window = new KontrolPaneli();
					window.frmrenciBilgileri.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	private void languageSet() {

		ResourceBundle resourceBundle =  ResourceBundle.getBundle("com/furkancitilci/config/resource_bundle");
		btnGetAll.setText(resourceBundle.getString("word1"));
		btnSave.setText(resourceBundle.getString("word2"));
		btnUpdate.setText(resourceBundle.getString("word3"));
		btnDelete.setText(resourceBundle.getString("word4"));
		lblAdress.setText(resourceBundle.getString("word5"));
		lblTelno.setText(resourceBundle.getString("word8"));
		lblCinsiyet.setText(resourceBundle.getString("word9"));
		lblFirstname.setText(resourceBundle.getString("word10"));
		lblLastName.setText(resourceBundle.getString("word11"));
		btnSorgulaLastName.setText(resourceBundle.getString("word12"));
		btnSorgulaMail.setText(resourceBundle.getString("word12"));
		btnSorgulaName.setText(resourceBundle.getString("word12"));
		
//		btnHello.setText(resourceBundle.getString("word1"));
//		lblBye.setText(resourceBundle.getString("word2"));
		
		
		
		
	}
	
	public KontrolPaneli() {
		initialize();
		
		Locale.setDefault(new Locale("tr","TR"));
		languageSet();
		ogrenciController = new OgrenciController();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmrenciBilgileri = new JFrame();
		frmrenciBilgileri.setTitle("Öğrenci Bilgileri");
		frmrenciBilgileri.setBounds(100, 100, 937, 565);
		frmrenciBilgileri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmrenciBilgileri.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 260, 607, 227);
		frmrenciBilgileri.getContentPane().add(scrollPane);
		
		label = new JLabel("");
//		label.setIcon(new ImageIcon(KontrolPaneli.class.getResource("/com/furkancitilci/resources/admin_girl.png")));
		label.setBounds(770, 41, 85, 81);
		frmrenciBilgileri.getContentPane().add(label);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				List<Ogrenci> list = ogrenciController.getAll();
				Map<Integer, String> ogrMapTel1 = list.stream().collect(Collectors.toMap(ogr -> ogr.getId(), ogr -> ogr.getTelNo1()));
				Map<Object, Object> ogrMapTel2 = list.stream().collect(Collectors.toMap(ogr -> ogr.getId(), ogr -> ogr.getTelNo2()));
				Map<Object, Object> ogrMapAdres1 = list.stream().collect(Collectors.toMap(ogr -> ogr.getId(), ogr -> ogr.getAddress1()));
				Map<Object, Object> ogrMapAdres2 = list.stream().collect(Collectors.toMap(ogr -> ogr.getId(), ogr -> ogr.getAddress2()));
				Map<Object, Object> ogrMapGend = list.stream().collect(Collectors.toMap(ogr -> ogr.getId(), ogr -> ogr.getGender()));
				//ogrenciMap.forEach((key,value) -> System.out.println(key + "  " + value));
				
				if(comboBoxGender.getSelectedItem().toString().equalsIgnoreCase("Erkek")) {
					label.setIcon(new ImageIcon(KontrolPaneli.class.getResource("/com/furkancitilci/resources/admin_boy.png")));
				}else {
					label.setIcon(new ImageIcon(KontrolPaneli.class.getResource("/com/furkancitilci/resources/admin_girl.png")));
				}
			
				int satir = table.getSelectedRow();
				TableModel model = table.getModel();
				textField_ID.setText(model.getValueAt(satir, 0).toString());
				textField_eMail.setText(model.getValueAt(satir, 1).toString());
				textFieldFirstName.setText(model.getValueAt(satir, 2).toString());
				textFieldLastName.setText(model.getValueAt(satir, 3).toString());
				
				//String id= textField_ID.getText();
				int id= Integer.parseInt(textField_ID.getText());
				System.out.println(id);
				String tel1 = (String) ogrMapTel1.get(id);
				String tel2 = (String) ogrMapTel2.get(id);
				String adres1 = (String) ogrMapAdres1.get(id);
				String adres2 = (String) ogrMapAdres2.get(id);
				String gender = (String) ogrMapGend.get(id);
				System.out.println(tel1);
				textFieldTelno1.setText(tel1);
				textFieldTelno2.setText(tel2);
				textFieldAdres1.setText(adres1);
				textFieldAdres2.setText(adres2);
				comboBoxGender.setSelectedItem(gender);

									

				
				
				

			
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Email", "Firstname", "Lastname"
			}
		));
		scrollPane.setViewportView(table);
		
		btnGetAll = new JButton("Get All");
		btnGetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Ogrenci> list = ogrenciController.getAll();
				tabloyuDoldur(list);
			
			}
		});
		btnGetAll.setBounds(263, 196, 105, 21);
		frmrenciBilgileri.getContentPane().add(btnGetAll);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ogrenciController.save(textField_eMail.getText(),textFieldFirstName.getText(),textFieldLastName.getText(),
						comboBoxGender.getSelectedItem().toString(),textFieldAdres1.getText(),textFieldAdres2.getText(),textFieldTelno1.getText(),textFieldTelno2.getText());
				
				List<Ogrenci> list = ogrenciController.getAll();
				tabloyuDoldur(list);
				textTemizle();
				
			}
		});
		btnSave.setBounds(393, 196, 85, 21);
		frmrenciBilgileri.getContentPane().add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ogrenciController.update(textField_ID.getText(), textField_eMail.getText(),textFieldFirstName.getText(),textFieldLastName.getText(),
						comboBoxGender.getSelectedItem().toString(),textFieldAdres1.getText(),textFieldAdres2.getText(),textFieldTelno1.getText(),textFieldTelno2.getText());
				
				
				List<Ogrenci> list = ogrenciController.getAll();
				tabloyuDoldur(list);
			
				textTemizle();
				
			}
		});
		btnUpdate.setBounds(500, 196, 85, 21);
		frmrenciBilgileri.getContentPane().add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ogrenciController.delete(textField_ID.getText());
				
				
				List<Ogrenci> list = ogrenciController.getAll();
				tabloyuDoldur(list);
				textTemizle();
				
				
			}
		});
		btnDelete.setBounds(610, 196, 85, 21);
		frmrenciBilgileri.getContentPane().add(btnDelete);
		
		JLabel lblid = new JLabel("ID:");
		lblid.setBounds(92, 29, 45, 13);
		frmrenciBilgileri.getContentPane().add(lblid);
		
		JLabel lblEmail = new JLabel("eMAİL:");
		lblEmail.setBounds(92, 60, 73, 13);
		frmrenciBilgileri.getContentPane().add(lblEmail);
		
		lblFirstname = new JLabel("FirstName:");
		lblFirstname.setBounds(92, 93, 73, 13);
		frmrenciBilgileri.getContentPane().add(lblFirstname);
		
		lblLastName = new JLabel("LastName:");
		lblLastName.setBounds(92, 124, 73, 13);
		frmrenciBilgileri.getContentPane().add(lblLastName);
		
		textField_ID = new JTextField();
		textField_ID.setEnabled(false);
		textField_ID.setBounds(184, 26, 96, 19);
		frmrenciBilgileri.getContentPane().add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_eMail = new JTextField();
		textField_eMail.setColumns(10);
		textField_eMail.setBounds(184, 57, 96, 19);
		frmrenciBilgileri.getContentPane().add(textField_eMail);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(184, 118, 96, 19);
		frmrenciBilgileri.getContentPane().add(textFieldLastName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(184, 87, 96, 19);
		frmrenciBilgileri.getContentPane().add(textFieldFirstName);
		
		btnSorgulaMail = new JButton("Sorgula");
		btnSorgulaMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Ogrenci> list= ogrenciController.getByEmal(textField_eMail.getText());
				tabloyuDoldur(list);
				
				
				
			}
		});
		btnSorgulaMail.setBounds(310, 54, 85, 21);
		frmrenciBilgileri.getContentPane().add(btnSorgulaMail);
		
		 btnSorgulaName = new JButton("Sorgula");
		btnSorgulaName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Ogrenci> list= ogrenciController.getByName(textFieldFirstName.getText());
				tabloyuDoldur(list);
			}
		});
		btnSorgulaName.setBounds(310, 85, 85, 21);
		frmrenciBilgileri.getContentPane().add(btnSorgulaName);
		
		btnSorgulaLastName = new JButton("Sorgula");
		btnSorgulaLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Ogrenci> list= ogrenciController.getByLastName(textFieldLastName.getText());
				tabloyuDoldur(list);
				
			}
		});
		btnSorgulaLastName.setBounds(310, 116, 85, 21);
		frmrenciBilgileri.getContentPane().add(btnSorgulaLastName);
		
		JLabel lblInfo1 = new JLabel("Contact Info 1");
		lblInfo1.setBounds(560, 29, 90, 13);
		frmrenciBilgileri.getContentPane().add(lblInfo1);
		
		JLabel lblInfo2 = new JLabel("Contact Info 2");
		lblInfo2.setBounds(660, 29, 85, 13);
		frmrenciBilgileri.getContentPane().add(lblInfo2);
		
		textFieldTelno1 = new JTextField();
		textFieldTelno1.setColumns(10);
		textFieldTelno1.setBounds(536, 60, 96, 19);
		frmrenciBilgileri.getContentPane().add(textFieldTelno1);
		
		textFieldAdres1 = new JTextField();
		textFieldAdres1.setColumns(10);
		textFieldAdres1.setBounds(536, 90, 96, 19);
		frmrenciBilgileri.getContentPane().add(textFieldAdres1);
		
		textFieldTelno2 = new JTextField();
		textFieldTelno2.setColumns(10);
		textFieldTelno2.setBounds(649, 60, 96, 19);
		frmrenciBilgileri.getContentPane().add(textFieldTelno2);
		
		textFieldAdres2 = new JTextField();
		textFieldAdres2.setColumns(10);
		textFieldAdres2.setBounds(649, 90, 96, 19);
		frmrenciBilgileri.getContentPane().add(textFieldAdres2);
		
		lblTelno = new JLabel("TelNo:");
		lblTelno.setBounds(440, 62, 73, 13);
		frmrenciBilgileri.getContentPane().add(lblTelno);
		
		lblAdress = new JLabel("Adres:");
		lblAdress.setBounds(440, 93, 73, 13);
		frmrenciBilgileri.getContentPane().add(lblAdress);
		
		lblCinsiyet = new JLabel("Cinsiyet");
		lblCinsiyet.setBounds(92, 157, 73, 13);
		frmrenciBilgileri.getContentPane().add(lblCinsiyet);
		
		
		comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Erkek", "Kadın"}));
		comboBoxGender.setBounds(184, 153, 96, 21);
		frmrenciBilgileri.getContentPane().add(comboBoxGender);
		
		JLabel lblLang = new JLabel("Language:");
		lblLang.setBounds(734, 411, 85, 13);
		frmrenciBilgileri.getContentPane().add(lblLang);
		
		comboBoxLang = new JComboBox();
		comboBoxLang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBoxLang.getSelectedItem().toString().equalsIgnoreCase("English")) {
					Locale.setDefault(new Locale("en","EN"));
					languageSet();
				}else if(comboBoxLang.getSelectedItem().toString().equalsIgnoreCase("Turkish")) {
					Locale.setDefault(new Locale("tr","TR"));
					languageSet();
				}
				
				
			}
		});
		comboBoxLang.setModel(new DefaultComboBoxModel(new String[] {"Turkish", "English"}));
		comboBoxLang.setBounds(734, 434, 96, 21);
		frmrenciBilgileri.getContentPane().add(comboBoxLang);
		
		
	}
	
	private void tabloyuDoldur(List<Ogrenci> list) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);  		
		
		Object[] columns = new Object[4];
		for (int i=0;i<list.size();i++) {
			columns[0] = list.get(i).getId();
			columns[1] = list.get(i).getEmail();
			columns[2] = list.get(i).getFirstName();
			columns[3] = list.get(i).getLastName();
			model.addRow(columns);
			
		}
		
	}
	
	public void textTemizle() {
		
		textField_eMail.setText("");
		textField_ID.setText("");
		textFieldAdres1.setText("");
		textFieldAdres2.setText("");
		textFieldFirstName.setText("");
		textFieldLastName.setText("");
		textFieldTelno1.setText("");
		textFieldTelno2.setText("");
	
		
		
		
	}
}
