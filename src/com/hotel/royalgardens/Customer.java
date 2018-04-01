package com.hotel.royalgardens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class Customer {

	private JFrame frmCustomerDetails;
	private JTextField rNo;
	private JTextField rType;
	private JTextField bType;
	private JTextField tRff;
	private JTextField cName;
	private JTextField cAdd;
	private JTextField cPhone;
	private JTextField cNationality;
	private JTextField idNo;
	private JTextField cCity;
	private JTextField cState;
	private JTextField checkIn;
	private JTextField checkOut;

	/**
	 * Launch the application.
	 * @param b 
	 */
	public static void NewScreen(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
					window.frmCustomerDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomerDetails = new JFrame();
		frmCustomerDetails.setTitle("Customer Details | Royal Garden");
		frmCustomerDetails.getContentPane().setBackground(Color.DARK_GRAY);
		frmCustomerDetails.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/fav_icon.png"));
		frmCustomerDetails.setResizable(false);
		frmCustomerDetails.setBounds(100, 100, 776, 557);
		frmCustomerDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomerDetails.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Room No.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(30, 89, 69, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_1);
		
		rNo = new JTextField();
		rNo.setBounds(92, 86, 86, 20);
		frmCustomerDetails.getContentPane().add(rNo);
		rNo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Room Type");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(200, 89, 79, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_2);
		
		rType = new JTextField();
		rType.setBounds(274, 86, 86, 20);
		frmCustomerDetails.getContentPane().add(rType);
		rType.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Bed Type");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(396, 89, 81, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_3);
		
		bType = new JTextField();
		bType.setBounds(466, 86, 86, 20);
		frmCustomerDetails.getContentPane().add(bType);
		bType.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tariff");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(580, 89, 38, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_4);
		
		tRff = new JTextField();
		tRff.setBounds(628, 86, 86, 20);
		frmCustomerDetails.getContentPane().add(tRff);
		tRff.setColumns(10);
		
		checkIn = new JTextField();
		checkIn.setBounds(92, 125, 86, 20);
		frmCustomerDetails.getContentPane().add(checkIn);
		checkIn.setColumns(10);
		
		checkOut = new JTextField();
		checkOut.setBounds(274, 125, 86, 20);
		frmCustomerDetails.getContentPane().add(checkOut);
		checkOut.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Check In");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(30, 128, 73, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Check Out");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(200, 128, 89, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(104, 168, 572, 2);
		frmCustomerDetails.getContentPane().add(separator);
		
		JLabel lblNewLabel_8 = new JLabel("Customer Name");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(30, 191, 117, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(30, 229, 86, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("City");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setBounds(30, 271, 69, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("State");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(30, 310, 69, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Country");
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBounds(30, 346, 86, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Phone");
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(30, 382, 69, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_13);
		
		cName = new JTextField();
		cName.setBounds(162, 188, 158, 20);
		frmCustomerDetails.getContentPane().add(cName);
		cName.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Nationality");
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setBounds(30, 427, 86, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_15);
		
		cAdd = new JTextField();
		cAdd.setBounds(162, 226, 158, 20);
		frmCustomerDetails.getContentPane().add(cAdd);
		cAdd.setColumns(10);
		
		cPhone = new JTextField();
		cPhone.setBounds(162, 379, 158, 20);
		frmCustomerDetails.getContentPane().add(cPhone);
		cPhone.setColumns(10);
		
		cNationality = new JTextField();
		cNationality.setBounds(162, 424, 158, 20);
		frmCustomerDetails.getContentPane().add(cNationality);
		cNationality.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("ID Proof");
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setBounds(391, 191, 86, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("ID No.");
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setBounds(391, 229, 57, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("People");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setBounds(391, 271, 120, 14);
		frmCustomerDetails.getContentPane().add(lblNewLabel_18);
		
		idNo = new JTextField();
		idNo.setBounds(575, 226, 120, 20);
		frmCustomerDetails.getContentPane().add(idNo);
		idNo.setColumns(10);
		
//data = new Vector<   Vector<String>  >();
		
		try {
			File f = new File("assets/data/bookedrooms.dat");
			
			if(f.exists()){
				Scanner scanner = new Scanner(f);
				while(scanner.hasNext()){
					Vector<String> row = new Vector<>();
					
					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					
					rNo.setText(fields[0].toString());
					rType.setText(fields[1].toString());
					bType.setText(fields[2].toString());
					tRff.setText(fields[3].toString());
					
					
					
					
					//data.add(row);
				}
			}
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		}
		
		JComboBox idProof = new JComboBox();
		idProof.setBounds(575, 188, 120, 20);
		frmCustomerDetails.getContentPane().add(idProof);
		idProof.addItem("Aadhar Card");
		idProof.addItem("Voter Card");
		idProof.addItem("Pan Card");
		
		JComboBox people = new JComboBox();
		people.setBounds(575, 268, 46, 20);
		frmCustomerDetails.getContentPane().add(people);
		people.addItem(1);
		people.addItem(2);
		people.addItem(3);
		people.addItem(4);
		
		JComboBox pay = new JComboBox();
		pay.setBounds(574, 317, 121, 20);
		frmCustomerDetails.getContentPane().add(pay);
		pay.addItem("CASH");
		pay.addItem("CREDIT CARD");
		pay.addItem("DEBIT CARD");
		
		JComboBox country = new JComboBox();
		country.setBounds(162, 343, 117, 20);
		frmCustomerDetails.getContentPane().add(country);
		country.addItem("Afghanistan");
		country.addItem("Argentina");
		country.addItem("Australia");
		country.addItem("Bangladesh");
		country.addItem("Belgium");
		country.addItem("Canada");
		country.addItem("France");
		country.addItem("Hong Kong");
		country.addItem("India");
		country.addItem("Iran");
		country.addItem("Japan");
		country.addItem("Malaysia");
		country.addItem("Saudi Arabia");
		country.addItem("South Africa");
		country.addItem("Spain");
		country.addItem("Sri Lanka");
		country.addItem("Switzerland");
		country.addItem("United States");
		country.addItem("United Kingdom");
		country.addItem("Switzerland");
		
		
		cCity = new JTextField();
		cCity.setBounds(162, 268, 158, 20);
		frmCustomerDetails.getContentPane().add(cCity);
		cCity.setColumns(10);
		
		cState = new JTextField();
		cState.setBounds(162, 307, 158, 20);
		frmCustomerDetails.getContentPane().add(cState);
		cState.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Rooms rm = new Rooms();
				rm.setVisible(true);
				frmCustomerDetails.dispose();
			}
		});
		
				
				JButton btnNewButton = new JButton("Book Room");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						 File f = new File("assets/data/customer.dat");
						 
						 String checkin = checkIn.getText().toString();
						 String checkout = checkOut.getText().toString();
						 String name = cName.getText().toString();
						 String add = cAdd.getText().toString();
						 String city = cCity.getText().toString();
						 String state = cState.getText().toString();
						 String cntry = country.getSelectedItem().toString();
						 String phone = cPhone.getText();
						 String nationality = cNationality.getText();
						 String id = idProof.getSelectedItem().toString();
						 String idno = idNo.getText().toString();
						 String tariff = tRff.getText().toString();
						 String ppl = people.getSelectedItem().toString();
						 String payMode = pay.getSelectedItem().toString();
						 String roomNo = rNo.getText().toString();
						 
						 
						 if (f.exists()) {
								String dataToWrite = roomNo + "|" + tariff + "|" + name + "|" + add + "|" + city + "|" + state + "|" + cntry + "|" + phone + "|" + nationality +
										"|" + id + "|" + idno + "|" + ppl + "|" + payMode + "|" + checkin + "|" + checkout + "\n";

								try {
									FileWriter fileWriter = new FileWriter(f,true);
									BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

									bufferedWriter.write(dataToWrite);
									bufferedWriter.flush();
									bufferedWriter.close();
									
								} catch (IOException ei) {
									ei.printStackTrace();
									JOptionPane.showMessageDialog(null, "Unable to save retailer data.", "Save Error",
											JOptionPane.ERROR_MESSAGE);
								} catch (Exception ej) {
									JOptionPane.showMessageDialog(null, "Unable to save retailer data.", "Save Error",
											JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Unable to save retailer data.", "Save Error",
										JOptionPane.ERROR_MESSAGE);
							}
						 
						 File f1 = new File("assets/data/tempcust.dat");
						 
						 String checkin1 = checkIn.getText().toString();
						 String checkout1 = checkOut.getText().toString();
						 String name1 = cName.getText().toString();
						 String add1 = cAdd.getText().toString();
						 String city1 = cCity.getText().toString();
						 String state1 = cState.getText().toString();
						 String cntry1 = country.getSelectedItem().toString();
						 String phone1 = cPhone.getText();
						 String nationality1 = cNationality.getText();
						 String id1 = idProof.getSelectedItem().toString();
						 String idno1 = idNo.getText().toString();
						 String tariff1 = tRff.getText().toString();
						 String ppl1 = people.getSelectedItem().toString();
						 String payMode1 = pay.getSelectedItem().toString();
						 String roomNo1 = rNo.getText().toString();
						 
						 
						 if (f1.exists()) {
								String dataToWrite = roomNo1 + "|" + tariff1 + "|" + name1 + "|" + add1 + "|" + city1 + "|" + state1 + "|" + cntry1 + "|" + phone1 + "|" + nationality1 +
										"|" + id1 + "|" + idno1 + "|" + ppl1 + "|" + payMode1 + "|" + checkin1 + "|" + checkout1 + "\n";

								try {
									FileWriter fileWriter1 = new FileWriter(f1);
									BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

									bufferedWriter1.write(dataToWrite);
									bufferedWriter1.flush();
									bufferedWriter1.close();
									
								} catch (IOException ei) {
									ei.printStackTrace();
									JOptionPane.showMessageDialog(null, "Unable to save retailer data.", "Save Error",
											JOptionPane.ERROR_MESSAGE);
								} catch (Exception ej) {
									JOptionPane.showMessageDialog(null, "Unable to save retailer data.", "Save Error",
											JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Unable to save retailer data.", "Save Error",
										JOptionPane.ERROR_MESSAGE);
							}
						 
						
						 
						 
						
						//Payment_s p = new Payment_s();
						 Payment window = new Payment();
						window.newScreen(true);
						frmCustomerDetails.dispose();
					}
				});
				btnNewButton.setBounds(575, 472, 139, 40);
				frmCustomerDetails.getContentPane().add(btnNewButton);
		btnBack.setBounds(27, 472, 109, 40);
		frmCustomerDetails.getContentPane().add(btnBack);
		
		JLabel lblModeOfPayment = new JLabel("Mode Of Payment");
		lblModeOfPayment.setForeground(Color.WHITE);
		lblModeOfPayment.setBounds(390, 320, 121, 14);
		frmCustomerDetails.getContentPane().add(lblModeOfPayment);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setForeground(Color.ORANGE);
		lblCustomerDetails.setFont(new Font("Monotype Corsiva", Font.PLAIN, 45));
		lblCustomerDetails.setBounds(247, 11, 290, 77);
		frmCustomerDetails.getContentPane().add(lblCustomerDetails);
		
		
	}
}
