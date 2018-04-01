package com.hotel.royalgardens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Operations extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operations frame = new Operations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Operations() {
		setTitle("Operations | Royal Garden");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/fav_icon.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Room Booking");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon("assets/images/Button_Booking.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Rooms nw2=new Rooms();
				nw2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(440, 29, 308, 104);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancellation");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancel cn = new Cancel();
				cn.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setIcon(new ImageIcon("assets/images/Button_Cancellation.jpg"));
		btnNewButton_1.setBounds(440, 162, 308, 104);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerList cl = new CustomerList();
				cl.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon("assets/images/Button_Details.jpg"));
		btnNewButton_2.setBounds(440, 298, 308, 104);
		contentPane.add(btnNewButton_2);
		
		JLabel lblBackground = new JLabel("Background");
		lblBackground.setIcon(new ImageIcon("assets/images/Img_6.jpg"));
		lblBackground.setBounds(0, 0, 786, 428);
		contentPane.add(lblBackground);
	}
}
