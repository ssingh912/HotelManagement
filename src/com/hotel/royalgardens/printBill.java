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
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class printBill {

	private JFrame frmInvoice;

	/**
	 * Launch the application.
	 */
	public static void newScreen(boolean b) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					printBill window = new printBill();
					window.frmInvoice.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public printBill() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmInvoice = new JFrame();
		frmInvoice.setTitle("Invoice");
		frmInvoice.setResizable(false);
		frmInvoice.getContentPane().setBackground(Color.WHITE);
		frmInvoice.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/fav_icon.png"));
		frmInvoice.setBounds(100, 100, 804, 780);
		frmInvoice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInvoice.getContentPane().setLayout(null);
		
		JLabel rNo = new JLabel("");
		rNo.setBounds(59, 395, 76, 19);
		frmInvoice.getContentPane().add(rNo);
		
		JLabel cName = new JLabel("");
		cName.setBounds(145, 395, 177, 20);
		frmInvoice.getContentPane().add(cName);
		
		JLabel mPay = new JLabel("");
		mPay.setFont(new Font("Tahoma", Font.BOLD, 11));
		mPay.setBounds(541, 394, 115, 20);
		frmInvoice.getContentPane().add(mPay);
		
		JLabel checkIn = new JLabel("");
		checkIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkIn.setBounds(332, 395, 89, 23);
		frmInvoice.getContentPane().add(checkIn);
		
		JLabel checkOut = new JLabel("");
		checkOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkOut.setBounds(431, 395, 89, 23);
		frmInvoice.getContentPane().add(checkOut);
		
		JLabel total = new JLabel("");
		total.setFont(new Font("Tahoma", Font.BOLD, 11));
		total.setBounds(678, 395, 89, 19);
		frmInvoice.getContentPane().add(total);
		
		JLabel tTax = new JLabel("");
		tTax.setFont(new Font("Tahoma", Font.BOLD, 14));
		tTax.setBounds(644, 600, 109, 19);
		frmInvoice.getContentPane().add(tTax);
		
		JLabel invoiceNo = new JLabel("");
		invoiceNo.setBounds(658, 259, 95, 19);
		frmInvoice.getContentPane().add(invoiceNo);
		
		JLabel cDate = new JLabel("");
		cDate.setBounds(658, 289, 95, 19);
		frmInvoice.getContentPane().add(cDate);
		
		JLabel lblBg = new JLabel("BG");
		lblBg.setIcon(new ImageIcon("assets/images/invoice.png"));
		lblBg.setBounds(0, 0, 867, 801);
		frmInvoice.getContentPane().add(lblBg);
		
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(100000);
		String formatted = String.format("%05d", num); 
		//System.out.println(formatted);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String curDate = (dateFormat.format(date));

		try {
			File f = new File("assets/data/printBill.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {
					Vector<String> row = new Vector<>();

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");

					rNo.setText(fields[0].toString());

					cName.setText(fields[1].toString());
					mPay.setText(fields[2].toString());
					checkIn.setText(fields[3].toString());
					checkOut.setText(fields[4].toString());
					//tDays.setText(fields[5].toString());
					total.setText(fields[6].toString());
					tTax.setText(fields[6].toString());
					invoiceNo.setText(formatted);
					cDate.setText(curDate);
					
				}
				

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
