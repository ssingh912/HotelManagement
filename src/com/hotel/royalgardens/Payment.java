package com.hotel.royalgardens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.api.server.SDDocumentFilter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Payment {

	private JFrame frmPaymentsRoyal;
	private JTextField cName;
	private JTextField rNo;
	private JTextField checkIn;
	private JTextField checkOut;
	private JTextField mPay;
	private JTextField tDays;
	private JTextField total;

	/**
	 * Launch the application.
	 */
	public static void newScreen(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
					window.frmPaymentsRoyal.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPaymentsRoyal = new JFrame();
		frmPaymentsRoyal.getContentPane().setBackground(Color.BLUE);
		frmPaymentsRoyal.setTitle("Payments | Royal Garden");
		frmPaymentsRoyal.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/fav_icon.png"));
		frmPaymentsRoyal.setResizable(false);
		frmPaymentsRoyal.setBounds(100, 100, 591, 400);
		frmPaymentsRoyal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaymentsRoyal.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Room No:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(126, 73, 101, 14);
		frmPaymentsRoyal.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer Name:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(126, 120, 115, 14);
		frmPaymentsRoyal.getContentPane().add(lblNewLabel_1);

		cName = new JTextField();
		cName.setBounds(353, 117, 146, 20);
		frmPaymentsRoyal.getContentPane().add(cName);
		cName.setColumns(10);

		rNo = new JTextField();
		rNo.setBounds(353, 70, 86, 20);
		frmPaymentsRoyal.getContentPane().add(rNo);
		rNo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Total Amount(All taxes Included):");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(126, 271, 212, 14);
		frmPaymentsRoyal.getContentPane().add(lblNewLabel_3);

		checkIn = new JTextField();
		checkIn.setBounds(263, 201, 86, 20);
		frmPaymentsRoyal.getContentPane().add(checkIn);
		checkIn.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("PAYMENT DETAILS");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblNewLabel_5.setBounds(209, 11, 204, 33);
		frmPaymentsRoyal.getContentPane().add(lblNewLabel_5);

		checkOut = new JTextField();
		checkOut.setBounds(460, 201, 86, 20);
		frmPaymentsRoyal.getContentPane().add(checkOut);
		checkOut.setColumns(10);

		JLabel lblCheckIn = new JLabel("Check In:");
		lblCheckIn.setForeground(Color.BLACK);
		lblCheckIn.setBounds(126, 204, 101, 14);
		frmPaymentsRoyal.getContentPane().add(lblCheckIn);

		JLabel lblCheckOut = new JLabel("Check Out:");
		lblCheckOut.setForeground(Color.BLACK);
		lblCheckOut.setBounds(388, 204, 101, 14);
		frmPaymentsRoyal.getContentPane().add(lblCheckOut);

		JLabel lblNewLabel_2 = new JLabel("Mode Of Payment:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(126, 158, 115, 14);
		frmPaymentsRoyal.getContentPane().add(lblNewLabel_2);

		mPay = new JTextField();
		mPay.setBounds(353, 155, 146, 20);
		frmPaymentsRoyal.getContentPane().add(mPay);
		mPay.setColumns(10);

		tDays = new JTextField();
		tDays.setBounds(353, 234, 86, 20);
		frmPaymentsRoyal.getContentPane().add(tDays);
		tDays.setColumns(10);

		JLabel lblTotalDays = new JLabel("Total Days:");
		lblTotalDays.setForeground(Color.BLACK);
		lblTotalDays.setBounds(126, 237, 105, 14);
		frmPaymentsRoyal.getContentPane().add(lblTotalDays);

		total = new JTextField();
		total.setBounds(353, 268, 86, 20);
		frmPaymentsRoyal.getContentPane().add(total);
		total.setColumns(10);

		try {
			File f = new File("assets/data/tempcust.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {
					Vector<String> row = new Vector<>();

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");

					rNo.setText(fields[0].toString());

					cName.setText(fields[2].toString());
					mPay.setText(fields[12].toString());
					checkIn.setText(fields[13].toString());
					checkOut.setText(fields[14].toString());
					long temp = Integer.parseInt(fields[1]);
					String dateStart = checkIn.getText();
					String dateStop = checkOut.getText();
					String[] d1 = dateStart.split("[/]");
					String[] d2 = dateStop.split("[/]");
					long dd1 = Integer.parseInt(d1[0]);
					long mm1 = Integer.parseInt(d1[1]);
					long yy1 = Integer.parseInt(d1[2]);
					long dd2 = Integer.parseInt(d2[0]);
					long mm2 = Integer.parseInt(d2[1]);
					long yy2 = Integer.parseInt(d2[2]);
				
					
					if(mm1==mm2) {
						long days = dd2-dd1;
						//System.out.print("Days= "+days +"|");
						total.setText(""+((temp*0.28+temp)*days));
						break;
					}
					else if(mm2>mm1) {
						
						if(mm1==1) {
							long jan = (31+dd2)-dd1+1;
							tDays.setText(""+jan);
						}
						else if(mm1==2) {
							long feb = (28+dd2)-dd1+1;
							tDays.setText(""+feb);
						}
						else if(mm1==3) {
							long mar = (31+dd2)-dd1+1;
							tDays.setText(""+mar);
						}
						else if(mm1==4) {
							long apr = (30+dd2)-dd1+1;
							tDays.setText(""+apr);
						}
						else if(mm1==5) {
							long may = (31+dd2)-dd1+1;
							tDays.setText(""+may);
						}
						else if(mm1==6) {
							long jun = (30+dd2)-dd1+1;
							tDays.setText(""+jun);
						}
						else if(mm1==7) {
							long jul = (31+dd2)-dd1+1;
							tDays.setText(""+jul);
						}
						else if(mm1==8) {
							long aug = (30+dd2)-dd1+1;
							tDays.setText(""+aug);
						}
						else if(mm1==9) {
							long sep = (31+dd2)-dd1+1;
							tDays.setText(""+sep);
						}
						else if(mm1==10) {
							long oct = (30+dd2)-dd1+1;
							tDays.setText(""+oct);
						}
						else if(mm1==11) {
							long nov = (31+dd2)-dd1+1;
							tDays.setText(""+nov);
						}
						else if(mm1==12) {
							long dec = (30+dd2)-dd1+1;
							tDays.setText(""+dec);
						}
						
						String b = tDays.getText().toString();
						long bb = Integer.parseInt(b);
						
						//System.out.println(""+((temp*0.28+temp)*bb));
						total.setText(""+((temp*0.28+temp)*bb));
					}
				}
				

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnNewButton = new JButton("Print Bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String roomNo = rNo.getText().toString();
				String name = cName.getText().toString();
				String modePay = mPay.getText().toString();
				String dateIn = checkIn.getText().toString();
				String dateOut = checkOut.getText().toString();
				String days = tDays.getText().toString();
				String totalBill = total.getText().toString();
				
				File f = new File("assets/data/printBill.dat");
				 
				 if (f.exists()) {
						String dataToWrite = roomNo + "|" + name + "|" + modePay + "|" + dateIn + "|" + dateOut + "|" + days +"|" + totalBill +  "\n";

						try {
							FileWriter fileWriter = new FileWriter(f);
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
				 printBill pb = new printBill();
				 pb.newScreen(true);
				 
							}
			
			 
			
		});
		btnNewButton.setBounds(209, 321, 195, 23);
		frmPaymentsRoyal.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("assets/images/Blue.jpg"));
		lblNewLabel_4.setBounds(0, 0, 585, 371);
		frmPaymentsRoyal.getContentPane().add(lblNewLabel_4);

	}
}
